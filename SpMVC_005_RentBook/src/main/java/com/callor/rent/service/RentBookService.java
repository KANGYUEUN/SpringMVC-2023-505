package com.callor.rent.service;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.rent.models.RentBookDto;

public interface RentBookService {

	// 일련번호 순으로 정렬하기 
	@Select("SELECT * FROM tbl_rent_book ORDER BY rent_seq")
	public List<RentBookDto> selectAll();
	
	@Select("SELECT * FROM tbl_rent_book WHERE rent_seq = #{id}")
	public RentBookDto findById(String id);
	
	@Select("SELECT * FROM tbl_rent_book "
			+ "WHERE rent_bcode LIKE CONCAT('%', #{bcode}, '%' ORDER BY rent_seq")
	public List<RentBookDto> findByBCode(String code);
	
	@Select("SELECT * FROM tbl_rent_book "
			+ "WHERE rent_bcode LIKE CONCAT('%', #{mcode}, '%' ORDER BY rent_seq")
	public List<RentBookDto> findByMCode(String code);
	
	public void create_rent_book_table(String dumy);
	
	public int insert(RentBookDto rentBookDto);
	public int update(RentBookDto rentBookDto);
	
	
	
	
	
	
	
}
