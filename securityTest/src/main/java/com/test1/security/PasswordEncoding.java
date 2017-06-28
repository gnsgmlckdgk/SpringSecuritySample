package com.test1.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// 확장성을 고려한 암호화 클래스를 주입받기 위한 클래스이다. 기본적으로 BCryptPasswordEncoder 암호화를 사용한다.
public class PasswordEncoding implements PasswordEncoder {

	private PasswordEncoder passwordEncoder; 
	
	// 기본 생성자
	public PasswordEncoding() { 
		this.passwordEncoder = new BCryptPasswordEncoder(); 	
	} 
	// 매개변수 있는 생성자
	public PasswordEncoding(PasswordEncoder passwordEncoder) { 	
		this.passwordEncoder = passwordEncoder; 	
	}

	// 암호화
	@Override
	public String encode(CharSequence rawPassword) {
		return passwordEncoder.encode(rawPassword);
	}

	// 암호화 값의 비교
	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return passwordEncoder.matches(rawPassword, encodedPassword);
	}
	
}
