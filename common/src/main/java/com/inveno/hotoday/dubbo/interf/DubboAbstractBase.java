package com.inveno.hotoday.dubbo.interf;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.inveno.hotoday.common.exception.GateWayException;
import com.inveno.hotoday.common.util.PatternUtil;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.inveno.hotoday.common.Constants;
import com.inveno.hotoday.common.constant.Context;
import com.inveno.hotoday.common.enums.ResultCode;
import com.inveno.hotoday.common.util.ObjectMapperUtil;
import com.inveno.hotoday.common.util.StringUtil;

public abstract class DubboAbstractBase {
	
	
	/**
	 *  该方法为主方法
	 *  Description:
	 *  @author liyuanyi  DateTime 2016年7月20日 下午6:18:21
	 *  @param context
	 *  @return
	 *  @throws Exception
	 */
	public String invokeSelfMethod(Context context) throws Exception
	{
		String methodName = String.valueOf(context.getResultMap().get(Constants.METHOD_NAME));
		Method method = getMethodByName(methodName);
		if(method == null)
			throw new Exception("not such method:"+methodName);
		Object[] params = initParameter(method,context);
		Object result = method.invoke(this, params);
		return ObjectMapperUtil.objectTurnJson(result);
	}
	
	
	/**
	 * 反射出对应名字的方法，相同方法名字的需要报错（暂没做）。
	 *  Description:
	 *  @author liyuanyi  DateTime 2016年7月20日 下午1:54:38
	 *  @param methodName
	 *  @return
	 */
	public Method getMethodByName(String methodName)
	{
		Class classz = this.getClass();
		Method[] methods = classz.getMethods();
		for(int i = 0;i < methods.length;i++)
		{
			if(methods[i].getName().equalsIgnoreCase(methodName))
			{
				return methods[i];
			}
		}
		return null;
	}
	/**
	 * 初始化参数
	 *  Description:
	 *  @author liyuanyi  DateTime 2016年7月20日 下午1:56:07
	 *  @param method
	 *  @param context
	 *  @return
	 * @throws Exception 
	 */
	public Object[] initParameter(Method method,Context context) throws Exception
	{
		Class[] parameters = method.getParameterTypes();
		if(parameters == null || parameters.length == 0)
			return null;
		Object[] paramObject = new Object[parameters.length];
		Map<String,Object> resultMap = context.getResultMap();
		Set<String> paramKey = resultMap.keySet();
		String paramName = "";
		for(int j = 0;j < parameters.length; j++)
		{
			try 
			{
				Object o = parameters[j].newInstance();
				Method[] paramMethods = parameters[j].getMethods();
				for(int i = 0;i < paramMethods.length;i++)
				{
					paramName = StringUtil.toLowerCaseFirstOne(paramMethods[i].getName().replace("set", ""));
					if(paramKey.contains(paramName))
					{
						Class[] paramClass_ = paramMethods[i].getParameterTypes();
						Object param = null;
						String tempParam = ((String[])resultMap.get(paramName))[0];
						if(paramClass_[0].getName().toLowerCase().contains("string"))
						{
							param = tempParam; 
						}
						else if(paramClass_[0].getName().toLowerCase().contains("int") || paramClass_[0].getName().toLowerCase().contains("integer"))
						{
							if(StringUtils.isEmpty(tempParam))
								continue;
							if (!PatternUtil.isDigital(tempParam)) {
								throw new GateWayException(ResultCode.PARAM_ERROR.getCode(),
										String.format("param[%s:%s] invalid.", paramName, tempParam));
							}
							try {
								param = Integer.parseInt(tempParam);
							} catch (Exception e) {
								throw new GateWayException(ResultCode.PARAM_ERROR.getCode(),
										String.format("param[%s:%s] invalid.", paramName, tempParam));
							}
						}
						else if(paramClass_[0].getName().toLowerCase().contains("long"))
						{
							if(StringUtils.isEmpty(tempParam))
								continue;
							if (!PatternUtil.isDigital(tempParam)) {
								throw new GateWayException(ResultCode.PARAM_ERROR.getCode(),
										String.format("param[%s:%s] invalid.", paramName, tempParam));
							}
							try {
								param = Long.parseLong(tempParam);
							} catch (Exception e) {
								throw new GateWayException(ResultCode.PARAM_ERROR.getCode(),
										String.format("param[%s:%s] invalid.", paramName, tempParam));
							}
						} else if (paramClass_[0].isAssignableFrom(List.class)) {
							Type[] fc = paramMethods[i].getGenericParameterTypes();
							if (fc == null || fc.length != 1) {
								param = JSONArray.parseArray(tempParam, Object.class);
							} else {
								ParameterizedType pt = (ParameterizedType) fc[0];
								Class<?> genericClazz = (Class<?>) pt.getActualTypeArguments()[0];  
								param = JSONArray.parseArray(tempParam, genericClazz);
							}
						}
						
//						Object o = (paramClass_[0])resultMap.get(paramName))[0];
//						System.out.println("2221331111");
						paramMethods[i].invoke(o, param);
					}
				}
				paramObject[j] = o;
			}
			catch (GateWayException e) {
				e.printStackTrace();
				throw e;
			} 
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
		}
		return paramObject;
	}
	
	public static void main(String[] args) {
		System.out.println(Integer.class);
	}
}
