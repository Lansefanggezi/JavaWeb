package com.deciphering.spring;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class ClassPathXmlApplicationContextCarl implements BeanFactory {

	private Map<String,Object> bean = new HashMap<String,Object>();
	
	public ClassPathXmlApplicationContextCarl() throws JDOMException, IOException, InstantiationException, IllegalAccessException,
					ClassNotFoundException, NoSuchMethodException, SecurityException, 
					IllegalArgumentException, InvocationTargetException
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
			
			//实现依赖注入
			//便利Bean下的所有property节点
			for(Element elementSon : (List<Element>)element.getChildren("property"))
			{
				//获取子节点的ID
				String sonId = elementSon.getAttributeValue("name");
				
				//获取子节点的bean
				String sonClass = elementSon.getAttributeValue("bean");
				
				//取得被注入的实例
				Object sonBean = bean.get(sonClass);
				
				//获得相应属性的set方法的方法名
				String methodName = "set" + sonId.substring(0, i).toUpperCase()+sonId.substring(1);
				System.out.println(methodName);
				
				//使用反射取得指定名称，指定参数类型的setMXXX方法
				Method m =  o.getClass().getMethod(methodName, sonBean.getClass().getInterfaces()[0]);
				
				//调用对象的setXXX方法
				m.invoke(o, sonBean);
			}
		}
		
	}
	@Override
	public Object getBean(String id) {
		// TODO Auto-generated method stub
		return bean.get(id);
	}

}
