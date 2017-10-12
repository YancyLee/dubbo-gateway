package com.dubbo.gateway.interceptor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.inveno.hotoday.common.Constants;
import com.inveno.hotoday.common.util.RouteUtil;

public class GateHandlerInterceptor implements HandlerInterceptor {

	private final static Logger logger = Logger.getLogger(GateHandlerInterceptor.class);

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		logger.info("get request from = " + request.getRequestURL().toString());

		Map<String, Object> paramMap = new HashMap<String, Object>();
		String[] routeArray = RouteUtil.getUrlMethodName(request.getRequestURL().toString());
		if (routeArray == null) {
			logger.info("get result is null return false");
			return false;
		}
		paramMap.put(Constants.CLASS_NAME, "");
		paramMap.put(Constants.METHOD_NAME, routeArray[1]);
		paramMap.putAll(request.getParameterMap());
		request.setAttribute("paramMap", paramMap);
		logger.info("get result is" + Arrays.toString(routeArray));
		return true;
	}
}
