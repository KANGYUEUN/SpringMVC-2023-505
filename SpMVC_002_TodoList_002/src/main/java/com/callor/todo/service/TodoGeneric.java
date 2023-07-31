package com.callor.todo.service;

import java.util.List;

import com.callor.todo.models.TodoDto;

public interface TodoGeneric<DTO, PK> {

	public List<DTO> selectAll();
	public TodoDto findById(PK id);
	public int insert(DTO dto);
	public int update(DTO dto);
	public int delete(PK id);
}
