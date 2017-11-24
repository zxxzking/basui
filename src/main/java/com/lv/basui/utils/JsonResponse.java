package com.lv.basui.utils;

import java.io.Serializable;


public class JsonResponse implements Serializable{

	private static final long serialVersionUID = 1032771571305836886L;
	private String code;

	/** 返回对象 */
	private Object result;

	/** 提示消息 */
	private String msg;

	
	public JsonResponse() {
		super();
	}
	
	public JsonResponse(String code, String msg) {
		this(code, null, msg);
	}

	public JsonResponse(String code, Object result, String msg) {
		super();
		this.code = code;
		this.result = result;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public static JsonResponse buildSuccess(String msg, Object result) {
		return new JsonResponse("0000", result, msg);
	}
	
	public static JsonResponse buildFailure(String code, String msg) {
		return new JsonResponse(code, msg);
	}

	/**
	 * 创建返回JSON错信息对象
	 * 
	 * @return
	 */
	public static JsonResponse buildSuccess(String code, String msg, Object result) {
		return new JsonResponse(code, result, msg);
	}

	/**
	 * 创建返回JSON错信息对象
	 * 
	 * @return
	 */
	public static JsonResponse buildFailure(String msg) {
		return new JsonResponse("1001", msg);
	}
	
	
	public String toJsonString() {
		return GsonUtils.getJson(this, "yyyy-MM-dd HH:mm:ss");
	}
	
	
	
}
