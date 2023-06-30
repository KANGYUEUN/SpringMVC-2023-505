package com.callor.address.service;

import java.util.List;

import com.callor.address.models.AddrDto;

/*
 * Service Spring Project 에서 비즈니스 로직을 담당하는 부분
 * Controller에서 데이터를 받고, 일부 데이터를 가공하여 Dao로 전달.
 * Dao에서 return한 데이터를 받고, 일부 데이터를 가공하여 Controller로 전달.
 * 
 */
public interface AddrService {

	public List<AddrDto> selectAll();
	public AddrDto findById(String id);
	
	public String idCheck(String id);
	
	public List<AddrDto> findByName(String name);
	public List<AddrDto> findByTel(String tel);
	
	public int insert(AddrDto addrDto);
	public int update(AddrDto addrDto);
	public int delete(AddrDto addrDto);
}
