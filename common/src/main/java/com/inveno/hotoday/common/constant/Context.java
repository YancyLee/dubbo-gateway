package com.inveno.hotoday.common.constant;

import java.io.Serializable;
import java.util.Map;

/**
 * gateweb到各自子模块的上下文
 *  Class Name: Context.java
 *  Description: 
 *  @author liyuanyi  DateTime 2016年7月18日 上午11:30:19 
 *  @company inveno 
 *  @version 1.0
 */
public class Context implements Serializable{

	
	/**
	 *  Description:
	 *  @author liyuanyi  DateTime 2016年7月19日 
	 *  
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 所有参数的map
	 */
	private Map<String,Object> resultMap;
	
//	/**
//	 * springMVC的请求
//	 */
//	private WebRequest webRequest;
//	
//	/**
//	 * springMVC请求
//	 */
//	private HttpServletRequest request;
//	
//	/**
//	 * springMVC响应
//	 */
//	private HttpServletResponse response;
	
	public Map<String, Object> getResultMap() {
		return resultMap;
	}

	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}

}
