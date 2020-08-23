package com.dss.shopping_backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dss.shopping_backend.dao.CategoryDAO;
import com.dss.shopping_backend.dto.Category;

public class CategoryTestCase {

	public static AnnotationConfigApplicationContext context;
	
	public static CategoryDAO categoryDAO;  //here we have written method to check whether category added in table or not 

     private Category category;
     
	 @BeforeClass
     public static void init()
     {
    	 context =new AnnotationConfigApplicationContext();
    	 context.scan("com.dss.shopping_backend");
    	 context.refresh();
    	 
    	 categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
     }
	 
	 @Test
	 public  void testAddCategory()
	 {
		category=new Category();
		category.setName("Television");
	    category.setDecription("This is some Desc for Television");
	    category.setImageURL("CAT_1.png");
	    
	    assertEquals("Successfully Added Category inside table",true,categoryDAO.add(category));
	 }
}
