package com.frame;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

public interface Biz<K,V> {  // key , value  ( genirics )
	//제너릭스를 이용하면 좀 더 명확한 타입체크가 가능해 지는 것이다.
	@Transactional
	public void insert(V v) throws Exception;
	@Transactional
	public void update(V v) throws Exception;
	@Transactional
	public void delete(K k) throws Exception;  // V v 면 key(변수 String)값이 아닌 value(객체 User/Product)값을 가져온다
	public V select(K k) throws Exception;
	public ArrayList<V> select() throws Exception;
	
}
