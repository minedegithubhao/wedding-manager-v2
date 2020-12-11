package com.qh.venus.achilles.common.utils;

import org.quartz.TriggerUtils;
import org.quartz.impl.triggers.CronTriggerImpl;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zf
 * @version V1.0
 * @Title:高频方法集合类
 * @Description:
 * @date 2020-03-30 10:46:23
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
public class ToolUtil {
    /**
     * 获取临时目录
     *
     * @author zmr
     */
    public static String getTempPath() {
        return System.getProperty("java.io.tmpdir");
    }

    /**
     * 获取当前项目工作目录
     *
     * @return
     * @author zmr
     */
    public static String getUserDir() {
        return System.getProperty("user.dir");
    }

    /**
     * 获取临时下载目录
     *
     * @return
     * @author zmr
     */
    public static String getDownloadPath() {
        return getTempPath() + File.separator + "download" + File.separator;
    }

    public static List<String> getNextExecTime(String cronExpression, Integer numTimes) {
        List<String> list = new ArrayList<>();
        CronTriggerImpl cronTriggerImpl = new CronTriggerImpl();
        try {
            cronTriggerImpl.setCronExpression(cronExpression);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 这个是重点，一行代码搞定
        List<Date> dates = TriggerUtils.computeFireTimes(cronTriggerImpl, null, numTimes);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (Date date : dates) {
            list.add(dateFormat.format(date));
        }
        return list;
    }

	/**
	 *  校验IP端口是否连通
	 * @param ip
	 * @param port
	 * @return
	 */
    public static boolean validConnectByIpPort(String ip,int port) {
        Socket socket = new Socket();
        long t1 = 0;
        boolean valid = true;
        try {
            t1 = System.currentTimeMillis();
            // 设置connect timeout 为2000毫秒
            socket.connect(new InetSocketAddress(ip,port), 10);
        } catch (IOException e) {
            valid = false;
            long t2 = System.currentTimeMillis();
            System.out.println("Connect failed, take time -> " + (t2 - t1) + "ms.");
        }
        return valid;
    }
}
