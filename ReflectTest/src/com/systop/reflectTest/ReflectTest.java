package com.systop.reflectTest;

import java.lang.reflect.Field;

public class ReflectTest {
	private String fname;
	private String lname;
	
	//����ReflectTest��Ĺ��췽��
	public ReflectTest(String fname, String lname)
	{
		this.fname = fname;
		this.lname = lname;
	}

	public static void main(String[] args) {
		try {
			// ����ReflectTest����ͬʱ��ʼ�����������
			ReflectTest reflect = new ReflectTest("jack","saas");
			
			fun(reflect);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//��̬����
	public static void fun(Object obj) throws IllegalArgumentException, IllegalAccessException
	{
		//��ȡobg.getClass()������г�Ա�����б��������fleds������
		Field[] fields = obj.getClass().getDeclaredFields();
		System.out.println("�滻֮ǰ��");
		
		//��fields�����е�ֵ���е���
		for(Field field : fields)
		{
			//��ӡfield�е�ǰ��ŵ�obj�����������������ֵ
			System.out.println("����" + field.getName() + "  value:" +field.get(obj));
			
			//�˴���������Ϊtrue�ſ����޸ĳ�Ա����
			field.setAccessible(true);
			
			String org = (String) field.get(obj);
			field.set(obj, org.replaceAll("a", "b"));
		}
		System.out.println("�滻֮��");
		for(Field field: fields)
		{
			System.out.println("����" + field.getName() + "   value:" +field.get(obj));
		}
	}
}