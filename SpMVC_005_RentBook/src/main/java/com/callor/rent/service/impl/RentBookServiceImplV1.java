package com.callor.rent.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.rent.dao.RentBookDao;
import com.callor.rent.models.RentBookDto;
import com.callor.rent.service.RentBookService;

@Service
public class RentBookServiceImplV1 implements RentBookService{

	protected final RentBookDao rentBookDao;
	public RentBookServiceImplV1(RentBookDao rentBookDao) {
		this.rentBookDao = rentBookDao;
	}

	@Override
	public List<RentBookDto> selectAll() {
		return rentBookDao.selectAll();
	}

	@Override
	public RentBookDto findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RentBookDto> findByBCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RentBookDto> findByMCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create_rent_book_table(String dumy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int insert(RentBookDto rentBookDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(RentBookDto rentBookDto) {
		// TODO Auto-generated method stub
		return 0;
	}

}
