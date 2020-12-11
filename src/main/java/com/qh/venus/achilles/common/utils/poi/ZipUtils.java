package com.qh.venus.achilles.common.utils.poi;

import cn.hutool.core.collection.CollectionUtil;
import com.google.common.io.ByteStreams;
import com.qh.venus.achilles.common.utils.ObjectUtil;
import tk.mybatis.mapper.util.StringUtil;

import java.io.*;
import java.util.Collections;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;


public class ZipUtils {
    /**
     * 替换某个 item,
     *
     * @param zipInputStream  zip文件的zip输入流
     * @param zipOutputStream 输出的zip输出流
     * @param itemName        要替换的 item 名称
     * @param itemInputStream 要替换的 item 的内容输入流
     */
    public static void replaceItem(ZipInputStream zipInputStream,
                                   ZipOutputStream zipOutputStream,
                                   String itemName,
                                   InputStream itemInputStream
    ) {
        //
        if (null == zipInputStream) {
            return;
        }
        if (null == zipOutputStream) {
            return;
        }
        if (null == itemName) {
            return;
        }
        if (null == itemInputStream) {
            return;
        }
        //
        ZipEntry entryIn;
        try {
            while ((entryIn = zipInputStream.getNextEntry()) != null) {
                String entryName = entryIn.getName();
                ZipEntry entryOut = new ZipEntry(entryName);
                // 只使用 name
                zipOutputStream.putNextEntry(entryOut);
                // 缓冲区
                byte[] buf = new byte[8 * 1024];
                int len;

                if (entryName.equals(itemName)) {
                    // 使用替换流
                    while ((len = (itemInputStream.read(buf))) > 0) {
                        zipOutputStream.write(buf, 0, len);
                    }
                } else {
                    // 输出普通Zip流
                    while ((len = (zipInputStream.read(buf))) > 0) {
                        zipOutputStream.write(buf, 0, len);
                    }
                }
                // 关闭此 entry
                zipOutputStream.closeEntry();

            }
        } catch (IOException e) {
            e.printStackTrace();
            close(zipInputStream);
            close(zipOutputStream);
        } finally {
            close(itemInputStream);
        }
    }

    public static void replaceItem(ZipInputStream zipInputStream,
                                   ZipOutputStream zipOutputStream,
                                   Map<String,InputStream> replaceItemMap
    ) {
        //
        if (null == zipInputStream) {
            return;
        }
        if (null == zipOutputStream) {
            return;
        }
        if (CollectionUtil.isEmpty(replaceItemMap)) {
            return;
        }
        //
        ZipEntry entryIn;
        try {
            while ((entryIn = zipInputStream.getNextEntry()) != null) {
                String entryName = entryIn.getName();
                ZipEntry entryOut = new ZipEntry(entryName);
                // 只使用 name
                zipOutputStream.putNextEntry(entryOut);
                // 缓冲区
                byte[] buf = new byte[8 * 1024];
                int len;
                if (replaceItemMap.containsKey(entryName)) {
                    InputStream itemInputStream =  replaceItemMap.get(entryName);
                    // 使用替换流
                    while ((len = (itemInputStream.read(buf))) > 0) {
                        zipOutputStream.write(buf, 0, len);
                    }
                } else {
                    // 输出普通Zip流
                    while ((len = (zipInputStream.read(buf))) > 0) {
                        zipOutputStream.write(buf, 0, len);
                    }
                }
                // 关闭此 entry
                zipOutputStream.closeEntry();

            }
        } catch (IOException e) {
            e.printStackTrace();
            close(zipInputStream);
            close(zipOutputStream);
        } finally {
        }
    }
    /**
     * 添加某个 item,
     *
     * @param zipInputStream  zip文件的zip输入流
     * @param zipOutputStream 输出的zip输出流
     * @param itemName        要添加的 item 名称
     * @param itemInputStream 要添加的 item 的内容输入流
     */
    public static void addItem(ZipInputStream zipInputStream,
                                   ZipOutputStream zipOutputStream,
                                   String itemName,
                                   InputStream itemInputStream
    ) {
        //
        if (null == zipInputStream) {
            return;
        }
        if (null == zipOutputStream) {
            return;
        }
        if (null == itemName) {
            return;
        }
        if (null == itemInputStream) {
            return;
        }
        try {
            ZipEntry addZipEntry = new ZipEntry(itemName);
            zipOutputStream.putNextEntry(addZipEntry);
            byte[] buffer = new byte[1024];
            int len;
            while ((len = itemInputStream.read(buffer)) != -1) {
                zipOutputStream.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
            close(zipInputStream);
            close(zipOutputStream);
        } finally {
            close(itemInputStream);
        }
    }

    public static ZipOutputStream toZipOutputStream(ZipInputStream zipInputStream) throws IOException {
        if (ObjectUtil.isEmpty(zipInputStream)){
            return null;
        }
        ZipOutputStream zos = new ZipOutputStream(new ByteArrayOutputStream());
        ZipEntry currentEntry;
        byte[] buffer = new byte[8192];
        while ((currentEntry = zipInputStream.getNextEntry()) != null){
            ZipEntry newEntry = new ZipEntry(currentEntry.getName());
            zos.putNextEntry(newEntry);
            int length;
            while ((length = zipInputStream.read(buffer)) > 0) {
                zos.write(buffer, 0, length);
            }
            zos.closeEntry();
        }
        zos.finish();
        zos.close();
        return zos;
    }
    /**
     * 包装输入流
     */
    public static ZipInputStream wrapZipInputStream(InputStream inputStream) {
        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
        return zipInputStream;
    }

    /**
     * 包装输出流
     */
    public static ZipOutputStream wrapZipOutputStream(OutputStream outputStream) {
        ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);
        return zipOutputStream;
    }

    public static void close(InputStream inputStream) {
        if (null != inputStream) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(OutputStream outputStream) {
        if (null != outputStream) {
            try {
                outputStream.flush();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
