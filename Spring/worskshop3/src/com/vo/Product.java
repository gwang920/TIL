package com.vo;

public class Product {

	
		private Integer id;
		private String pwd;
		private String name;
		
		
		public Product() {
		
		}


		public Product(int id, String pwd, String name) {
			super();
			this.id = id;
			this.pwd = pwd;
			this.name = name;
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getPwd() {
			return pwd;
		}


		public void setPwd(String pwd) {
			this.pwd = pwd;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		@Override
		public String toString() {
			return "Product [id=" + id + ", pwd=" + pwd + ", name=" + name + "]";
		}
		
		
		
		
		
		
		
}
