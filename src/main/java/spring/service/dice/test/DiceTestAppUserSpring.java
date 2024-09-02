package spring.service.dice.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import spring.service.dice.play.Player02;



/*
 * FileName : DiceTestAppUserSpring.java
 * �� Hello Bean ����ϴ� Application
 * �� Hello Bean ��  dependency Relation
 * �� Spring Framework ���� �����ϴ� API�� ��� instance ����
 * 		[[[ HelloTestApp02�� �� ]]]
 * 		- hello.properties  ==> hello.xml
 * 		- HelloFactory ==> org.springframework.beans.factory.BeanFactory     
 
	==>	Spring Framework �� �پ��� ��Ÿ������ ��  xml �� �Ϲ������� ����ϸ�,
	  		instance ����, �ʱ�ȭ, ��ü�� ��ȣ ���踦  xml �� ���������� ���. 
	  				
			<bean id="hello" class="spring.services.hello.Hello"/>
			
	==> 	HelloFactory :  Hello Data type �� ���� �ϴ� Factory 
	==> Spring Framework :��� Data Type(Bean/POJO) ���������ϴ� Factory
 */
public class DiceTestAppUserSpring {

	/// main method
	public static void main(String[] args) {
		
		//1. BeanFactory �� �̿� xml �� ���������� ����� instance ���� ȹ��
		BeanFactory factory =
				new XmlBeanFactory( 
						new FileSystemResource("./src/main/resources/config/diceservice.xml") );

		//2. Container �� ���� player �� name �� ���� instance return �ޱ�  
		Player02 player01 = (Player02) factory.getBean("player01");
		player01.playDice(3);
		System.out.println("=======================");
		System.out.println("���õ� �ֻ��� ���� ������ : "+player01.getTotalValue());
		System.out.println("=======================");
		
		Player02 player02 = (Player02) factory.getBean("player02");
		player02.playDice(3);
		System.out.println("=======================");
		System.out.println("���õ� �ֻ��� ���� ������ : "+player02.getTotalValue());
		System.out.println("=======================");
		
		
		//3. Constructor Injection
		Player02 player03 = (Player02) factory.getBean("player03");
		player03.playDice(3);
		System.out.println("=======================");
		System.out.println("���õ� �ֻ��� ���� ������ : "+player03.getTotalValue());
		System.out.println("=======================");
		
		Player02 player04 = (Player02) factory.getBean("player04");
		player04.playDice(3);
		System.out.println("=======================");
		System.out.println("���õ� �ֻ��� ���� ������ : "+player04.getTotalValue());
		System.out.println("=======================");
	}
	
}//end of class