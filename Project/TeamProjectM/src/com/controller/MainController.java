package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
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
//	@RequestMapping("/login.mc")
//	public ModelAndView login() {
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("center", "login");
////		mv.addObject("navi", Navi.login);
//		mv.setViewName("main");
//		return mv;
//	}
//	@RequestMapping("/join.mc")
//	public ModelAndView register() {
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("center", "join");
////		mv.addObject("navi", Navi.register);
//		mv.setViewName("main");
//		return mv;
//	}
}
