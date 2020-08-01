package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {


	
	@RequestMapping("/login.mc")
	public ModelAndView padd() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "login");
		mv.setViewName("main");
		return mv;
	}
//	@RequestMapping(value="/loginmm.mc" )
//	public ModelAndView padd(WebRequest wr) {
//		String id = wr.getParameter("id");
//		String pwd = wr.getParameter("pwd");
	
	@RequestMapping(value="/loginmm.mc" )
	public ModelAndView padd(String id, String pwd) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "login");
		System.out.println(id+" "+pwd);
		mv.setViewName("main");
		return mv;
	}
}
