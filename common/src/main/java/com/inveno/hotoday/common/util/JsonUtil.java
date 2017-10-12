package com.inveno.hotoday.common.util;

import java.lang.reflect.Modifier;

import net.sf.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Json 的工具类
 */
public class JsonUtil {

	public static final GsonBuilder gsonBuilder = new GsonBuilder();

	public static final Gson gson = gsonBuilder
			.setDateFormat("yyyy-MM-dd HH:mm:ss")
			.excludeFieldsWithModifiers(Modifier.STATIC, Modifier.TRANSIENT,
					Modifier.VOLATILE).disableHtmlEscaping().create();

	public static String objToString(Object obj) {
		if(obj == null)
			return "";
		JSONObject json = JSONObject.fromObject(obj);
		return json.toString();
	}
	
	public static String objToStr(Object obj)
	{
		if(obj == null)
			return "";
		return gson.toJson(obj);
	}

	/**
	 * 把json转换成bean
	 *  Description:
	 *  @author liyuanyi  DateTime 2016年9月9日 下午3:16:28
	 *  @param json
	 *  @param clazz
	 *  @return
	 */
	public static <T> T build(String json, Class<T> clazz) {
		T model = gson.fromJson(json, clazz);
		return model;
	}

}
