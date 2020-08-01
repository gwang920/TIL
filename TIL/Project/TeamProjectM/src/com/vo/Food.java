package com.vo;

public class Food {
	int id;
	String name;
	String imgName1;
	String imgName2;
	String imgName3;
	String category;
	public Food() {
		super();
	}
	public Food(int id, String name, String imgName1, String imgName2, String imgName3, String category) {
		super();
		this.id = id;
		this.name = name;
		this.imgName1 = imgName1;
		this.imgName2 = imgName2;
		this.imgName3 = imgName3;
		this.category = category;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImgName1() {
		return imgName1;
	}
	public void setImgName1(String imgName1) {
		this.imgName1 = imgName1;
	}
	public String getImgName2() {
		return imgName2;
	}
	public void setImgName2(String imgName2) {
		this.imgName2 = imgName2;
	}
	public String getImgName3() {
		return imgName3;
	}
	public void setImgName3(String imgName3) {
		this.imgName3 = imgName3;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Food [id=" + id + ", name=" + name + ", imgName1=" + imgName1 + ", imgName2=" + imgName2 + ", imgName3="
				+ imgName3 + ", category=" + category + "]";
	}
	
	
	
	
}
