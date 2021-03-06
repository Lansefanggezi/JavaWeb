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
		
		//构造文档
		Document doc = saxbuilder.build(JdomSample.class.getClassLoader().getResourceAsStream("test.xml"));
		
		//获取根节点
		Element person = doc.getRootElement();
		
		//获取根节点所有的
		List list = person.getChildren("manber");
		
		for(int i = 0; i<list.size(); i++)
		{
			//获取次节点的Name
			Element element = (Element)list.get(i);
			String people = element.getAttributeValue("name");
			String name = element.getChildText("name");
			String age = element.getChildText("age");
			String sex = element.getChildText("sex");
			
			System.out.println(people + "   姓名:"  + name + " 年龄 ：" + age + "  性别：" + sex);
			
		}
	}
}
