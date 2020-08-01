package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	// index.html -> index.mc(url-pattern) -> @Controller -> @RequestMapping -> mv return
	@RequestMapping("/index.mc")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("/error.mc")
	public ModelAndView error() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("view/error");
		
		return mv;
		
	}
}
