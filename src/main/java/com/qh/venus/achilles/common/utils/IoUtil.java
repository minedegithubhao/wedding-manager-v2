package com.qh.venus.achilles.common.utils;

import java.io.*;

/**
 * @author liqiang
 */
public class IoUtil {
    public static OutputStream toOutputStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        int ch;
        while ((ch = inputStream.read()) != -1) {
            swapStream.write(ch);
        }
        return swapStream;
    }
    public static InputStream toInputStream(OutputStream out) throws IOException {
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        baos=(ByteArrayOutputStream) out;
        ByteArrayInputStream swapStream = new ByteArrayInputStream(baos.toByteArray());
        return swapStream;
    }
}
