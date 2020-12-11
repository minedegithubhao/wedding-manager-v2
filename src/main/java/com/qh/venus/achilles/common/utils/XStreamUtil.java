package com.qh.venus.achilles.common.utils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.naming.NoNameCoder;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.xml.sax.InputSource;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;

/**
 * XStream工具类，用于把实体对象转换为XML字符串以及把XML字符串映射为Java实体对象
 *
 * @Since 2018-08-25
 * @author libin
 */
public class XStreamUtil {

    private static XStream xStream = null;

    /**
     *  通过静态内部类实现单例模式
     */
    private static class LazyHolder {
        private static final XStreamUtil INSTANCE = new XStreamUtil();
    }

    static{
        if(xStream == null){
            xStream = new XStream(new XppDriver(new NoNameCoder()));
            xStream.aliasSystemAttribute(null,"class");//去掉class属性
            xStream.autodetectAnnotations(true);//自动探测注解
            xStream.ignoreUnknownElements();//忽略未知元素

            XStream.setupDefaultSecurity(xStream);  //避免出现以下警告:Security framework of XStream not initialized, XStream is probably vulnerable
        }
    }
    private XStreamUtil(){}

    /**
     * 取得XStreamUtil实例
     * @return
     */
    public static final XStreamUtil getInstance(){
        return LazyHolder.INSTANCE;
    }

    /**
     * 取得XStream
     * @return
     */
    public static XStream getXStream(){
        return xStream;
    }

    public static void setxStream(XStream xStream) {
        XStreamUtil.xStream = xStream;
    }

    /**
     * 与XStream.setupDefaultSecurity使用，为显式类型添加安全权限，避免抛出Security framework of XStream not initialized, 
         XStream is probably vulnerable异常信息
     * @param classes
     */
    public void setXStreamAllowTypes(Class[] classes){
        xStream.allowTypes(classes);
    }


    /**
     * 若使用注解,在XML字符串映射为Java实体对象时，则一定要调用此方法.
     * @param types
     */
    public void setXStremProcessAnnotations(Class[] types){
        xStream.processAnnotations(types);
    }

    /**
     *  把实体对象转换为XML字符串
     * @param pojo
     * @return
     */
    public String pojoToXml(Object pojo){
        if(null == pojo){
            return "";
        }
        try{
            String top = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n";
            String xmlStr = top+xStream.toXML(pojo);
            System.out.println("生成的xml字符串如下:"+xmlStr);
            return xmlStr;
        }catch(Exception e){
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 把实体对象转换为XML字符串并保存至指定文件中
     * @param obj
     * @param file
     */
    public void pojoToXmlFile(Object obj,File file){
        try{
            String xmlStr =  pojoToXml(obj);
            pojoToXmlFile(xmlStr,file);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    /**
     *  使用同步类 Transformer,将 xml 字符串保存到文件中
     * @param xml
     * @param file
     * @throws Exception
     */
    private  void pojoToXmlFile(String xml,File file) throws Exception{
        Transformer transformer = TransformerFactory.newInstance().newTransformer();

        // 将字符串xml转为Source对象
        InputSource is = new InputSource(new ByteArrayInputStream(xml.getBytes()));
        Source xmlSource = new SAXSource(is);
        // 同步操作
        transformer.transform(xmlSource, new StreamResult(file));
    }


    /**
     * 从XML字符串反序列化一个对象
     * @param xmlStr
     * @return
     */
    public <T> T xmlToPojo(String xmlStr,Class<T> cls){
        if(null == xmlStr || xmlStr.length() == 0){
            return null;
        }
        try{
            T object = (T) xStream.fromXML(xmlStr);
            return object;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 从XML Reader反序列化一个对象
     * @param reader
     * @return
     */
    public <T> T xmlToPojo(Reader reader,Class<T> cls){
        if(null == reader ){
            return null;
        }
        try{
            T object = (T) xStream.fromXML(reader);
            return object;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 从一个XML InputStream.中反序列化一个对象
     * @param input
     * @return
     */
    public <T> T xmlToPojo(InputStream input,Class<T> cls){
        if(null == input){
            return null;
        }
        try{
            T object = (T) xStream.fromXML(input);
            return object;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 从一个URL中反序列化一个对象
     * @param url
     * @return
     */
    public <T> T  xmlToPojo(URL url,Class<T> cls){
        if(null == url){
            return null;
        }
        try{
            T object =(T)xStream.fromXML(url);
            return object;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 从一个File中反序列化一个对象
     * @param file
     * @param cls
     * @param <T>
     * @return
     */
    public <T> T xmlToPojo(File file,Class<T> cls){
        if(null == file){
            return null;
        }
        try{
           T object = (T)xStream.fromXML(file);
           return object;
        }catch(Exception e ){
            e.printStackTrace();
        }
        return null;
    }


}