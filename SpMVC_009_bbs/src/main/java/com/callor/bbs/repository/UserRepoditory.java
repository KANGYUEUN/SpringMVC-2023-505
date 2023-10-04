package com.callor.bbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.callor.bbs.models.UserDto;

public interface UserRepoditory extends JpaRepository<UserDto, Long>{

	
	
}
