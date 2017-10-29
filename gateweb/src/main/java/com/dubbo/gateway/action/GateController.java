package com.dubbo.gateway.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inveno.hotoday.common.model.BaseResp;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.alibaba.fastjson.JSON;
import com.inveno.hotoday.common.constant.Context;
import com.inveno.hotoday.common.enums.ResultCode;
import com.inveno.hotoday.dubbo.interf.PushServer;

/**
 * gateWeb 的入口类
 *  Class Name: GateController.java
 *  Description: 
 *  @author liyuanyi  DateTime 2016年7月15日 下午2:10:30 
 *  @company inveno 
 *  @version 1.0
 */
@SuppressWarnings("unchecked")
@Controller
@RequestMapping("/")
public class GateController {
	
	private final static Logger logger = Logger.getLogger(GateController.class);
	
	@Autowired
	private PushServer pushServer;

	@RequestMapping(value = "/push/**", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String pushServer(WebRequest webRequest,HttpServletRequest request,HttpServletResponse response) {
		try {
			logger.info(request.getParameter("uid") +" request pushserver");
			Context context = new Context();
			context.setResultMap((Map<String,Object>)request.getAttribute("paramMap"));
			return pushServer.controller(context);
		} catch (Exception e) {
			logger.error(e);
			BaseResp resp = new BaseResp();
			resp.setResult(ResultCode.SERVER_ERROR);
			return JSON.toJSONString(resp);
		}
	}
}
