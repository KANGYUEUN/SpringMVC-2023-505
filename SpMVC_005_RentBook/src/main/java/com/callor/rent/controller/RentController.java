package com.callor.rent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * localhost:8080/rent/rent 또는 localhost:8080/rent/rent/*  로 요청이 들어왔을때
 * 브라우저에 주소를 입력하거나 nav 항목을 클릭 했을때
 * 서비스를 제공할 시작점이다.
 */
@Controller
@RequestMapping(value = "/rent")
public class RentController {

	/*
	 * GET/context/rent/  or 
	 * GET /context/rent  두가지 방법으로 접근하는 방법.
	 */
	@RequestMapping(value = {"/",""}, method = RequestMethod.GET)
	public String home() {
		return "rent/home";
	}
	
	
}
