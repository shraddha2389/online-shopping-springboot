package com.dss.shopping_backend.dao;

import java.util.List;

import com.dss.shopping_backend.dto.Category;

public interface CategoryDAO {

	List<Category> list();
	Category get(int id) ;
		
	
}
