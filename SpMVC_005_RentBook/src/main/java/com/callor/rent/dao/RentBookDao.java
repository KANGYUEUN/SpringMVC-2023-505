package com.callor.rent.dao;

import java.util.List;

import com.callor.rent.models.RentBookDto;

public interface RentBookDao {

	public List<RentBookDto> selectAll();
	public RentBookDto findById(long id);
	
	public List<RentBookDto> findByBCode(String bcode);
	public List<RentBookDto> findByMCode(String mcode);
	
	public int insert(RentBookDto dto);
	public int update(RentBookDto dto);
	
	public void create_book_table(String dumy);
	
	
}
