package com.inveno.hotoday.common.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.util.StringUtils;

/**
 * 
 * @author lyy
 *
 */
public class DateUtil {

	public static final String FORMAT_YYYY_MM_DD_HHMMSS = "yyyy-MM-dd HH:mm:ss";
	public static final String FORMAT_YYYY_MM_DD_HHMMSS_EN = "MM/dd/yyyy HH:mm:ss";
	public static final String FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
	public static final String FORMAT_YYYY_MM_DD_EN = "MM/dd/yyyy";
	public static final String FORMAT_MM_DD_CH = "MM月dd号";
	public static final String FORMAT_MM_DD_CH1 = "MM-dd";
	public static final String FORMAT_YYYY_MM_DD_HHMM = "yyyy-MM-dd HH:mm";
	public static final String REG_EN = "[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}";
	public static final String REG_CN = "[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}";

	/**
	 * 日期到日期的转换
	 */
	public static Date date2date(Date date, String pattern) {
		String str = date2String(date, pattern);
		return string2Date(str, pattern);
	}

	/**
	 * timestamp
	 * 
	 * @param timestamp
	 * @param pattern
	 * @return
	 */
	public static String timestamp2String(Timestamp timestamp, String pattern) {
		if (timestamp == null) {
			throw new java.lang.IllegalArgumentException("timestamp null illegal");
		}
		if (pattern == null || pattern.equals("")) {
			pattern = FORMAT_YYYY_MM_DD_HHMMSS;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(new Date(timestamp.getTime()));
	}

	/**
	 * java.util.Date ת String
	 */
	public static String date2String(java.util.Date date, String pattern) {
		if (date == null) {
			throw new java.lang.IllegalArgumentException("timestamp null illegal");
		}
		if (pattern == null || pattern.equals("")) {
			pattern = FORMAT_YYYY_MM_DD_HHMMSS;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	public static Timestamp currentTimestamp() {
		return new Timestamp(new Date().getTime());
	}

	public static String currentTimestamp2String(String pattern) {
		return timestamp2String(currentTimestamp(), pattern);
	}

	public static Timestamp string2Timestamp(String strDateTime, String pattern) {
		if (strDateTime == null || strDateTime.equals("")) {
			throw new java.lang.IllegalArgumentException("Date Time Null Illegal");
		}
		if (pattern == null || pattern.equals("")) {
			pattern = FORMAT_YYYY_MM_DD_HHMMSS;
		}

		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date date = null;
		try {
			date = sdf.parse(strDateTime);
		} catch (ParseException e) {
			sdf = new SimpleDateFormat(FORMAT_YYYY_MM_DD_HHMMSS_EN);
			try {
				date = sdf.parse(strDateTime);
			} catch (ParseException e1) {
				throw new RuntimeException(e);
			}

		}
		return new Timestamp(date.getTime());
	}

	public static Date string2Date(String strDate, String pattern) {
		if (StringUtils.isEmpty(strDate)) {
			return null;
		}

//		pattern = getPatternByDateStr(strDate);
		//pattern = getPatternByDateStr(strDate);
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date date = null;

		try {
			date = sdf.parse(strDate);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		return date;
	}

	/**
	 * stringToYear
	 * 
	 * @param strDest
	 * @return
	 */
	public static String stringToYear(String strDest) {
		if (strDest == null || strDest.equals("")) {
			throw new java.lang.IllegalArgumentException("str dest null");
		}

		Date date = string2Date(strDest, DateUtil.FORMAT_YYYY_MM_DD);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return String.valueOf(c.get(Calendar.YEAR));
	}

	/**
	 * 
	 * @param strDest
	 * @return
	 */
	public static String stringToMonth(String strDest) {
		if (strDest == null || strDest.equals("")) {
			throw new java.lang.IllegalArgumentException("str dest null");
		}

		Date date = string2Date(strDest, DateUtil.FORMAT_YYYY_MM_DD);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH);
		month = month + 1;
		if (month < 10) {
			return "0" + month;
		}
		return String.valueOf(month);
	}

	/**
	 * 
	 * @param strDest
	 * @return
	 */
	public static String stringToDay(String strDest) {
		if (strDest == null || strDest.equals("")) {
			throw new java.lang.IllegalArgumentException("str dest null");
		}

		Date date = string2Date(strDest, DateUtil.FORMAT_YYYY_MM_DD);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		// return String.valueOf(c.get(Calendar.DAY_OF_MONTH));
		int day = c.get(Calendar.DAY_OF_MONTH);
		if (day < 10) {
			return "0" + day;
		}
		return "" + day;
	}

	/**
	 * 
	 * @param c
	 * @return
	 */
	public static Date getFirstDayOfMonth(Calendar c) {
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = 1;
		c.set(year, month, day, 0, 0, 0);
		return c.getTime();
	}

	/**
	 * 
	 * @param c
	 * @return
	 */
	public static Date getLastDayOfMonth(Calendar c) {
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int day = 1;
		if (month > 11) {
			month = 0;
			year = year + 1;
		}
		c.set(year, month, day - 1, 0, 0, 0);
		return c.getTime();
	}

	/**
	 * 
	 * @param date
	 * @return
	 */
	public static String date2GregorianCalendarString(Date date) {
		if (date == null) {
			throw new java.lang.IllegalArgumentException("Date is null");
		}
		long tmp = date.getTime();
		GregorianCalendar ca = new GregorianCalendar();
		ca.setTimeInMillis(tmp);
		try {
			XMLGregorianCalendar t_XMLGregorianCalendar = DatatypeFactory.newInstance()
					.newXMLGregorianCalendar(ca);
			return t_XMLGregorianCalendar.normalize().toString();
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
			throw new java.lang.IllegalArgumentException("Date is null");
		}

	}

	public static boolean compareDate(Date firstDate, Date secondDate) {
		if (firstDate == null || secondDate == null) {
			throw new java.lang.RuntimeException();
		}

		String strFirstDate = date2String(firstDate, "yyyy-MM-dd");
		String strSecondDate = date2String(secondDate, "yyyy-MM-dd");
		if (strFirstDate.equals(strSecondDate)) {
			return true;
		}
		return false;
	}

	public static Date firstOfQuarter(Date date) {
		if (date == null) {
			throw new java.lang.RuntimeException();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		switch (calendar.get(Calendar.MONTH)) {
		case 0:
		case 1:
		case 2:
			calendar.set(Calendar.MONTH, 0);
			break;
		case 3:
		case 4:
		case 5:
			calendar.set(Calendar.MONTH, 3);
			break;
		case 6:
		case 7:
		case 8:
			calendar.set(Calendar.MONTH, 6);
			break;
		case 9:
		case 10:
		case 11:
			calendar.set(Calendar.MONTH, 9);
			break;
		}

		calendar.set(Calendar.DATE, 1);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return df.parse(df.format(calendar.getTime()));
		} catch (ParseException e) {
			throw new java.lang.RuntimeException();
		}
	}

	public static Date lastOfQuarter(Date date) {
		Date firstDate = firstOfQuarter(date);

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(firstDate);
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 3);

		return calendar.getTime();
	}

	public static Date getLastDayOfMonth(Date date) {
		if (date == null) {
			throw new java.lang.RuntimeException();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DATE, 1);
		calendar.roll(Calendar.DATE, -1);
		return calendar.getTime();
	}

	public static Date getDateAfterMonth(Date date, int amount) {
		if (date == null) {
			throw new java.lang.RuntimeException();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, amount);
		return calendar.getTime();
	}

	public static String getPatternByDateStr(String dateStr) {
		String pattern = FORMAT_YYYY_MM_DD;
		Pattern p = Pattern.compile(REG_EN);
		Matcher matcher = p.matcher(dateStr);
		if (matcher.find()) {
			pattern = DateUtil.FORMAT_YYYY_MM_DD_EN;
		} else {
			p = Pattern.compile(REG_CN);
			matcher = p.matcher(dateStr);
			if (matcher.find()) {
				pattern = DateUtil.FORMAT_YYYY_MM_DD;
			}
		}
		return pattern;
	}

	public static Integer addOneMonth(Integer yearMonth) {
		if ("12".equals(Integer.valueOf(yearMonth).toString().substring(4, 6))) {
			yearMonth = Integer.valueOf(Integer.valueOf(
					Integer.valueOf(Integer.valueOf(yearMonth).toString().substring(0, 4)) + 1)
					.toString()
					+ "01");
		} else {
			yearMonth = yearMonth + 1;
		}

		return yearMonth;
	}

	/**
	 * 取2日期相差天数
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static int getDaysBetweenTwoDays(Date start, Date end) {
		if (null == start || null == end) {
			return 0;
		}
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_YYYY_MM_DD);
			Date s1 = sdf.parse(sdf.format(start));
			Date e1 = sdf.parse(sdf.format(end));
			Calendar cal = Calendar.getInstance();
			cal.setTime(s1);
			long time1 = cal.getTimeInMillis();
			cal.setTime(e1);
			long time2 = cal.getTimeInMillis();
			long days = (time2 - time1) / (1000 * 3600 * 24);
			return Integer.parseInt(String.valueOf(days));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 取2日期相差天数
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static int getHoursBetweenTwoDays(Date start, Date end) {
		if(null == start || null == end){
			return 0;
		}
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_YYYY_MM_DD_HHMMSS);
			Date s1 = sdf.parse(sdf.format(start));
			Date e1 = sdf.parse(sdf.format(end));
			Calendar cal = Calendar.getInstance();
			cal.setTime(s1);
			long time1 = cal.getTimeInMillis();
			cal.setTime(e1);
			long time2 = cal.getTimeInMillis();
			long days = (time2 - time1) / (1000 * 3600);
			System.out.println(days);
			return Math.abs(Integer.parseInt(String.valueOf(days)));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 取2日期相差分钟数
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static int getMinsBetweenTwoTime(Date start, Date end) {
		if (null == start || null == end) {
			return 0;
		}
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_YYYY_MM_DD_HHMMSS);
			Date s1 = sdf.parse(sdf.format(start));
			Date e1 = sdf.parse(sdf.format(end));
			Calendar cal = Calendar.getInstance();
			cal.setTime(s1);
			long time1 = cal.getTimeInMillis();
			cal.setTime(e1);
			long time2 = cal.getTimeInMillis();
			long days = (time2 - time1) / (1000 * 60);
			return Integer.parseInt(String.valueOf(days));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 获取前一天的日期格式为 yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String getYestodayDateStr() {
		SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_YYYY_MM_DD);
		return sdf.format(getYestodayDate());
	}

	/**
	 * 获取之前的时间几天，几小时，几分钟前
	 * day 几天。
	 * hour 几小时
	 * min 几分钟
	 * @return
	 */
	public static String getEarlyTime(int day,int hour,int min)
	{
		Date modifyDate = getEarlyTimeDate(day,hour,min);
		return date2String(modifyDate,FORMAT_YYYY_MM_DD_HHMMSS);
	}
	
	/**
	 * 获取之前的时间几天
	 * day 几天。
	 * @return
	 */
	public static String getEarlyTime(int day)
	{
		Date modifyDate = getEarlyTimeDate(day,0,0);
		return date2String(modifyDate,FORMAT_YYYY_MM_DD);
	}
	
	/**
	 * 
	 * 获取之前的时间几天，几小时，几分钟前
	 * day 几天。
	 * hour 几小时
	 * min 几分钟
	 * @return
	 */
	public static Date getEarlyTimeDate(int day,int hour,int min)
	{
		Date now = new Date();
		Date modifyDate = new Date(now.getTime() - day*24*60*60*1000 - hour*60*60*1000 - min*60*1000);
		return modifyDate;
	}
	
	/**
	 * 获取前一天的日期格式
	 * 
	 * @return
	 */
	public static Date getYestodayDate() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		return cal.getTime();
	}

	/**
	 * 获取前一天的日期格式
	 * 
	 * @return
	 */
	public static Date addDate(Date date, int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, day);
		return cal.getTime();
	}
	
	/**
	 * 加小时
	 * 
	 * @return
	 */
	public static Date addHour(Date date, int hour) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.HOUR, hour);
		return cal.getTime();
	}
	
	/**
	 * 比较2个时间的大于，只比较时和分
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int compareHourAndMin(Date date1, Date date2) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date1);
		int h1 = cal.get(Calendar.HOUR_OF_DAY);
		int m1 = cal.get(Calendar.MINUTE);
		cal.setTime(date2);
		int h2 = cal.get(Calendar.HOUR_OF_DAY);
		int m2 = cal.get(Calendar.MINUTE);

		if (h1 > h2) {
			return 1;
		} else if (h1 < h2) {
			return -1;
		} else if (h1 == h2) {
			if (m1 > m2) {
				return 1;
			} else if (m1 < m2) {
				return -1;
			} else if (m1 == m2) {
				return 0;
			}
		}
		return 0;
	}

	/**
	 * 获取当天的小时数
	 * 
	 * @return
	 */
	public static int getHourOfDay() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.HOUR_OF_DAY);
	}
	
	/**
	 * 得到本周的星期一
	 * @return
	 */
	public static Date getMonday(){
		Calendar cal = Calendar.getInstance();
		int day =  cal.get(Calendar.DAY_OF_WEEK);
		if(day == 1){
			//星期天
			return addDate(cal.getTime(), -6);
		}
		if(day == 7){
			//星期六
			return addDate(cal.getTime(), -5);
		}
		if(day == 6){
			//星期五
			return addDate(cal.getTime(), -4);
		}
		if(day == 5){
			//星期四
			return addDate(cal.getTime(), -3);
		}
		if(day == 4){
			//星期三
			return addDate(cal.getTime(), -2);
		}
		if(day == 3){
			//星期二
			return addDate(cal.getTime(), -1);
		}
		if(day == 2){
			//星期一
			return addDate(cal.getTime(), 0);
		}
		return new Date();
	}

	/**
	 * 得到本周的星期天
	 * @return
	 */
	public static Date getSunday(){
		Calendar cal = Calendar.getInstance();
		int day =  cal.get(Calendar.DAY_OF_WEEK);
		if(day == 1){
			//星期天
			return addDate(cal.getTime(), 0);
		}
		if(day == 7){
			//星期六
			return addDate(cal.getTime(), 1);
		}
		if(day == 6){
			//星期五
			return addDate(cal.getTime(), 2);
		}
		if(day == 5){
			//星期四
			return addDate(cal.getTime(), 3);
		}
		if(day == 4){
			//星期三
			return addDate(cal.getTime(), 4);
		}
		if(day == 3){
			//星期二
			return addDate(cal.getTime(), 5);
		}
		if(day == 2){
			//星期一
			return addDate(cal.getTime(), 6);
		}
		return new Date();
	}

	public static void main(String[] args) {}

}