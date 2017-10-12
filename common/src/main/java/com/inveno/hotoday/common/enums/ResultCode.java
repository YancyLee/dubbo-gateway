package com.inveno.hotoday.common.enums;


/**
 * 错误码
 */
public enum ResultCode {
	PARAM_ERROR("参数错误", 101), NO_DATA("没有数据", 102), SERVER_BUSY("服务器繁忙", 103), SERVER_ERROR("服务器错误", 104),
	ENCRYPT_ERROR("加密错误", 201), SIGN_ERROR("签名错误", 202), STATUS_ERROR("点赞状态错误", 203), PARAM_VALUE_ERROR("点赞参数错误", 204), 
	SENSITIVE_DATA("含有敏感信息", 207), OUT_DATE("登录ltk过期", 208), 
	REQ_OK("ok", 200);
	private String name;
	private String code;
	
	private ResultCode(String name, String code) {
		this.name = name;
		this.code = code;
	}
	
	// 兼容code类型int
	private ResultCode(String name, int code) {
		this.name = name;
		this.code = code+"";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
