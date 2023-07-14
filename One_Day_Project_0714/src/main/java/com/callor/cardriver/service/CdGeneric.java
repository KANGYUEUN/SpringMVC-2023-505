package com.callor.cardriver.service;

import java.util.List;

import com.callor.cardriver.models.CdDto;

public interface CdGeneric<DTO, PK> {

	public List<DTO> selectAll();
	public CdDto findById(PK id);
	public int insert(DTO dto);
	public int update(DTO dto);
	public int delete(PK id);
}
