package com.ruru.bookRent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ruru.bookRent.model.UserDto;
import com.ruru.bookRent.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/user")
public class UserController {

	protected final UserService userService;
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/userinput", method =RequestMethod.GET)
	public String insert(@ModelAttribute("USER")
					UserDto userDto	) {
		return "/insert";
	}
	
	@RequestMapping(value = "/userinput", method=RequestMethod.POST)
	public String insert(@ModelAttribute("USER")
				UserDto userDto, Model model) {
		int result = userService.insert(userDto);
		log.debug("새로 저장된 USER : {u_name}", userDto.getU_name());
		return "home";
	}
	
}
