package com.ruru.bookRent.service;

import java.util.List;

import com.ruru.bookRent.model.BookDto;

public interface BookService {

	public BookDto findBook(String id);
	public List<BookDto> selectAll();
	public int insert(BookDto bookDto);
	public int update(BookDto bookDto);
	public int disable(String id);
}
