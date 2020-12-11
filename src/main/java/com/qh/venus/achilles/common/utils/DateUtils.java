package com.qh.venus.achilles.common.utils;

import java.lang.management.ManagementFactory;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * @Title: 时间工具类
 * @Description:
 * @author zf
 * @date 2020-03-30 10:46:23
 * @version V1.0
 * @Copyright 版权所有 ( c ) 。保留所有权利。
 * @Company
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {
	public static String YYYY = "yyyy";

	public static String YYYY_MM = "yyyy-MM";

	public static String YYYY_MM_DD = "yyyy-MM-dd";

	public static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

	public static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

	private static String[] parsePatterns = { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
			"yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM", "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss",
			"yyyy.MM.dd HH:mm", "yyyy.MM", "yyyyMMddHHmmss","yyyyMMdd","HHmmss" };

	/**
	 * 获取当前Date型日期
	 * 
	 * @return Date() 当前日期
	 */
	public static Date getNowDate() {
		return new Date();
	}

	/**
	 * 获取当前日期, 默认格式为yyyy-MM-dd
	 * 
	 * @return String
	 */
	public static String getDate() {
		return dateTimeNow(YYYY_MM_DD);
	}

	public static final String getTime() {
		return dateTimeNow(YYYY_MM_DD_HH_MM_SS);
	}

	public static final String dateTimeNow() {
		return dateTimeNow(YYYYMMDDHHMMSS);
	}

	public static final String dateTimeNow(final String format) {
		return parseDateToStr(format, new Date());
	}

	public static final String dateTime(final Date date) {
		return parseDateToStr(YYYY_MM_DD, date);
	}

	public static final String parseDateToStr(final String format, final Date date) {
		return new SimpleDateFormat(format).format(date);
	}

	public static final Date dateTime(final String format, final String ts) {
		try {
			return new SimpleDateFormat(format).parse(ts);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 日期路径 即年/月/日 如2018/08/08
	 */
	public static final String datePath() {
		Date now = new Date();
		return DateFormatUtils.format(now, "yyyy/MM/dd");
	}

	/**
	 * 日期路径 即年/月/日 如20180808
	 */
	public static final String dateTime() {
		Date now = new Date();
		return DateFormatUtils.format(now, "yyyyMMdd");
	}

	/**
	 * 日期型字符串转化为日期 格式
	 */
	public static Date parseDate(Object str) {
		if (str == null) {
			return null;
		}
		try {
			return parseDate(str.toString(), parsePatterns);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 获取服务器启动时间
	 */
	public static Date getServerStartDate() {
		long time = ManagementFactory.getRuntimeMXBean().getStartTime();
		return new Date(time);
	}

	/**
	 * 计算两个时间差
	 */
	public static String getDatePoor(Date endDate, Date nowDate) {
		long nd = 1000 * 24 * 60 * 60;
		long nh = 1000 * 60 * 60;
		long nm = 1000 * 60;
		// long ns = 1000;
		// 获得两个时间的毫秒时间差异
		long diff = endDate.getTime() - nowDate.getTime();
		// 计算差多少天
		long day = diff / nd;
		// 计算差多少小时
		long hour = diff % nd / nh;
		// 计算差多少分钟
		long min = diff % nd % nh / nm;
		// 计算差多少秒//输出结果
		// long sec = diff % nd % nh % nm / ns;
		return day + "天" + hour + "小时" + min + "分钟";
	}

	/**
	 * 将日期类型转换为字符串的形式
	 *
	 * @param dateFormat
	 *            转换后的格式
	 * @param date
	 *            需要转换的日期
	 * @return 转换后的字符串
	 * @throws java.lang.IllegalArgumentException
	 */
	public static String dateToString(String dateFormat, java.util.Date date)
			throws java.lang.IllegalArgumentException {
		if (dateFormat == null || dateFormat.equals("")) {
			throw new java.lang.IllegalArgumentException("parameter dateFormat is not valid");
		}
		if (date == null) {
			throw new java.lang.IllegalArgumentException("parameter date is not valid");
		}
		SimpleDateFormat formater = new SimpleDateFormat(dateFormat);
		return formater.format(date);

	}

	/**
	 * 获取指定日期在一个星期中为第几天
	 *
	 * @param date
	 *            yyyyMMdd形式的日期字符串
	 * @return
	 * @throws ParseException
	 *             如果日期字符串开始的字符串无法转化时抛出
	 */
	public static int dayOfWeek(String date) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(format.parse(date));
		int offset = calendar.get(Calendar.DAY_OF_WEEK);
		if (offset == 1) {
			return 7;
		} else {
			return offset - 1;
		}
	}

	/**
	 * 计算【起始日期】 的【所隔天数】的到期日 【按实际天数计算】
	 *
	 * @param date
	 *            起始日期
	 * @param num
	 *            所隔天数
	 * @return 到期日期
	 * @throws Exception 
	 */
	public static String pubDeadLineDay(String date, int num) throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cd = Calendar.getInstance();
		String dqDate;
		try {
			cd.setTime(df.parse(date));
			cd.add(Calendar.DATE, num);
			dqDate = df.format(cd.getTime());
		} catch (ParseException e) {
			throw new Exception("日期转换失败！");
		}
		return dqDate;
	}

	public static String dateToStr(Date data, String formatType) {
		return new SimpleDateFormat(formatType).format(data);
	}

	public static String longToString(long currentTime, String formatType)
			throws ParseException {
		Date date = longToDate(currentTime, formatType); // long类型转成Date类型
		String strTime = dateToStr(date, formatType); // date类型转成String
		return strTime;
	}
	public static Date longToDate(long currentTime, String formatType)
			throws ParseException {
		Date dateOld = new Date(currentTime); // 根据long类型的毫秒数生命一个date类型的时间
		String sDateTime = dateToStr(dateOld, formatType); // 把date类型的时间转换为string
		Date date = stringToDate(sDateTime, formatType); // 把String类型转换为Date类型
		return date;
	}
	public static Date stringToDate(String strTime, String formatType)
			throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat(formatType);
		Date date = null;
		date = formatter.parse(strTime);
		return date;
	}

	public static void main(String[] args) throws Exception {
	System.out.println(pubDeadLineDay("2019-07-01", -1));
}
}
