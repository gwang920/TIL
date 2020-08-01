package com.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.frame.Biz;
import com.vo.Product;

import oracle.net.aso.l;

@Controller
public class ProductController {
	
	@Resource(name="ps")
	Biz<Integer,Product> biz;
	
	@RequestMapping("/productadd.mc")
	public ModelAndView padd() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("center", "product/add");
		mv.addObject("navi", Navi.productadd);
		
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/productlist.mc")
	public ModelAndView plist() {
		ModelAndView mv = new ModelAndView();
		
		ArrayList<Product> list =null;
		
		try {
			list = biz.select();
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		mv.addObject("plist", list);
		mv.addObject("center", "product/list");
		mv.addObject("navi", Navi.productlist);
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/productaddimpl.mc")
	public ModelAndView paddimpl(ModelAndView mv,Product product) {
		
		
		String imgname=
				product.getMf().getOriginalFilename(); // file이름을 받아오겠다
		product.setImgname(imgname);
		
		try {
			
			biz.insert(product);
			Util.saveFile(product.getMf());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		System.out.println(product);
		mv.setViewName("main");
		return mv;
	}
	
}