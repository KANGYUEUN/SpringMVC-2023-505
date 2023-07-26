package com.callor.rent.dao;

import java.util.List;

import com.callor.rent.models.RentBookDto;
import com.callor.rent.models.RentBookVO;

public interface RentBookDao {

	public List<RentBookVO> selectAll();
	public RentBookVO findById(long id);
	
	public List<RentBookVO> findByBCode(String bcode);
	public List<RentBookVO> findByMCode(String mcode);
	
	public int insert(RentBookVO dto);
	public int update(RentBookVO dto);
	
	public void create_book_table(String dumy);
	
	// table 만들기 위한 method
	public void create_rent_table(String dumy);
	
}
