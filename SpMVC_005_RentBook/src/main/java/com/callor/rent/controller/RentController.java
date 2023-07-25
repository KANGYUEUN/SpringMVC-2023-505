package com.callor.rent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.callor.rent.models.RentBookVO;
import com.callor.rent.service.RentBookService;

import lombok.extern.slf4j.Slf4j;

/*
 * localhost:8080/rent/rent 또는 localhost:8080/rent/rent/*  로 요청이 들어왔을때
 * 브라우저에 주소를 입력하거나 nav 항목을 클릭 했을때
 * 서비스를 제공할 시작점이다.
 */

@Controller
@Slf4j
@RequestMapping(value = "/rent")
// 지금부터 별도의 지시가 있을때 까지 RENT_WORK객체는 지우지 마라 
@SessionAttributes("RENT_WORK")
public class RentController {

	protected final RentBookService rentBookService;
	public RentController(RentBookService rentBookService) {
		this.rentBookService = rentBookService;
	}
	
	@RequestMapping(value = "/insert", method=RequestMethod.GET)
	public String insert(@ModelAttribute("RENT_WORK") RentBookVO rentBookVO) {
		return "rent/work_book";
	}
	
	@RequestMapping(value = "/book", method=RequestMethod.POST)
	public String work_book(@ModelAttribute("RENT_WORK") RentBookVO rentBookVO) {
		return "rent/work_member";
	}
	
	@RequestMapping(value = "/member", method=RequestMethod.POST)
	public String work_member(@ModelAttribute("RENT_WORK") RentBookVO rentBookVO) {
		return "rent/work_complete";
	}
	
	@RequestMapping(value = "/insert", method=RequestMethod.POST)
	public String work_complet(@ModelAttribute("RENT_WORK") RentBookVO rentBookVO) {
		log.debug("전달된 데이터 :  {} ", rentBookVO);
		return "redirect:/rent";
	}
	
	@ModelAttribute("RENT_WORK")
	public RentBookVO newRentBook() {
		return new RentBookVO();
	}
	
	/*
	 * GET/context/rent/  or 
	 * GET /context/rent  두가지 방법으로 접근하는 방법.
	 */
	@RequestMapping(value = {"/",""}, method = RequestMethod.GET)
	public String home() {
		return "rent/home";
	}
	
	
}
