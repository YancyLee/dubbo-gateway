package com.dubbo.gateway.utils;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class CheckParamUtil {
	
	private final static Logger logger = Logger.getLogger(CheckParamUtil.class);
	
	public static boolean checkRequestParam(Map<String,Object> paramMap)
	{
		try{
			
			String product_id = ((String[]) paramMap.get("product_id"))[0];
			String promotion = ((String[]) paramMap.get("promotion"))[0];
			String uid = ((String[]) paramMap.get("uid"))[0];
			String app_ver = ((String[]) paramMap.get("app_ver"))[0];
			String api_ver = ((String[]) paramMap.get("api_ver"))[0];
			String tk = ((String[]) paramMap.get("tk"))[0];
			String network = ((String[]) paramMap.get("network"))[0];
			String brand = ((String[]) paramMap.get("brand"))[0];
			String model = ((String[]) paramMap.get("model"))[0];
			String platform = ((String[]) paramMap.get("platform"))[0];
			String app_lan = ((String[]) paramMap.get("app_lan"))[0];
			String request_time = ((String[]) paramMap.get("request_time"))[0];
			logger.info("product_id="+product_id+"&promotion="+promotion+"&uid="+uid
					+"&app_ver="+app_ver+"&api_ver="+api_ver+"&tk="+tk+"&network="+network
					+"&brand="+brand+"&model="+model+"&platform="+platform+"&app_lan="+app_lan+"&request_time="+request_time);
			if(StringUtils.isBlank(product_id) || StringUtils.isBlank(promotion) 
					|| StringUtils.isBlank(uid) 
					|| StringUtils.isBlank(app_ver) || StringUtils.isBlank(api_ver)
					|| StringUtils.isBlank(tk) || StringUtils.isBlank(network)
					|| StringUtils.isBlank(brand) || StringUtils.isBlank(model)
					|| StringUtils.isBlank(platform) || StringUtils.isBlank(app_lan) ||  StringUtils.isBlank(request_time)){
				
				return false;
			}		
		}catch(Exception e){
			return false;
		}
		return true;
	}

}
