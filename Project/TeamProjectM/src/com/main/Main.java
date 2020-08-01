package com.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.frame.StringDao;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext factory = new GenericXmlApplicationContext("MySpring.xml");
//		ObjectBiz<String,User> userBiz = (ObjectBiz<String,User>)factory.getBean("UserBiz");
//		userBiz.update(new User("id03","pw01","name1","1000","IDontKnow"));
//		ObjectBiz<String,Board> BoardBiz = (ObjectBiz<String, Board>)factory.getBean("BoardBiz");
//		BoardBiz.insert(new Board("id01", "","", "", "badTitle", 100, "badcontent",100));
//		System.out.println(BoardBiz.selectAll().get(0));
//		StringBiz<String,String> categoryBiz = (StringBiz<String,String>)factory.getBean("CategoryBiz");
//		System.out.println(categoryBiz.select("1000").toString());
//		categoryBiz.delete("1001");
//		ObjectBiz<String,Food> foodBiz = (ObjectBiz<String,Food>)factory.getBean("FoodBiz");
//		foodBiz.insert(new Food("nuneTine", "", "", "", 1000));
		StringDao<String,String> ignoreDao = (StringDao<String, String>) factory.getBean("PreferenceDao");
		ignoreDao.insert("id01", "1040");
//		StringDao<String,String> hintDao = (StringDao<String, String>) factory.getBean("HintDao");
//		System.out.println(hintDao.select("1000").toString());
		
	}

}
