package com.inveno.hotoday.common.util;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *  线程安全的对象转JSON
 *  Class Name: ObjectMapperFactory.java
 *  Description: 
 *  @author liyuanyi  DateTime 2016年8月3日 下午6:41:47 
 *  @company inveno 
 *  @version 1.0
 */
public final class ObjectMapperUtil {
	
	
	public static final ThreadLocal<ObjectMapper> objectMappers = new ThreadLocal<ObjectMapper>();
	
	private final static Logger logger = Logger.getLogger(ObjectMapperUtil.class);
	
	public static ObjectMapper getObjectMapper()
	{
		ObjectMapper objectMapper = objectMappers.get();
		if(objectMapper == null)
		{
			objectMapper = new ObjectMapper();
			objectMapper.setSerializationInclusion(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL);
			objectMappers.set(objectMapper);
		}
		return objectMapper;
	}
	
	public static <T> String objectTurnJson(T object)
	{
		if(object instanceof String)
			return object.toString();
		ObjectMapper objectMapper = getObjectMapper();
		String resultJson = "";
		try 
		{
			resultJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
		} 
		catch (JsonProcessingException e) 
		{
			logger.error(e,e);
		}
		return resultJson;
	}

}
