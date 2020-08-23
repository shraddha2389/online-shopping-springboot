package com.dss.shopping_backend.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dss.shopping_backend.dto.Category;

@Service
public interface CategoryDAO {

	Category get(int id) ; //Retrieve single category
	
	List<Category> list(); //Retrieve list of category
	
	boolean add(Category category);//adding new category database
	
	boolean update(Category category);//deleting  category from database
	
	boolean delete(Category category);//deleting  category from database

	
	
}
