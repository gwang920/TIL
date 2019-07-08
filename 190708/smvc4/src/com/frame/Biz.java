package com.frame;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

public interface Biz<K,V> {  // key , value  ( genirics )
	//���ʸ����� �̿��ϸ� �� �� ��Ȯ�� Ÿ��üũ�� ������ ���� ���̴�.
	@Transactional
	public void insert(V v) throws Exception;
	@Transactional
	public void update(V v) throws Exception;
	@Transactional
	public void delete(K k) throws Exception;  // V v �� key(���� String)���� �ƴ� value(��ü User/Product)���� �����´�
	public V select(K k) throws Exception;
	public ArrayList<V> select() throws Exception;
	
}
