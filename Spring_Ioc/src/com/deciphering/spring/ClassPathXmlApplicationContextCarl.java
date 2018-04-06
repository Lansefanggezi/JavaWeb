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
		
		//�����ĵ�����
		Document doc = saxBuilder.build(this.getClass().getClassLoader().getResourceAsStream("bean.xml"));
		
		//��ȡ���ڵ�
		Element root = doc.getRootElement();
		
		//��ȡ��������beanԪ��
		List list = root.getChildren();
		for(int i = 0; i< list.size(); i++)
		{
			//��õ�i��Ԫ��
			Element element = (Element)list.get(i);
			
			//ȡ�õ�i��Ԫ�ص�id����ֵ
			String id = element.getAttributeValue("id");
			
			//���Ԫ�ص�classֵ
			String classPath = element.getAttributeValue("class");
			
			//���ɴ˶���
			Object o = Class.forName(classPath).newInstance();
			
			System.out.println("��bean��id��" + id);
			System.out.println("��bean��classPath" + classPath);
			bean.put(id, o);
			
			//ʵ������ע��
			//����Bean�µ�����property�ڵ�
			for(Element elementSon : (List<Element>)element.getChildren("property"))
			{
				//��ȡ�ӽڵ��ID
				String sonId = elementSon.getAttributeValue("name");
				
				//��ȡ�ӽڵ��bean
				String sonClass = elementSon.getAttributeValue("bean");
				
				//ȡ�ñ�ע���ʵ��
				Object sonBean = bean.get(sonClass);
				
				//�����Ӧ���Ե�set�����ķ�����
				String methodName = "set" + sonId.substring(0, i).toUpperCase()+sonId.substring(1);
				System.out.println(methodName);
				
				//ʹ�÷���ȡ��ָ�����ƣ�ָ���������͵�setMXXX����
				Method m =  o.getClass().getMethod(methodName, sonBean.getClass().getInterfaces()[0]);
				
				//���ö����setXXX����
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