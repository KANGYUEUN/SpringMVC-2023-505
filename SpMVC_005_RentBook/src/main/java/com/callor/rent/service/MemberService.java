package com.callor.rent.service;

import java.util.List;

import com.callor.rent.models.MemberDto;

public interface MemberService {

	public List<MemberDto> selectAll();
	
	public String getNewCode();
	
	public MemberDto findById(String mcode);
		
	public int insert(MemberDto memberDto) throws Exception;
	public int update(MemberDto memberDto) throws Exception;
	
}
