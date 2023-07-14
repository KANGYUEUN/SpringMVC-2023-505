package com.callor.cardriver.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.cardriver.models.CdDto;

public interface CdDao {

	@Select("SELECT * FROM tbl_cardrive ORDER BY cd_seq DESC LIMIT 10")
	public List<CdDto> selectAll();
	
	@Select("SELECT COUNT(*) FROM tbl_cardrive WHERE cd_ardate is null ORDER BY cd_seq DESC LIMIT 1 ")
	public int lastSelectCheck();
	
	@Select("SELECT * FROM tbl_cardrive WHERE cd_ardate is null ORDER BY cd_seq DESC LIMIT 1 ")
	public CdDto lastSelect();
	
	public int insertCd(CdDto cdDto);
	public int updateCd(CdDto cdDto);
	
	
}
