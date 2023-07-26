package com.callor.rent.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.callor.rent.models.MemberDto;

public interface MemberDao {
	
	// 이름으로 정렬하기 
	@Select("SELECT * FROM tbl_members ORDER BY m_code")
	public List<MemberDto> selectAll();
	
	@Select("SELECT * FROM tbl_members WHERE m_code = #{id}")
	public MemberDto findById(String id);
	
	@Select("SELECT * FROM tbl_members "
			+ "WHERE m_name LIKE CONCAT('%', #{name}, '%')"
			+ " ORDER BY m_name")
	public List<MemberDto> findByName(String name);
	
	@Select("SELECT * FROM tbl_members "
			+ "WHERE m_tel LIKE CONCAT('%', #{tel}, '%')"
			+ " ORDER BY m_tel")
	public List<MemberDto> findByTel(String tel);

	@Select("SELECT MAX(m_code) FROM tbl_members")
	public String getMaxMCode();
	
	public void create_member_table(String dumy);
	
	
	public int insert(MemberDto memberDto);
	public int update(MemberDto memberDto);

	
	@Select(" SELECT * FROM tbl_members "
			+ " WHERE m_name = #{name} AND m_tel = #{tel} ")
	public MemberDto findByNameAndTel(@Param("name") String name, @Param("tel") String tel);
	
	
	
	
}
