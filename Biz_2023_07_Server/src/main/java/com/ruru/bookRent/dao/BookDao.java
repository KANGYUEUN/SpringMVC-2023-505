package com.ruru.bookRent.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.ruru.bookRent.model.BookDto;

public interface BookDao {

	public BookDto findBook(String id);
		
	// 도서정보리스트 도서명, 저자 
	@Select(" SELECT * FROM tbl_books "
			+ " ORDER BY B_NAME DESC, B_AUTHER DESC " )
	public List<BookDto> selectAll();
	
	public int insert(BookDto bookDto);
	public int update(BookDto bookDto);

	public int disable(String id);
}
