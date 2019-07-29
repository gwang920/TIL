package com.sds.component;

import java.util.ArrayList;

import com.sds.frame.Biz;
import com.sds.frame.Dao;
import com.sds.vo.User;

public class UserBiz extends Biz<String, User> {

	Dao<String,User> dao; //biz�� Dao�� �ʿ��ϴ�
	
	public UserBiz() {
		dao = new UserDao();
	}
	
	@Override
	public void register(User v) throws Exception {

		//�������� ���� �ڵ�
//		checkData(v);
//		transactionStart();
//		dao.insert(v);  //dao���� insert�� ��û.  dao���� exception �̿��� resgister �Լ��� exception�� 
//		transactionEnd(); //��, transactionEnd(); �� ��������ʴ´�. ==> database�� end�� �ƴ��� �ν� X


		checkData(v);
		transactionStart();
		try {
			dao.insert(v);
		}catch(Exception e) {   //������ ������
			throw e;  //������
		}finally {		//finally (�ᱹ) �� �����ض� (�����̵� �������̵�)
			transactionEnd();
		}
		
	}

	@Override
	public void remove(String k) throws Exception {
		transactionStart();
		try {
			dao.delete(k);
		}catch(Exception e) {
			throw e;
		}finally {
			transactionEnd();
		}		
	}

	@Override
	public void modify(User v) throws Exception {
		checkData(v);
		transactionStart();
		try {
			dao.update(v);
		}catch(Exception e) {
			throw e;
		}finally {
			transactionEnd();
		}
	}

	@Override
	public User get(String k) throws Exception {
		return dao.select(k);
	}

	@Override
	public ArrayList<User> get() throws Exception {
		return dao.select();
	}
}
