package com.ruru.bookRent.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ruru.bookRent.dao.BookDao;
import com.ruru.bookRent.model.BookDto;
import com.ruru.bookRent.service.BookService;
@Service
public class BookServiceImplV1 implements BookService{

	protected final BookDao bookDao;
	public BookServiceImplV1(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public BookDto findBook(String id) {
		return bookDao.findBook(id);
	}

	@Override
	public List<BookDto> selectAll() {
		return bookDao.selectAll();
	}

	// BOOK 정보 insert(코드, 도서명 유효성검사)
	@Override
	public int insert(BookDto bookDto) {
		
		String bookCode = bookDto.getB_code();
		String bookName = bookDto.getB_name();
		
		BookDto dto = null;
		dto = bookDao.findBook(bookCode);
		if(dto != null) {
			System.err.println("중복된 도서코드 입니다");
		}
		
		dto = bookDao.findBook(bookName);
		if(dto != null) {
			System.err.println("중복된 도서명 입니다");
		}
		bookDao.insert(bookDto);
		return 0;
	}

	@Override
	public int update(BookDto bookDto) {
		return bookDao.update(bookDto);
	}

	@Override
	public int disable(String id) {
		return bookDao.disable(id);
	}

}
