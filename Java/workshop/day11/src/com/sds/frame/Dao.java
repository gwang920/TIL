package com.sds.frame;

import java.util.ArrayList;

public abstract class Dao<K,V> {
	public abstract void insert(V v) 
			throws Exception;
	public abstract void delete(K k) 
			throws Exception;
	public abstract void update(V v) 
			throws Exception;
	public abstract V select(K k) //키 값을 주면 value값을 리턴한다
			throws Exception;
	public abstract ArrayList<V> select() 
			throws Exception;
}


//Dao.java 인터페이스 기능 만 정의한 것






