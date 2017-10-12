package com.inveno.hotoday.common.model;

import org.hibernate.validator.constraints.NotEmpty;


/**
 *
 */
public class BaseReq extends BaseModel {
	@NotEmpty
	private String uid;
	private String platform;
	private String model;
	@NotEmpty
	private String product_id;
	private String mcc;
	private String osv;
	private String imei;
	private String promotion;
	private String mac;
	private String aid;
	private String tk;
	private String network;
	private String request_time;
	private String api_ver;
	@NotEmpty
	private String app_lan;
	private String brand;
	private String language;
	private String app_ver;
	private String data;
	private String ltk;
	// 染色配置 json格式的string
	private String colorConfig;
	private String mnc;
	
	private String latitude;
	
	private String longitude;

	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getMcc() {
		return mcc;
	}
	public void setMcc(String mcc) {
		this.mcc = mcc;
	}
	public String getOsv() {
		return osv;
	}
	public void setOsv(String osv) {
		this.osv = osv;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String getPromotion() {
		return promotion;
	}
	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getTk() {
		return tk;
	}
	public void setTk(String tk) {
		this.tk = tk;
	}
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
	}
	public String getRequest_time() {
		return request_time;
	}
	public void setRequest_time(String request_time) {
		this.request_time = request_time;
	}
	public String getApi_ver() {
		return api_ver;
	}
	public void setApi_ver(String api_ver) {
		this.api_ver = api_ver;
	}
	public String getApp_lan() {
		return app_lan;
	}
	public void setApp_lan(String app_lan) {
		this.app_lan = app_lan;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getApp_ver() {
		return app_ver;
	}
	public void setApp_ver(String app_ver) {
		this.app_ver = app_ver;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getLtk() {
		return ltk;
	}
	public void setLtk(String ltk) {
		this.ltk = ltk;
	}
	public String getMnc() {
		return mnc;
	}
	public void setMnc(String mnc) {
		this.mnc = mnc;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
}
