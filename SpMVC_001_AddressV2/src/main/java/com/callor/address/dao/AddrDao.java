package com.callor.address.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.callor.address.models.AddrDto;

public interface AddrDao {
	
	@Select("SELECT * FROM tbl_address ORDER BY a_id")
	public List<AddrDto> selectAll();
	
	/*
	 * Dto return 할때와 List 를 return 할때
	 * 만약 찾는 값이 없으면
	 * 		 Dto return 할때는 null 값
	 * 		List return 할때는 empty 값
	 * 값이 있는지 없는지 검사 할때
	 * 		Dto return if(dto == null)
	 * 		List return if(List.isEmpty())
	 */
	
	@Select("SELECT * FROM tbl_address WHERE a_id = #{id}")
	public AddrDto findById(String id);
	
	public List<AddrDto> findByName(String name);

	public int update(AddrDto addrDto);

	@Delete("DELETE FROM tbl_address WHERE a_id = #{id}")
	public int delete(String id);

	public int insert(AddrDto addrDto);
}
