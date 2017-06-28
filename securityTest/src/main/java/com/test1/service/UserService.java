package com.test1.service;
 
import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.test1.persistence.MemberDAO;
 
@Service
public class UserService implements UserDetailsService
{
    
	// DB 정보 가져올수 있는 객체
	@Inject
	MemberDAO mdao;
 
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        
    	//데이터베이스에서 가져온 이용자 정보
        UserDetails userDetails = mdao.getUserDetails(userId);
        if (userDetails==null) throw new UsernameNotFoundException("접속자 정보를 찾을 수 없습니다.");
        return userDetails;

    }
}
