package com.qh.venus.achilles.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XmlBlank {
    private static final Logger logger = LoggerFactory.getLogger(XmlBlank.class);

    public static String read(File file) throws IOException {
        String s = "";
        InputStreamReader in = new InputStreamReader(new FileInputStream(file), "UTF-8");
        BufferedReader br = new BufferedReader(in);
        StringBuffer content = new StringBuffer();
        while ((s = br.readLine()) != null) {
            content = content.append(s);
        }
        return content.toString();
    }

    public static void main(String[] args) {


        try {

            //spring boot中文件直接放在resources目录下
            String s2 = XmlBlank.read(ResourceUtils.getFile("classpath:report/document_tmp.xml"));
            String strxml = replaceAllBlank(s2);

            logger.info(s2);

            File f = new File("D:/document.xml");//新建一个文件对象，如果不存在则创建一个该文件
            FileWriter fw;
            fw = new FileWriter(f);
            fw.write(strxml);//将字符串写入到指定的路径下的文件中
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * s+ 一个或者多个空格
     * (?<=>).*?(?=<) 两个尖括号之间的字符>AB C <
     * @param str
     * @return
     */
    public static String replaceAllBlank(String str) {
        String s = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s+");
            Matcher m = p.matcher(str);
            s = m.replaceAll(" ");
        }
        return s;
    }
}