package com.kang.spring.trancationxml.dao;

public interface BookShopDao {

	//��ѯ��ļ۸������ı��
	public int findBookPriceByIsbn(String isbn);
	
	//�������������Ĭ����ĵ�������һ
	public int updateBookCountByIsbn(String isbn);
	
	//�����û���Ǯ�����
	public int updateUserBalanceByUserName(String userName, int price);
}
