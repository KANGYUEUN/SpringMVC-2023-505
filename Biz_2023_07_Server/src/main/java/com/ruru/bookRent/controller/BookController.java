package com.ruru.bookRent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ruru.bookRent.model.BookDto;
import com.ruru.bookRent.service.BookService;

import ch.qos.logback.core.model.Model;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/book")
public class BookController {

	protected final BookService bookService;
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	// 호출 : GET
	@RequestMapping(value = "/bookinput", method = RequestMethod.GET)
	public String insert(@ModelAttribute("BOOK")
					BookDto bookDto) {
		return "/insert";
		
	}
	
	// 입력값 저장,보내기 : POST
	@RequestMapping(value = "/bookinput", method = RequestMethod.POST)
	public String insert(@ModelAttribute("BOOK")
					BookDto bookDto, Model model) {
		int result = bookService.insert(bookDto);
		log.debug("새로 저장된 도서명 : {b_name}", bookDto.getB_name());
		return "home";
	}
	
}
