package com.inveno.hotoday.common.enums;

public enum ResultMessage {

	PARAM_ERROR("Invalid parameter");
	
	private String mesg;
	
	private ResultMessage(String mesg)
	{
		this.mesg = mesg;
	}

	public String getMesg() {
		return mesg;
	}

	public void setMesg(String mesg) {
		this.mesg = mesg;
	}
}
