package com.lv.basui.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;

public class RSA {
	private static Logger log = LoggerFactory.getLogger(RSA.class);
	private static HashMap<String, Object> keyMap = null;
	public final static String PUBLIC_KEY = "publicKey";
	public final static String PRIVATE_KEY = "privateKey";
	
	/**
	 * 获取公钥
	 * @return
	 */
	public static RSAPublicKey getPublicKey(){
		try {
			keyMap =  RSAUtils.getKeys();
		} catch (NoSuchAlgorithmException e) {
			
		}
		RSAPublicKey publicKey = (RSAPublicKey) keyMap.get("public");
		return publicKey;
	}
	/**
	 * 获取私钥
	 * @return
	 */
	public static RSAPrivateKey getPrivateKey(){
		try {
			keyMap =  RSAUtils.getKeys();
		} catch (NoSuchAlgorithmException e) {
			
		}
		RSAPrivateKey privateKey = (RSAPrivateKey) keyMap.get("private");
		return privateKey;
	}
	
	/**
	 * 公钥加密
	 * @param data
	 * @return
	 */
	public static String encryptByPublicKey(String data) throws Exception{
		RSAPublicKey publicKey = getPublicKey();
		//模  
        String modulus = publicKey.getModulus().toString();
        //公钥指数  
        String public_exponent = publicKey.getPublicExponent().toString();
        //使用模和指数生成公钥
        RSAPublicKey pubKey = RSAUtils.getPublicKey(modulus, public_exponent);
        String secretResult = RSAUtils.encryptByPublicKey(data, pubKey);
        return secretResult;
	}
	/**
	 * 私钥解密
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String decryptByPrivateKey(String data)throws Exception{
		RSAPrivateKey privateKey = getPrivateKey();
		RSAPublicKey publicKey = getPublicKey();
		//模  
        String modulus = publicKey.getModulus().toString(); 
        //私钥指数 
        String private_exponent = privateKey.getPrivateExponent().toString();
        //使用模和指数生成私钥
        RSAPrivateKey priKey = RSAUtils.getPrivateKey(modulus, private_exponent);
        String result = RSAUtils.decryptByPrivateKey(data, priKey);
        return result;
	}
	
}
