package com.lv.basui.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreeDes {
	public static final String Key = "5Brv53wapEOYNU0ZjpLFsLz7iho9qOy8";
	private static Logger log = LoggerFactory.getLogger(ThreeDes.class);

	public static String encryptThreeDESECB(String src)  {
		try{
		DESedeKeySpec dks = new DESedeKeySpec(Key.getBytes("UTF-8"));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
		SecretKey securekey = keyFactory.generateSecret(dks);

		Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, securekey);
		byte[] b = cipher.doFinal(src.getBytes());

		return encodeBase64(b).replaceAll("\r", "").replaceAll("\n", "");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return null;

	}

	// 3DESECB解密,key必须是长度大于等于 3*8 = 24 位
	public static String decryptThreeDESECB(String src) {
		try {
			byte[] bytesrc = decodeBase64(src);
			// --解密的key
			DESedeKeySpec dks = new DESedeKeySpec(Key.getBytes("UTF-8"));
			SecretKeyFactory keyFactory = SecretKeyFactory
					.getInstance("DESede");
			SecretKey securekey = keyFactory.generateSecret(dks);

			// --Chipher对象解密
			Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, securekey);
			byte[] retByte = cipher.doFinal(bytesrc);

			return new String(retByte);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}
	
	/**
	 * 字符串转16进制
	 * @param input
	 * @return
	 */
	public static String decode16(String input){
		byte[] buf = input.getBytes();
		StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
	}
	
	/**
	 * 16进制转字符串
	 * @param input
	 * @return
	 */
	public static String encode16(String input){
		 byte[] byteContent = new byte[input.length() / 2];
         if (input.length() < 1) {
             return null;
         }
         // 将16进制转换为二进制
         for (int i = 0; i < input.length() / 2; i++) {
             int high = Integer.parseInt(input.substring(i * 2, i * 2 + 1), 16);
             int low = Integer.parseInt(input.substring(i * 2 + 1, i * 2 + 2), 16);
             byteContent[i] = (byte) (high * 16 + low);
         }
         return new String(byteContent);
	}

	@SuppressWarnings("restriction")
	public static byte[] decodeBase64(String input) {
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			return decoder.decodeBuffer(input);
		} catch (IOException e) {
			log.error(e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("restriction")
	public static String encodeBase64(byte[] input) {
		return new sun.misc.BASE64Encoder().encode(input);
	}

	public static void main(String[] args) {
		String s="116546123asdasd1";

		String format = new SimpleDateFormat("yyyyMMddHHmmSSS").format(new Date());

		String token = encryptThreeDESECB(s+","+format);
		System.out.println(token);
		String ss2 = decryptThreeDESECB(token);
		System.out.println(ss2);

		System.out.println(token.length());

	}
}