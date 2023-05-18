package kr.go.busan.test;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import kr.go.busan.util.AES256;


public class AES256Test {
	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException, NoSuchPaddingException, InvalidParameterSpecException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
		String plainText = "1234";
		String key = "%03x";
		
		System.out.println("MD5 : "+ plainText + ", 암호화 : "+AES256.md5(plainText));
		System.out.println("sha256 : "+plainText+", 암호화 : "+AES256.sha256(plainText));
		
		String encText = AES256.encryptAES256(plainText, key);
		System.out.println("AES256 : "+plainText+", 암호화 : "+encText);
		String desText = AES256.decryptAES256(encText, key);
		System.out.println("AES256 : "+encText+", 복호화 : "+desText);
		
		String[] strArr = {"1004","1234","1111","7979","4321","3333","2222"};
		
		for(String str : strArr){
			String eText = AES256.encryptAES256(str, key);
			System.out.println("AES256 : "+str+", 암호화 : "+eText);
		}
		
	}
}