package com.callor.hello.service.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("authProviderImpl")
public class AuthProviderImpl implements AuthenticationProvider{

	// security 를 통해 login을 실행하면 
	// security 에 의해 실행되는 method 
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		// login 할때 입력한 username 과 password 를 추출하기 
		String username = (String)authentication.getPrincipal(); // id
		String password = (String)authentication.getCredentials(); // password
		
		log.debug("사용자이름 : {}" , username);
		log.debug("비밀번호 : {}" , password);
		
		if(!username.equalsIgnoreCase("ruru")) {
			throw new UsernameNotFoundException(username + " 이 없음");
		}
		
		if(!password.equals("!Korea1234")) {
			throw new BadCredentialsException("비밀번호 오류 >_<");
		}
		
		// username 과 password 가 일치한다
		// 로그인 실행 : 정상적인 사용자 이면 token을 발행하고 session에 사용자 정보를 등록한다
		// Grant : 사용자에게 권한 부여하기 
		List<GrantedAuthority> grantList = new ArrayList<>();
		
		// 권한 부여하기 
		/*
		 *  context.xml 에서 권한을 검사할때 hasRole("권한")처럼 사용한다
		 *  Provider 에서 권한을 설정할때는 "ROLE_권한" 과 같은 형식으로 지정해 줘야 한다.
		 *  다수의 권한을 동시에 부여하여 검사 할 수 있다.   
		 */
		grantList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		grantList.add(new SimpleGrantedAuthority("ROLE_USER"));
		//grantList.add(new SimpleGrantedAuthority("ROLE_GUEST"));
		
		// 정상적인 사용자임을 증명하는 Token 을 발행해 return
		// 이 Token을 사용하여 Spring Security는 정상적인 로그인 절차를 마무리 한다. 
		// security 에게 정상적인 사용자 이니 login 절차를 마무리 하라는 의미
		return new UsernamePasswordAuthenticationToken(username, password, grantList);
	}

	// 현재 클래스를 authentication-manager 로 사용하겠다 라는 선언 
	// 이 method는 반드시 true 를 return 해야 한다.
	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}