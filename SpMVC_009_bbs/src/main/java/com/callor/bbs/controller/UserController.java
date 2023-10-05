package com.callor.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.bbs.models.UserDto;
import com.callor.bbs.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	private final UserService userService;
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	/*
	 * login을 custom 하기 위하여 URL을 만들고
	 * login.jsp를 통해 login을 실행한다
	 * 이때 반드시 login URL은 GET 방식으로 method를 설정해야 하며
	 * login URL 과 같은 POST method는 만들지 않는다.
	 * 
	 * 로그인 화면에서 로그인을 실행하면 URL 을 spring Security 가 가로채 
	 * Security 차원에서 로그인 과정이 수행된다. 
	 */
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return null;
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return null;
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(UserDto userDto) {
		
		try {
			userService.join(userDto);
		} catch (Exception e) {
		}
		return "redirect:/user/login";
	}	
	
	
}
