package com.inveno.hotoday.common.util;

import java.lang.reflect.Method;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class ParamUtil {
	
	public final static Logger logger = Logger.getLogger(ParamUtil.class);
	
	public static String getParamFromBean(Object o,List<String> paramsName)
	{
		StringBuffer paramsStr = new StringBuffer();
		Class<?> class_ = o.getClass();
		Method[] methods = class_.getMethods();
		for(String param:paramsName)
		{
			try 
			{
				Method method = class_.getMethod("get"+StringUtil.toUpperCaseFirstOne(param),null);
				String value =  (String)method.invoke(o, null);
				paramsStr.append(param+"="+value+"&");
			} 
			catch (Exception e) 
			{
				logger.error(e,e);
			}
		}
		return StringUtils.isNotEmpty(paramsStr.toString())?paramsStr.substring(0, paramsStr.length() -1).toString():paramsStr.toString();
	}

}
