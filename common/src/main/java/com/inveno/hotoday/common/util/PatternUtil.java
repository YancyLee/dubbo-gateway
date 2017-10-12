package com.inveno.hotoday.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 2016年8月26日
 * sugang
 */
public class PatternUtil {

	public static final String PATTERN_DIGITAL = "^[0-9]*$";

	public static boolean isDigital(String param) {
		Pattern p = Pattern.compile(PATTERN_DIGITAL);
		Matcher m = p.matcher(param);
		return m.matches();
	}

}
