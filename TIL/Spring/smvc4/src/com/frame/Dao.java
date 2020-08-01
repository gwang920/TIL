package com.frame;

import java.util.ArrayList;

public interface Dao<K,V> {  // key , value  ( genirics )
	//제너릭스를 이용하면 좀 더 명확한 타입체크가 가능해 지는 것이다.
	public void insert(V v) throws Exception;
	public void update(V v) throws Exception;
	public void delete(K K) throws Exception;
	public V select(K K) throws Exception;
	public ArrayList<V> select() throws Exception;
}
