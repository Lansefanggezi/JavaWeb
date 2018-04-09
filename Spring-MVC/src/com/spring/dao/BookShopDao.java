package com.spring.dao;

public interface BookShopDao {

	//��ѯ�û��Ƿ����
	public int findUserByNameAndPassWord(String userName, String password);
	
	//ע���û�
	public void updateUser(String username,String password);
	
	//��ѯ��ļ۸������ı��
	public int findBookPriceByIsbn(String isbn);
	
	//�������������Ĭ����ĵ�������һ
	public int updateBookCountByIsbn(String isbn);
	
	//�����û���Ǯ�����
	public int updateUserBalanceByUserName(String userName, int price);
}
