package com.dss.shopping_backend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dss.shopping_backend.dao.CategoryDAO;
import com.dss.shopping_backend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

 @Autowired
 private SessionFactory sessionFactory;


	
	@Override
	public List<Category> list() {
		
		return null;
	}


	@Override
	public Category get(int id) {
		
		
		return null;
	}


	@Override
	
	public boolean add(Category category) {
		
	    try{
			//add category to databse table
			sessionFactory.getCurrentSession().persist(category);
			
			return true;
	       }
		   catch (Exception e) 
		   {
			e.printStackTrace();
			return false;
		   }
	}


	@Override
	public boolean update(Category category) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean delete(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

}
