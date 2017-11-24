package com.lv.basui.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtils {
	private static Gson gson = new Gson();

	private static GsonBuilder gsonBuilder = new GsonBuilder();

	/**
	 * 对象转json字符
	 * 
	 * @param object
	 * @return
	 */
	public static String getJson(Object object) {
		gsonBuilder.disableHtmlEscaping();
		gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss");
		return gsonBuilder.create().toJson(object);
	}

	/**
	 * 对象转json字符
	 * 
	 * @param object
	 * @param dateFormat
	 * @return
	 */
	public static String getJson(Object object, String dateFormat) {
		return gsonBuilder.setDateFormat(dateFormat).create().toJson(object);
	}


	/**
	 * json转对象
	 * 
	 * @param json
	 * @param type
	 * @return
	 */
	public static <T> T fromJson(String json, Class<T> type) {
		return gson.fromJson(json, type);
	}
}
