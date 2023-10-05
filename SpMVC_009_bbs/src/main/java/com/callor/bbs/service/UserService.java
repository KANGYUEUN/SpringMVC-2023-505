package com.callor.bbs.service;

import com.callor.bbs.models.UserDto;

public interface UserService {

	// 회원가입을 실행할 메서드
	public UserDto join(UserDto userDto);
	
	public UserDto findById(String username);
	
}
