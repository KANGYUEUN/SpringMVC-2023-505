package com.callor.bbs.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.bbs.models.UserDto;
import com.callor.bbs.repository.UserRepoditory;

@Controller
public class HomeController {
	
	private UserRepoditory userDao;
	public HomeController(UserRepoditory userDao) {
		this.userDao = userDao;
	
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		List<UserDto> userList =  userDao.findAll();
		return "home";
	}
	
}
