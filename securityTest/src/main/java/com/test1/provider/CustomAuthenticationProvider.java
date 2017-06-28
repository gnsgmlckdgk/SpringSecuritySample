package com.test1.provider;

import java.util.*;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.security.core.userdetails.*;

import com.test1.security.SHAPasswordEncoder;
import com.test1.service.UserService;
 
public class CustomAuthenticationProvider implements AuthenticationProvider
{
    @Autowired
    private UserService userService;
     
    /*
     * org.springframework.security.authentication.encoding.ShaPasswordEncoder;
     * 의 ShaPasswordEncoder를 써도 되지만 PasswordEncoder 구현해서 자체적으로 만들어놓은 SHAPasswordEncoder를 사용했다.
     */
    //private SHAPasswordEncoder passwordEncoder = new SHAPasswordEncoder(256);
    
    @Inject
    private SHAPasswordEncoder passwordEncoder;
    
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException
    {
    	// 로그인 폼에서 입력한 아이디, 비밀번호
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
  
        User user = null;
        Collection<GrantedAuthority> authorities = null;
  
        try {
        	// DB에 있는 아이디, 비밀번호, 권한을 가져온다.
            user = (User)userService.loadUserByUsername(username);
  
            // 이용자가 로그인 폼에서 입력한 비밀번호와 DB로부터 가져온 암호화된 비밀번호를 비교한다
            if (!passwordEncoder.matches(password, user.getPassword()))
                    throw new BadCredentialsException("비밀번호 불일치");
  
            // 일치하면 DB에 저장되어 있던 권한을 GrantedAuthority형의 Collection에 저장한다.
            authorities = user.getAuthorities();
            
        } catch(UsernameNotFoundException e) {
            e.printStackTrace();
            throw new UsernameNotFoundException(e.getMessage());
        } catch(BadCredentialsException e) {
            e.printStackTrace();
            throw new BadCredentialsException(e.getMessage());
        } catch(Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        
        return new UsernamePasswordAuthenticationToken(username, password, authorities);
    }
 
    @Override
    public boolean supports(Class<?> arg0) {
        return true;
    }
 
}