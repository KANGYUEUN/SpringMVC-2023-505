package com.callor.car.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.callor.car.model.UserDto;
import com.callor.car.service.UserService;

import lombok.extern.slf4j.Slf4j;

/*
 *   class scope @RequestMapping 과
 *   	 type scope @RequestMapping
 *  method scope @RequestMapping 둘은 서로 분리 되어있으나
 *  실제 호출 될때는 두개가 연결 Mapping 으로 사용된다. 
 */
@SessionAttributes("USER")
@Slf4j
@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	protected UserService userService;
	public UserController(UserService userService) {
		this.userService = userService;
	}

	// localhost:8080/rootPath/user/login 으로 Request 되었을때
	// 호출되는 method 
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String login(String ERROR, @ModelAttribute("USER") UserDto userDto, Model model) {
		model.addAttribute("ERROR",ERROR);
		return "user/login";
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String login(@ModelAttribute("USER") UserDto userDto, HttpSession httpSession, SessionStatus sessionStatus) {
		
		try {
			UserDto resultDto = userService.login(userDto);
			httpSession.setAttribute("LOGINUSER", resultDto);
		} catch (Exception e) {
			// new Exception(messege) 라고 보낸 Exception에서 
			// message 에 해당하는 부분 getter 하기
			String messege = e.getMessage();
			return "redirect:/user/login?ERROR=" + messege;
		}
		// 현재 SessionAttributes 에 저장된 USER 정보 제거(DROP)
		sessionStatus.setComplete();
		return "redirect:/";

	}
	
	@RequestMapping(value = "/join", method=RequestMethod.GET)
	public String join(@ModelAttribute UserDto userDto) {
		return "user/join";
	}

	@RequestMapping(value = "/join", method=RequestMethod.POST)
	public String join(@ModelAttribute UserDto userDto, Model model, SessionStatus sessionStatus) {
		log.debug("회원가입 정보 : {}",userDto);
		int result = userService.join(userDto);
		sessionStatus.setComplete();
		return "redirect:/user/join";
	}
	
	@RequestMapping(value = "/logout", method=RequestMethod.GET)
	public String logout(HttpSession httpSession) {
		httpSession.removeAttribute("LOGINUSER");
		return "redirect:/";
	}
	
	@ModelAttribute("USER")
	public UserDto userDto() {
		//return UserDto.builder().build();
		return new UserDto();
	}
	
}
