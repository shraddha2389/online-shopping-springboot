package com.dss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dss.shopping_backend.dao.CategoryDAO;
import com.dss.shopping_backend.dto.Category;

@Controller
public class pagecontroller {

	//add dependancy injection
	@Autowired
	private CategoryDAO categoryDao;
	
	@RequestMapping({"/" , "/home","/index"})
	public ModelAndView index()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "Home");
		
		mv.addObject("categories", categoryDao.list());
		mv.addObject("userClickHome",true);
		return mv;	
	}
	
	@RequestMapping("/about")
	public ModelAndView about()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout",true);
		return mv;	
	}

	@RequestMapping("/contact")
	public ModelAndView contact()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact",true);
		return mv;	
	}
	
	/*mapping for view products */
	@RequestMapping(value="show/all/products")
	public ModelAndView showAllProducts()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "All Products");
		
		/*Passing the list f categry here */
		mv.addObject("categories", categoryDao.list());
		mv.addObject("userClickAllProducts",true);
		return mv;	
	}
	
	/*mapping for categoriwise  productpaths */
	@RequestMapping(value="show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id)
	{
		ModelAndView mv=new ModelAndView("page");
		
		//categoryDAO to fetch single category 
		Category category=null;
		category=categoryDao.get(id);
		
		mv.addObject("title",category.getName());
		
		
		/*Passing the list of categry here */
		mv.addObject("catergories", categoryDao.list());
		
		
		//passing single category
		mv.addObject("category",category);
		
		mv.addObject("userClickCategoryProducts",true);
		return mv;	
	}
	
	
}
