package com.lv.basui.utils;

import java.security.MessageDigest;

/**
 * 
 * <pre>
 * Description 	加密工具类
 * Copyright:	Copyright (c) 2017  
 * Company:		
 * Author:		Lv
 * Version:		1.0  
 * Create at:	2017年7月20日 下午1:18:59  
 *  
 * 修改历史:
 * 日期    作者    版本  修改描述
 * ------------------------------------------------------------------  
 * 
 * </pre>
 */
public class SecurityUtils {
	private static final String MD5_ALGORITHM = "MD5";

	/**
	 * 生成MD5摘要 用于验证
	 * @param inStr
	 * @return
	 */
	public static String string2MD5(String inStr){  
        MessageDigest md5 = null;  
        try{  
            md5 = MessageDigest.getInstance(MD5_ALGORITHM);  
        }catch (Exception e){  
            System.out.println(e.toString());  
            e.printStackTrace();  
            return "";  
        }  
        char[] charArray = inStr.toCharArray();  
        byte[] byteArray = new byte[charArray.length];  
  
        for (int i = 0; i < charArray.length; i++)  
            byteArray[i] = (byte) charArray[i];  
        byte[] md5Bytes = md5.digest(byteArray);  
        StringBuffer hexValue = new StringBuffer();  
        for (int i = 0; i < md5Bytes.length; i++){  
            int val = ((int) md5Bytes[i]) & 0xff;  
            if (val < 16)  
                hexValue.append("0");  
            hexValue.append(Integer.toHexString(val));  
        }  
        return hexValue.toString();  
    }  
	
	/** 
     * 加密解密算法 执行一次加密，两次解密 
     */   
    public static String convertMD5(String inStr){  
  
        char[] a = inStr.toCharArray();  
        for (int i = 0; i < a.length; i++){  
            a[i] = (char) (a[i] ^ 't');  
        }  
        String s = new String(a);  
        return s;  
    }  
    
    public static void main(String[] args) {
    	String s = new String("d3776loqw21h77mmh675aas567xyusgKUL2H3DK4735O9861M6Q1ETGHB" +
                "1C5ZK17K3P32VZR31WC77AC9E7TC43188PD3H9test123");
        System.out.println("原始：" + s);  
        System.out.println("MD5后：" + string2MD5(s));  
        System.out.println("加密的：" + convertMD5(s));  
        System.out.println("解密的：" + convertMD5(convertMD5(s)));
	}
}
