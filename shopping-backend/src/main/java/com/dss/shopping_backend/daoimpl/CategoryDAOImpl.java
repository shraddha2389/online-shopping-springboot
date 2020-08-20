package com.dss.shopping_backend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.dss.shopping_backend.dao.CategoryDAO;
import com.dss.shopping_backend.dto.Category;

@Repository("categoryDao")
public class CategoryDAOImpl implements CategoryDAO {

 public static List<Category> categories=new ArrayList<>();
 
 //adding some dummy data for testing purpose
 
 static{
	  
	   Category category=new Category();
	   category.setId(1);
	   category.setName("Television");
	   category.setDecription("This is some Desc for Television");
	   category.setImageURL("CAT_1.png");
	 
	   categories.add(category);
	   
	   //add second category 
	   category=new Category();
	   category.setId(2);
	   category.setName("Mobile");
	   category.setDecription("This is some Desc for Mobile");
	   category.setImageURL("CAT_2.png");
	 
	   categories.add(category);
	   
	   //add third category 
	   category=new Category();
	   category.setId(3);
	   category.setName("Laptop");
	   category.setDecription("This is some Desc for Laptop");
	   category.setImageURL("CAT_3.png");
	 
	   categories.add(category);
	   
       }
 
	
	@Override
	public List<Category> list() {
		
		return categories;
	}


	@Override
	public Category get(int id) {
		
		for(Category catoegry:categories)
		{
			if(catoegry.getId() == id)
				return catoegry;
		}
		
		
		return null;
	}

}
