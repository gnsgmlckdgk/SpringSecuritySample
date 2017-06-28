package com.test1.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.test1.domain.MemberBean;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	private String namespace = "com.test1.mapper.MemberMapper";

	@Inject
	SqlSession sqlSession;
	
	@Override
	public void insertMember(MemberBean mb) throws Exception {
		sqlSession.insert(namespace+".insertMember", mb);		// 회원가입
		sqlSession.insert(namespace+".insertAuthority", mb);	// 권한설정
	}

	// 아이디, 비밀번호, 권한(로그인 인증)
	@Override
	public UserDetails getUserDetails(String id) {
		
		try {
			MemberBean mb = sqlSession.selectOne(namespace+".getIdPass", id);
			mb.setAuth(sqlSession.selectOne(namespace+".getAuth", id));
			
			// 권한
			List<GrantedAuthority> roles = new ArrayList<>();
	        roles.add(new SimpleGrantedAuthority("ROLE_"+mb.getAuth()));
	        
			User user = new User(mb.getId(), mb.getPass(), roles);
			
			return user;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
