package com.frame;

import java.util.ArrayList;

public interface Dao<K,V> {  // key , value  ( genirics )
	//���ʸ����� �̿��ϸ� �� �� ��Ȯ�� Ÿ��üũ�� ������ ���� ���̴�.
	public void insert(V v) throws Exception;
	public void update(V v) throws Exception;
	public void delete(K K) throws Exception;
	public V select(K K) throws Exception;
	public ArrayList<V> select() throws Exception;
}
