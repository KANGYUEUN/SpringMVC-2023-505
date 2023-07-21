package com.ruru.bookRent.dao;

import java.util.List;

import com.ruru.bookRent.model.UserDto;

public interface UserDao {
	public UserDto findUser(String id);

	public List<UserDto> selectAll();

	public UserDto findById(String id);

	public int insert(UserDto userDto);

	public int update(UserDto userDto);

	public int delete(String id);
}
