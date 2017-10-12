package com.inveno.hotoday.dubbo.interf;

import com.inveno.hotoday.common.model.BindReq;

public interface PushServer extends DubboBaseInter{
	String bindtoken(BindReq req);
	
}
