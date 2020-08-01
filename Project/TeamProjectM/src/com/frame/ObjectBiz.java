package com.frame;

import java.util.ArrayList;

public interface ObjectBiz<K,V> {
	public void insert(V v);
	public void delete(K k);
	public void update(V v);
	public ArrayList<V> select(K k);
	public ArrayList<V> selectAll();
}
