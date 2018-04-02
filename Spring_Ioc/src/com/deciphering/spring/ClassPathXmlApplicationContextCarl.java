package com.deciphering.spring;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class ClassPathXmlApplicationContextCarl implements BeanFactory {

	private Map<String,Object> bean = new HashMap<String,Object>();
	
	public ClassPathXmlApplicationContextCarl() throws JDOMException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		SAXBuilder saxBuilder = new SAXBuilder();
		
		//构造文档对象
		Document doc = saxBuilder.build(this.getClass().getClassLoader().getResourceAsStream("bean.xml"));
		
		//获取根节点
		Element root = doc.getRootElement();
		
		//获取根下所有bean元素
		List list = root.getChildren();
		for(int i = 0; i< list.size(); i++)
		{
			//获得第i个元素
			Element element = (Element)list.get(i);
			
			//取得第i个元素的id属性值
			String id = element.getAttributeValue("id");
			
			//获得元素的class值
			String classPath = element.getAttributeValue("class");
			
			//生成此对象
			Object o = Class.forName(classPath).newInstance();
			
			System.out.println("此bean的id：" + id);
			System.out.println("此bean的classPath" + classPath);
			bean.put(id, o);
		}
		
	}
	@Override
	public Object getBean(String id) {
		// TODO Auto-generated method stub
		return bean.get(id);
	}

}
