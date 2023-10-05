package com.callor.bbs.service.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.callor.bbs.models.UserDto;

import lombok.extern.slf4j.Slf4j;


/*
 * AuthenticationProvider 를 구현한 클래스에서 
 * authenticate() method  가 수행하는 주요역할은 정상적인 사용자 일 경우 
 * session Token을 발행하는 것이다. 여기에서 필요한 정보들은 사용자의 ID, Password 와 ROLE 정보이다.
 */


@Slf4j
@Service("authProvider")
public class AuthProvider implements AuthenticationProvider{

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		
		String username = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();
		
		log.debug("로그인 사용자 {}", username);
		log.debug("로그인 비밀번호 {}", password);
		
		
		UserDto userDto = UserDto.builder().username(username).nickname("홍길동").email("yu1128eun@kakao.com").age(27).build();

		// 로그인에 성공한 사용자에게 권한들을 부여하기 위ㅏ하여 
		// authorities(권한) 리스트를 생성하기 
		List<GrantedAuthority> grantList = new ArrayList();
		grantList.add(new SimpleGrantedAuthority("ADMIN"));
		grantList.add(new SimpleGrantedAuthority("USER"));
		
		
		/*
		 *  Token을 만드는 class
		 *  Token을 생성하는 Username*Token클래스는 3가지의 매개변수를 가질수 있다.
		 *  첫번째 매개변수는 principal User 기본정보와 관련된 데이터 
		 *  두번째 매개변수는 credential 민감한 정보 
		 *  세번째 매개변수는 authorites 권한리스트 
		 *  
		 *  
		 *  첫번째 데이터는 UserDto 객체
		 *  두번째 데이터는 null값으로 설정
		 *  세번째 데이터를 권한리스트 또는 null로 설정
		 *  하여 Token을 발행한다. 
		 */
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, null, grantList);
		return token;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}
