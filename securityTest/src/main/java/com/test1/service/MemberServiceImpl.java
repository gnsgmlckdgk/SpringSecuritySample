package com.test1.service;

import javax.inject.Inject;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.test1.domain.MemberBean;
import com.test1.persistence.MemberDAO;
import com.test1.security.SHAPasswordEncoder;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	MemberDAO mdao;
	
	PasswordEncoder sha256;
	
	@Override
	public void insertMember(MemberBean mb) throws Exception {
		
		sha256 = new SHAPasswordEncoder(256);	// sha256 암호화 객체
		mb.setPass(sha256.encode(mb.getPass()));	// 비밀번호를 sha256 암호화
		
		mdao.insertMember(mb);
	}
	
}
