package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {


	
	@RequestMapping("/productadd.mc")
	public ModelAndView padd() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "product/add");
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/productlist.mc")
	public ModelAndView plist() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "product/list");
		mv.setViewName("main");
		return mv;
	}
	
}








