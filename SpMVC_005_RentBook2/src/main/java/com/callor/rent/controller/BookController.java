package com.callor.rent.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.rent.models.BookDto;
import com.callor.rent.service.BookService;

import lombok.extern.slf4j.Slf4j;

/*
 * localhost:8080/rent/book/* 로 요청이 들어오면
 * 처리를 할 시작점.
 */
@Slf4j
@Controller
@RequestMapping(value = "/book")
public class BookController {

	protected final BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String home(@RequestParam(name = "page", required = false, defaultValue = "1") String page,
			@RequestParam(name = "search", required = false, defaultValue = "-1") String search,
			Model model) {
		// List<BookDto> books = bookService.selectPage(page);
		if(search.equals("-1")) {
			bookService.selectPage(page, model);
		} else {
			bookService.selectPage(page, model, search);
		}
		model.addAttribute("SEARCH", search);
		return "book/home";
	}

	// 도서정보 입력화면을 보여주기 : GET
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(@ModelAttribute("BOOK") BookDto bookDto) {
		return "book/input";
	}

	//
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@ModelAttribute("BOOK") BookDto bookDto, Model model) {
		log.debug("전달된 데이터 {}", bookDto);
		int result = bookService.insert(bookDto);
		return "redirect:/book";
	}

	@RequestMapping(value = "/{bcode}/detail", method = RequestMethod.GET)
	public String detail(@PathVariable("bcode") String bcode, Model model) {

		BookDto bookDto = bookService.findById(bcode);
		model.addAttribute("BOOK", bookDto);
		return "book/detail";
	}

	@RequestMapping(value = "/{bcode}/update", method = RequestMethod.GET)
	public String update(@PathVariable("bcode") String bcode, Model model) {
		BookDto bookDto = bookService.findById(bcode);
		model.addAttribute("BOOK", bookDto);
		model.addAttribute("STATE", "UPDATE");
		return "book/input";
	}

	@RequestMapping(value = "/{bcode}/update", method = RequestMethod.POST)
	public String update(@PathVariable("bcode") String bcode, @ModelAttribute("BOOK") BookDto bookDto, Model model) {

		if (!bcode.isBlank())
			bookDto.setB_code(bcode);
		int result = bookService.update(bookDto);
		return String.format("redirect:/book/%s/detail", bcode);
	}

	/*
	 * @ModelAttribute("BOOK") 라는 선언이 있는 매개 변수가 발견되면 BookDto bookDto 객체에 데이터가 있는지
	 * 확인하고 만약 null값이면 새로운 BookDto 객체를 생성하여 주입하라.
	 */
	@ModelAttribute("BOOK")
	public BookDto newBookDto() {
		return BookDto.builder().build();
	}

	/*
	 * 만약 Req를 하면서 num변수에 값을 포함하여 보낼때 문자열, "", 아무것도 없는 값 을 전달하면 서버는 400 오류가 난다. 400
	 * 오류를 방지하려면 num=0 이라도 최소한 전달해야 한다.
	 */
	// param?num=000
	@ResponseBody
	@RequestMapping(value = "/param", method = RequestMethod.GET)
	public String paramTest(@RequestParam(name = "num", required = false, defaultValue = "0") int num) {
		return num + "";
	}

	@ResponseBody
	@RequestMapping(value = "/name/search", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public List<BookDto> bNameSearch(
			@RequestParam(name = "b_name", required = false, defaultValue = "-1") String bname) {
		if (bname.equals("-1")) {
			return null;
		}
		log.debug("받은 도서명 : {}", bname);
		List<BookDto> bookList = bookService.findByBName(bname);
		return bookList;
	}

}
