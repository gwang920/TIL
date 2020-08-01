package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller   
public class UserController {

	@RequestMapping("/useradd.mc")
	public ModelAndView uadd() {
		ModelAndView mv = new ModelAndView();      //ModelAndView 데이터와 화면을 어떻게 할까
		mv.addObject("center", "user/add");  // 폴더 접근
		mv.addObject("navi", Navi.useradd);  //  파일 내 기능접근
	
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/userlist.mc")
	public ModelAndView ulist() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "user/list"); //key와 value를 담아 보낼 수 있는 메서드
		mv.setViewName("main");  //어떤 페이지를 보여줄 것인지
		return mv;
	}
}