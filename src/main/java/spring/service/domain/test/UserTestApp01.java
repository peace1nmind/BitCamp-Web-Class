package spring.service.domain.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import spring.service.domain.User;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTestApp01 {

	public static void main(String[] args) {
		
		// getBean 할 때 생성
//		BeanFactory factory = 
//				new XmlBeanFactory(
//						new FileSystemResource("./src/main/resources/config/userservice01.xml"));
		
		// 생성과 동시에 pre-loading
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("/config/userservice01.xml");
		
		System.out.println("\n==============================");
		User user01 = (User) factory.getBean("user01");
		System.out.println(user01);
		
		System.out.println("\n==============================");
		User user02 = (User) factory.getBean("user02");
		System.out.println(user02);
		
		System.out.println("\n==============================");
		User user03 = (User) factory.getBean("user03");
		System.out.println(user03);
		
		System.out.println("\n==============================");
		User user04 = (User) factory.getBean("user04");
		System.out.println(user04);
		
		System.out.println("\n==============================");
		User user05 = (User) factory.getBean("user05");
		System.out.println(user05);
		
	}

}
