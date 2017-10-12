package com.inveno.hotoday.common.model;

import com.inveno.hotoday.common.model.BaseReq;



public class BindReq extends BaseReq {
	private String token;
	private String topic;
	private int mesgSwitch = 1;
	private int newSwtich = 1;
	
	public int getMesgSwitch() {
		return mesgSwitch;
	}
	public void setMesgSwitch(int mesgSwitch) {
		this.mesgSwitch = mesgSwitch;
	}
	public int getNewSwtich() {
		return newSwtich;
	}
	public void setNewSwtich(int newSwtich) {
		this.newSwtich = newSwtich;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
}
