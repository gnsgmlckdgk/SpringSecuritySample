package com.test1.security;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/* 
 * SHA 의 다양한 암호화를 사용하기 위한 암호화 클래스이다.
 * sha: 암호화 비트를 입력 (1, 128, 256, 512)
 * encodeHashAsBase64: SHA에서 제공하는 Base64 를 암호화할지 여부
*/
public class SHAPasswordEncoder implements PasswordEncoder { 
	
	private ShaPasswordEncoder shaPasswordEncoder; 
	
	private Object salt = null; 
	
	public SHAPasswordEncoder() { 
		shaPasswordEncoder = new ShaPasswordEncoder(); 
	} 
	
	public SHAPasswordEncoder(int sha) { 
		shaPasswordEncoder = new ShaPasswordEncoder(sha); 
	} 
	
	public void setEncodeHashAsBase64(boolean encodeHashAsBase64) { 
		shaPasswordEncoder.setEncodeHashAsBase64(encodeHashAsBase64); 
	} 
	
	public void setSalt(Object salt) { 
		this.salt = salt; 
	} 
	
	// 암호화
	@Override 
	public String encode(CharSequence rawPassword) { 
		return shaPasswordEncoder.encodePassword(rawPassword.toString(), salt); 	
	} 
	
	// 암호화 비교
	@Override 
	public boolean matches(CharSequence rawPassword, String encodedPassword) { 
		return shaPasswordEncoder.isPasswordValid(encodedPassword, rawPassword.toString(), salt); 
		
	} 
}