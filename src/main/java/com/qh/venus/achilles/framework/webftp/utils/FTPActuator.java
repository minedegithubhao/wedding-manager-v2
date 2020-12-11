package com.qh.venus.achilles.framework.webftp.utils;

import com.qh.venus.achilles.framework.webftp.pojo.FTPEntity;
import com.qh.venus.achilles.framework.webftp.pool.FTPClientFactory;
import com.qh.venus.achilles.framework.webftp.pool.FTPClientPool;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPFileFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.StringTokenizer;

//@Component
public class FTPActuator {

//    /**
//     * FTP的连接池
//     */
//    @Autowired
//    public static FTPClientPool ftpClientPool;
    /**
     * FTPClient对象
     */
    public FTPClient ftpClient;


    private FTPClientFactory fTPClientFactory;

    public FTPActuator(FTPEntity ftpProperties) {
        init(ftpProperties);
    }

    /**
     * 初始化设置
     * @return
     */
//    @PostConstruct
    public boolean init(FTPEntity ftpProperties) {
        FTPClientFactory factory = new FTPClientFactory(ftpProperties);
        fTPClientFactory = factory;
//        try {
//            ftpClientPool = new FTPClientPool(factory);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
        return true;
    }

    /**
     * 切换目录
     */
    public String changeWorkingDirectory(String fileUrl) {
        String currentPath = null;
        try {
            if (ftpClient.changeWorkingDirectory(fileUrl)) {
                currentPath = ftpClient.printWorkingDirectory();
            }
        } catch (IOException e) {
            disconnect();
            e.printStackTrace();
        }
        return currentPath;
    }

    /**
     * 获取连接对象
     * @return
     * @throws Exception
     */
    public FTPClient getFTPClient() throws Exception {
        if (ftpClient==null) {
           ftpClient = fTPClientFactory.makeObject();
        }
        return ftpClient;
//        //初始化的时候从队列中取出一个连接
//        if (ftpClient==null) {
//            synchronized (ftpClientPool) {
//                ftpClient = ftpClientPool.borrowObject();
//            }
//        }
//        return ftpClient;
    }


    /**
     * 当前命令执行完成命令完成
     * @throws IOException
     */
    public void complete() throws IOException {
        ftpClient.completePendingCommand();
    }

    /**
     *  // 当前线程任务处理完成，加入到队列的最后
     *  当前任务处理完成，关闭连接
     * @return
     */
    public void disconnect() {
//        ftpClientPool.addObject(ftpClient);
        try {
            fTPClientFactory.destroyObject(ftpClient);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Description: 向FTP服务器上传文件
     *
     * @Version1.0
     * @param remoteFile
     *            上传到FTP服务器上的文件名
     * @param input
     *            本地文件流
     * @return 成功返回true，否则返回false
     */
    public boolean uploadFile(String remoteFile, InputStream input)  {
        boolean result = false;
        try {
            getFTPClient();
            ftpClient.enterLocalPassiveMode();
            result = ftpClient.storeFile(remoteFile, input);
            input.close();
//            ftpClient.disconnect();
        } catch (Exception e) {
            disconnect();
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Description: 向FTP服务器上传文件
     *
     * @Version1.0
     * @param remoteFile
     *            上传到FTP服务器上的文件名
     * @param localFile
     *            本地文件
     * @return 成功返回true，否则返回false
     */
    public boolean uploadFile(String remoteFile, String localFile){
        FileInputStream input = null;
        try {
            input = new FileInputStream(new File(localFile));
        } catch (FileNotFoundException e) {
            disconnect();
            e.printStackTrace();
        }
        return uploadFile(remoteFile, input);
    }

    /**
     * 拷贝文件
     * @param fromFile
     * @param toFile
     * @return
     * @throws Exception
     */
    public boolean copyFile(String fromFile, String toFile) throws Exception {
        InputStream in=getFileInputStream(fromFile);
        getFTPClient();
        boolean flag = ftpClient.storeFile(toFile, in);
        in.close();
        return flag;
    }

    /**
     * 获取文件输入流
     * @param fileName
     * @return
     * @throws IOException
     */
    public InputStream getFileInputStream(String fileName) throws Exception {
        ByteArrayOutputStream fos=new ByteArrayOutputStream();
        getFTPClient();
        ftpClient.retrieveFile(fileName, fos);
        ByteArrayInputStream in=new ByteArrayInputStream(fos.toByteArray());
        fos.close();
        return in;
    }

    /**
     * Description: 从FTP服务器下载文件
     *
     * @Version1.0
     * @return
     */
    public boolean downFile(String remoteFile, String localFile){
        boolean result = false;
        try {
            getFTPClient();
            OutputStream os = new FileOutputStream(localFile);
            ftpClient.retrieveFile(remoteFile, os);
            result = true;
        } catch (Exception e) {
            disconnect();
            e.printStackTrace();
        } finally {
            try {
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 从ftp中获取文件流
     * @param filePath
     * @return
     * @throws Exception
     */
    public InputStream getInputStream(String filePath) throws Exception {
        getFTPClient();
        InputStream inputStream = ftpClient.retrieveFileStream(filePath);
        return inputStream;
    }

    /**
     * ftp中文件重命名
     * @param fromFile
     * @param toFile
     * @return
     * @throws Exception
     */
    public boolean rename(String fromFile,String toFile) throws Exception {
        getFTPClient();
        boolean result = ftpClient.rename(fromFile,toFile);
        return result;
    }

    /**
     * 获取ftp目录下的所有文件
     * @param dir
     * @return
     */
    public FTPFile[] getFiles(String dir) throws Exception {
        getFTPClient();
        FTPFile[] files = new FTPFile[0];
        try {
            files = ftpClient.listFiles(dir);
        }catch (Throwable thr){
            disconnect();
            thr.printStackTrace();
        }
        return files;
    }

    /**
     * 获取ftp目录下的某种类型的文件
     * @param dir
     * @param filter
     * @return
     */
    public FTPFile[] getFiles(String dir, FTPFileFilter filter) throws Exception {
        getFTPClient();
        FTPFile[] files = new FTPFile[0];
        try {
            files = ftpClient.listFiles(dir, filter);
        }catch (Throwable thr){
            disconnect();
            thr.printStackTrace();
        }
        return files;
    }

    /**
     * 创建文件夹
     * @param remoteDir
     * @return 如果已经有这个文件夹返回false
     */
    public boolean makeDirectory(String remoteDir) throws Exception {
        getFTPClient();
        boolean result = false;
        try {
            result = ftpClient.makeDirectory(remoteDir);
        } catch (IOException e) {
            disconnect();
            e.printStackTrace();
        }
        return result;
    }

    public boolean mkdirs(String dir) throws Exception {
        boolean result = false;
        if (null == dir) {
            return result;
        }
        getFTPClient();
        ftpClient.changeWorkingDirectory("/");
        StringTokenizer dirs = new StringTokenizer(dir, "/");
        String temp = null;
        while (dirs.hasMoreElements()) {
            temp = dirs.nextElement().toString();
            //创建目录
            ftpClient.makeDirectory(temp);
            //进入目录
            ftpClient.changeWorkingDirectory(temp);
            result = true;
        }
        ftpClient.changeWorkingDirectory("/");
        return result;
    }
}