package com.dubbo.gateway;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.inveno.hotoday.common.util.Config;

public class Constants {

	public final static List<String> paramList = new ArrayList<String>();

	
	static
	{
		Config config = new Config("prop/gateweb.properties");
		initParam();
	}
	
	public static void initParam()
	{
		paramList.add("product_id");
		paramList.add("promotion");
		paramList.add("request_time");
		paramList.add("fuid");
		paramList.add("app_ver");
		paramList.add("sdk_ver");
		paramList.add("api_ver");
		paramList.add("tk");
		paramList.add("network");
		paramList.add("imei");
		paramList.add("aid");
		paramList.add("idfa");
		paramList.add("brand");
		paramList.add("model");
		paramList.add("osv");
		paramList.add("platform");
		paramList.add("language");
		paramList.add("app_lan");
		paramList.add("mcc");
		paramList.add("mnc");
		paramList.add("nmcc");
		paramList.add("nmnc");
		paramList.add("lac");
		paramList.add("cell_id");
		paramList.add("longitude");
		paramList.add("latitude");
		paramList.add("mac");
	}
}
