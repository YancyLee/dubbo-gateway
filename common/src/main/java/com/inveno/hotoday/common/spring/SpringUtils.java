package com.inveno.hotoday.common.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

/**
 * spring 工具类，可以通过该工具类获取spring容器的对象
 *  Class Name: SpringUtils.java
 *  Description: 
 *  @author liyuanyi  DateTime 2016年10月28日 下午4:33:29 
 *  @company inveno 
 *  @version 1.0
 */
public class SpringUtils implements ApplicationContextAware{
	
	private static ApplicationContext applicationContext;
	
	/**
	 * 获取spring容器的对象
	 *  Description:
	 *  @author liyuanyi  DateTime 2016年10月28日 下午4:34:22
	 *  @param beanName
	 *  @return
	 */
	public static <T> T getBean(String beanName)
	{
		return (T)applicationContext.getBean(beanName);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}
}
