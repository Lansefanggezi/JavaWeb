package com.jdom.test;

import java.io.IOException;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class JdomSample {

	public static void main(String[] args) throws JDOMException, IOException
	{
		SAXBuilder saxbuilder = new SAXBuilder();
		
		//�����ĵ�
		Document doc = saxbuilder.build(JdomSample.class.getClassLoader().getResourceAsStream("test.xml"));
		
		//��ȡ���ڵ�
		Element person = doc.getRootElement();
		
		//��ȡ���ڵ����е�
		List list = person.getChildren("manber");
		
		for(int i = 0; i<list.size(); i++)
		{
			//��ȡ�νڵ��Name
			Element element = (Element)list.get(i);
			String people = element.getAttributeValue("name");
			String name = element.getChildText("name");
			String age = element.getChildText("age");
			String sex = element.getChildText("sex");
			
			System.out.println(people + "   ����:"  + name + " ���� ��" + age + "  �Ա�" + sex);
			
		}
	}
}