package com.callor.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	// GET: http://localhost:8080/hello/user/login
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String login() {
		
		
		// login.jsp파일을 랜더링 하여 Response 하라
		//return null; 과 같다.
		return "user/login";
		
	}

}
