package com.vo;

public class Board {
	int id;
	String author;
	String imgname1;
	String imgname2;
	String imgname3;
	String title;
	int viewCount;
	String content;
	int re_id;
	public Board() {
		super();
	}
	
	//id가 없음 ,insert용
	public Board(String author, String imgname1, String imgname2, String imgname3, String title, int viewCount,
			String content, int re_id) {

		this.author = author;
		this.imgname1 = imgname1;
		this.imgname2 = imgname2;
		this.imgname3 = imgname3;
		this.title = title;
		this.viewCount = viewCount;
		this.content = content;
		this.re_id = re_id;
	}

	//id가 있음, insert 외
	public Board(int id, String author, String imgname1, String imgname2, String imgname3, String title, int viewCount,
			String content, int re_id) {

		this.id = id;
		this.author = author;
		this.imgname1 = imgname1;
		this.imgname2 = imgname2;
		this.imgname3 = imgname3;
		this.title = title;
		this.viewCount = viewCount;
		this.content = content;
		this.re_id = re_id;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public String getImgname1() {
		return imgname1;
	}



	public void setImgname1(String imgname1) {
		this.imgname1 = imgname1;
	}



	public String getImgname2() {
		return imgname2;
	}



	public void setImgname2(String imgname2) {
		this.imgname2 = imgname2;
	}



	public String getImgname3() {
		return imgname3;
	}



	public void setImgname3(String imgname3) {
		this.imgname3 = imgname3;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public int getViewCount() {
		return viewCount;
	}



	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public int getRe_id() {
		return re_id;
	}



	public void setRe_id(int re_id) {
		this.re_id = re_id;
	}



	@Override
	public String toString() {
		return "Board [id=" + id + ", author=" + author + ", imgname1=" + imgname1 + ", imgname2=" + imgname2
				+ ", imgname3=" + imgname3 + ", title=" + title + ", viewCount=" + viewCount + ", content=" + content
				+ ", re_id=" + re_id + "]";
	}
	
}
