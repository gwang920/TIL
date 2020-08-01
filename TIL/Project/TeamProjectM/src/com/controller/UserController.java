package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.frame.ObjectBiz;
import com.vo.User;

@Controller
public class UserController {
	
	
	@Autowired
	@Qualifier("UserBiz")
	ObjectBiz<String, User> biz;
	
	@RequestMapping("/login.mc")
	public ModelAndView login(ModelAndView mv) {
		
		System.out.println("login");
		mv.addObject("center", "login");
		mv.setViewName("index");
		return mv;
	}
	
	
	
	
	@RequestMapping("/loginimpl.mc")
	@ResponseBody
	public void loginimpl(String id, String pwd, HttpServletResponse response, HttpSession session) {		
		ArrayList<User> users = biz.select(id);
		String result = "";
		response.setCharacterEncoding("UTF-8");
		if (users.size() != 0 && pwd != null && !pwd.equals("") && users.get(0).getPwd().equals(pwd)) {
			session.setAttribute("loginInfo", users.get(0));
			session.setMaxInactiveInterval(1000);
			result = "1";
			PrintWriter out;
			try {
				out = response.getWriter();
				out.print(result);
				out.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}else {
			PrintWriter out;
			try {
				result = "0";
				out = response.getWriter();
				out.print(result);
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@RequestMapping("/logout.mc")
	public ModelAndView logout(ModelAndView mv, HttpSession session) {
		mv.setViewName("index");
		if (session != null) {
			session.invalidate();
		}
		return mv;
	}
	
	@RequestMapping("/join.mc")
	public ModelAndView join(ModelAndView mv) {
		
		System.out.println("join");
		mv.addObject("center", "join");
		mv.setViewName("index");
		
		return mv;
	}
	
	@RequestMapping("/joinimpl.mc")
	public ModelAndView joinImpl(ModelAndView mv, User user) {
		System.out.println("joinimpl");
		mv.setViewName("index");
		biz.insert(user);
		System.out.println(user);
		return mv;
	}

	
	@RequestMapping("/updateimpl.mc")
	public ModelAndView updateImpl(ModelAndView mv, User user, HttpSession session) {
		System.out.println("updateimpl");

		System.out.println(user);
		biz.update(user);
		session.setAttribute("updateInfo", user);
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("/check.mc")
	@ResponseBody
	public void check(String id, HttpServletResponse response) {
		
		ArrayList<User> users = biz.select(id);
		String result = "";
		response.setCharacterEncoding("UTF-8");
		
		if(users.size() == 0) {
			try {
				result = "1";
				PrintWriter out = response.getWriter();
				out.print(result);
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			try {
				result = "0";
				PrintWriter out = response.getWriter();
				out.print(result);
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	@RequestMapping("/find.mc")
	@ResponseBody
	public void find(String id, String name, HttpServletResponse response, HttpSession session) {
		ArrayList<User> users = biz.select(id);
		String result = ""; 
		response.setCharacterEncoding("UTF-8");

		if (users.size() != 0 && name != null && !name.equals("") && users.get(0).getName().equals(name)) {
//			System.out.println(users);
			/*
			 * session.setAttribute("findInfo", user); session.setMaxInactiveInterval(1000);
			 * result = user.getPwd(); System.out.println(result);
			 */
			result = users.get(0).getHint();
			response.setContentType("text/json; charset=UTF-8");
			
			JSONObject jo = new JSONObject();
			jo.put("id", users.get(0).getId());
			jo.put("name", users.get(0).getName());
			jo.put("hint", users.get(0).getHint());
			jo.put("hint_answer", users.get(0).getHint_answer());
			jo.put("pwd", users.get(0).getPwd());
			
			PrintWriter out;
			try {
				out = response.getWriter();
				out.print(jo);
//				out.print(resu);
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			PrintWriter out;
			try {
				result = "0";
				out = response.getWriter();
				out.print(result);
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
