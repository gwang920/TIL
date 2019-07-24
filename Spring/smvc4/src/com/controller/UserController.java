package com.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.vo.User;

@Controller   
public class UserController {
	
	@Resource(name="us")
	Biz<String,User> biz;
	
	@RequestMapping("/useradd.mc")
	public ModelAndView uadd() {
		ModelAndView mv = new ModelAndView();      //ModelAndView 데이터와 화면을 어떻게 할까
		mv.addObject("center", "user/add");  // 폴더 접근
		mv.addObject("navi", Navi.useradd);  //  파일 내 기능접근
		
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/useraddimpl.mc")
	public ModelAndView useraddimpl(ModelAndView mv,
			User user) {
		System.out.println(user);
		try {
			biz.insert(user);
			mv.addObject("center", "user/useraddimplok");
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("center", "user/useraddimplfail");

		}
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/userlist.mc")
	public ModelAndView ulist() {
//		String id=request.getParameter("id");
//		String pwd=request.getParameter("pwd");
//		String name=request.getParameter("name");
//		
//		User user=new User(id,pwd,name);

		ModelAndView mv = new ModelAndView();
		ArrayList<User> ulist=null;
		try {
			ulist=biz.select();
		} catch (Exception e) {
		
			
		}
		
		mv.addObject("userlist", ulist); //key와 value를 담아 보낼 수 있는 메서드
		mv.addObject("center", "user/list"); //key와 value를 담아 보낼 수 있는 메서드
		mv.addObject("navi", Navi.userlist);
		mv.setViewName("main");  //어떤 페이지를 보여줄 것인지
		return mv;
	}
	
	@RequestMapping("/userdetail.mc")
	public ModelAndView udetail(
			ModelAndView mv,String id) {
		
		User user = null;
		
		try {
			user = biz.select(id);
			mv.addObject("userdetail", user);		
			mv.addObject("center", "user/detail");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mv.setViewName("main");
		return mv;
	}
	
//	@RequestMapping("/userupdateimpl.mc")
//	public String userupdateimpl(User user) {
//		
//		
//		
//		try {
//			user = biz.update(user);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//
//		return "redirect:userdetail.mc?id="+user.getId();
//	}
	
	@RequestMapping("/userupdateimpl.mc")
	public String userudpateimpl(User user) {
		try {
			biz.update(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:userdetail.mc?id="+user.getId();
	}
	
	@RequestMapping("/userupdate.mc")
	public ModelAndView uudpate(
			ModelAndView mv,String id) {
		
		User user = null;
		
		try {
			user = biz.select(id);
			mv.addObject("userupdate", user);		
			mv.addObject("center", "user/update");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/userdelete.mc")
	public String udel(ModelAndView mv,String id) {
		
		try {
			biz.delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:userlist.mc";
	}
}