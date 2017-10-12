package com.inveno.hotoday.common.util;

import java.util.Arrays;

import org.springframework.util.StringUtils;

public class RouteUtil {
	
	public final static String GATE_WEB = "gateweb/";
	
	/**
	 * 根据传入的url，截取出访问的class和method
	 * 其中str[0] 为 子系统的子模块
	 * str[1] 为method
	 * 
	 * 一般正常的路径为：
	 * 
	 * gateweb/子系统名字(user/pushserver/searchserver)/子系统的子模块/方法
	 * 
	 * 或者：
	 * 
	 * gateweb/子系统名字(user/pushserver/searchserver)/方法
	 * 
	 * 例子：
	 * http://xz.hotoday.in/gateweb/user/coll/collection
	 * 
	 * 子系统模块可以为空。 method不能为空
	 * 
	 *  @author liyuanyi  DateTime 2016年7月19日 下午2:03:08
	 *  @param url
	 *  @return  
	 */
	public static String[] getUrlMethodName(String url)
	{
		if(StringUtils.isEmpty(url) || !url.contains(GATE_WEB))
			return null;
		String[] class_method_array = new String[2];
		String url_suffix = url.substring(url.lastIndexOf(GATE_WEB), url.length()).replace(GATE_WEB, "");
		String[] suffixArray = url_suffix.split("/");
		if(suffixArray == null)
		{
			return null;
		}
		else
		{
			if(suffixArray.length == 2)
			{
				class_method_array[0] = suffixArray[0];
				class_method_array[1] = suffixArray[1];
			}
			else if(suffixArray.length == 3)
			{
				class_method_array[0] = suffixArray[1];
				class_method_array[1] = suffixArray[2];
			}
			else
				return null;
		}
		return class_method_array;
	}
	
	public static void main(String[] args) {
		String url = "http://gateweb/gateweb/push/bindtoken";
		System.out.println(Arrays.toString(getUrlMethodName(url)));
	}

}
