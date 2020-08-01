package com.vo;

public class User {
	String id;
	String pwd;
	String name;
	String hint;
	String hint_answer;
	
	public User() {
		super();
	}

	

	public User(String pwd, String name, String hint, String hint_answer) {
		super();
		this.pwd = pwd;
		this.name = name;
		this.hint = hint;
		this.hint_answer = hint_answer;
	}



	public User(String id, String pwd, String name, String hint, String hint_answer) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.hint = hint;
		this.hint_answer = hint_answer;
	}

	public String getHint_answer() {
		return hint_answer;
	}

	public void setHint_answer(String hint_answer) {
		this.hint_answer = hint_answer;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	


	public String getHint() {
		return hint;
	}



	public void setHint(String hint) {
		this.hint = hint;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", pwd=" + pwd + ", name=" + name + ", hint=" + hint + ", hint_id=" + hint_answer + "]";
	}
		
	
}
