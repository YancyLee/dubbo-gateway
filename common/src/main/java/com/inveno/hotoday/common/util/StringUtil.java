package com.inveno.hotoday.common.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;

/**   
 * @Title: StringUtil.java 
 * @Package com.inveno.hotoday.common.util 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author Michael Shan
 * @date 2016年7月14日 下午5:26:56 
 * @version v1.0.0
 */

public class StringUtil {
	public static String intToHexString(int number) {
		String hexString = Integer.toHexString(number);
		StringBuffer buffer = new StringBuffer(hexString);
		while (buffer.length() < 8) {
			buffer.insert(0, "0");
		}
		
		hexString = "0x" + buffer.toString();
		return hexString;
	}
	
	public static String timestampToString(long time, String format) {
		Timestamp ts = new Timestamp(time);
        String tsStr = "";
        DateFormat sdf = new SimpleDateFormat(format);   
        try {   
            tsStr = sdf.format(ts);   
        } catch (Exception e) {   
            e.printStackTrace();
        }

        return tsStr;
	}
	
	//首字母转小写
    public static String toLowerCaseFirstOne(String s){
        if(Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }
    //首字母转大写
    public static String toUpperCaseFirstOne(String s){
        if(Character.isUpperCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
    }
	
	public static void main(String[] args) {
		String ret = StringUtil.timestampToString(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss.s");
		String ret2 = StringUtil.timestampToString((long)1463133284*1000, "yyyy-MM-dd HH:mm:ss.s");
		
//		System.out.println(ret);
//		System.out.println(System.currentTimeMillis());
	}
}
