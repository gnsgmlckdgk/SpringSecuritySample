package com.test1.persistence;

import org.springframework.security.core.userdetails.UserDetails;

import com.test1.domain.MemberBean;

public interface MemberDAO {
	
	// 회원가입
	public void insertMember(MemberBean mb) throws Exception;
	// 로그인 인증
	public UserDetails getUserDetails(String id);
	
}
