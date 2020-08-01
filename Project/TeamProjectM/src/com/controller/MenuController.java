package com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.frame.ObjectBiz;
import com.frame.StringBiz;
import com.mapper.preferenceMapper;
import com.vo.Food;

@Controller
public class MenuController {

	@RequestMapping(value="/menu_add_table_add_list.mc", produces="application/text; charset=utf8")
	@ResponseBody
	public String addMenuList(@RequestParam("id") String id) {
		ObjectMapper obm = new ObjectMapper();
		AbstractApplicationContext factory = new GenericXmlApplicationContext("MySpring.xml");
		ObjectBiz<String,Food> foodList = (ObjectBiz<String, Food>)factory.getBean("FoodBiz");
		String val ="fail";
		
		try {
			if(id == "") val = obm.writeValueAsString(foodList.selectAll());
			else val = obm.writeValueAsString(foodList.select(id));
			System.out.println(val);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		mv.addObject("menuList",foodList.selectAll());
		return val;
	}
	@Autowired
	preferenceMapper pm;
	
	
	@RequestMapping(value="/add_pre_roullet.mc",  produces="application/text; charset=utf8")
	@ResponseBody
	public String addPreInRoullet(@RequestParam("id") String id) {
		
		ObjectMapper obm = new ObjectMapper();
		AbstractApplicationContext factory = new GenericXmlApplicationContext("MySpring.xml");
		StringBiz<String,String> preBiz = (StringBiz<String,String>)factory.getBean("PreferenceBiz");
		String val ="fail";

		try {
			val = obm.writeValueAsString(pm.selectById(id));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return val;
	}
	
	@RequestMapping("AddPre.mc")
	@ResponseBody
	public String addPreTable(@RequestParam("id") String id,@RequestParam("name") String name) {
		
//		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("MySpring.xml");
		StringBiz<String, String> PreBiz = (StringBiz<String, String>)factory.getBean("PreferenceBiz");
		try {
			PreBiz.insert(id, name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
		return "success";
	}
	
	@RequestMapping("AddIgnore.mc")
	@ResponseBody
	public String addIgnTable(@RequestParam("id") String id,@RequestParam("name") String name) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("MySpring.xml");

		StringBiz<String,String> IgnBiz = (StringBiz<String,String>)factory.getBean("IgnoreBiz");
		try {
			IgnBiz.insert(id, name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
		return "success";
	}
	
}
