package com.sds.frame;

import java.util.ArrayList;

public abstract class Biz<K,V> {
		public abstract void register(V v) // value가 들어오면 등록을 하겠다
				throws Exception;
		public abstract void remove(K k)  // 추상메소드 ==>반드시 하위클래스에서 바디를 제작하겠다는 의미
				throws Exception;
		public abstract void modify(V v) 
				throws Exception;
		public abstract V get(K k) 
				throws Exception;
		public abstract ArrayList<V> get() 
				throws Exception;
		public void checkData(V v) {         //user의 data 검사 id,password 등등
			System.out.println("Check OK ...");
		}
		public void transactionStart() {
			System.out.println("Transaction Start ...");
		}
		public void transactionEnd() {
			System.out.println("Transaction End ...");
		}
}