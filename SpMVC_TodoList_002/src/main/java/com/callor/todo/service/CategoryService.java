package com.callor.todo.service;

import com.callor.todo.models.CategoryDto;

public interface CategoryService extends TodoGeneric<CategoryDto, String>{

	public void printCategory();
	
}
