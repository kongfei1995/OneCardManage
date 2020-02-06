package com.cardsys.util;

public class StringUtil {
	
	private StringUtil() {// prevent instantiation
    }
	
	public static int parseToInt(String param, int defaultVal) {
		int result;
		try {
			result = Integer.parseInt(param);
        } catch (NumberFormatException e) {
            result = defaultVal;
        }
		return result;
	}
	
	public static boolean isEmpty(String str) {
		return str == null || str == "";
	}
}
