package com.spring.dao;

import com.spring.entitiy.Customers;

public interface BookShopDao {

	//��ѯ�û��Ƿ����
	 int findUserByNameAndPassWord(Customers customers);
	
	//ע���û�
	 int insertUser(Customers customers);
	
	//��ѯ��ļ۸������ı��
	 int findBookPriceByIsbn(int isbn);
	
	//�������������Ĭ����ĵ�������һ
	 int updateBookCountByIsbn(int isbn);
	
	//�����û���Ǯ�����
	 int updateUserBalanceByUserName(String userName, int price);
}
