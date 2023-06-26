package com.callor.hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.callor.hello.models.UserDto;
import com.callor.hello.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	protected UserService userService;
	
	// 이 코드를 사용하지 않아도 보내는곳  
	// @Service, 받는곳: @Autowired 가 해줌
//	public UserController() {
//		userService = new UserSercieImplV1();
//	}
	
	// localhost:8080/hello/user/list 요청 처리.
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String userList(Model model) {
		List<UserDto> userList = userService.selectAll();
		model.addAttribute("USERS",userList);
		return "user/list";
	}
	
	@RequestMapping(value="/input",method=RequestMethod.GET)
	public String userInput() {
		return "user/input";
	}
	
	@RequestMapping(value="/input",method=RequestMethod.POST)
	public String userInput(UserDto userDto) {
		log.debug(userDto.toString());
		return null;
	}

}
