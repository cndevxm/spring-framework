package com.cndevxm;

import com.cndevxm.entity.Bus;
import com.cndevxm.entity.Department;
import com.cndevxm.event.BusEvent;
import com.cndevxm.event.BusPublisher;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Date;
import java.util.Locale;

/**
 * 基于XML配置的application
 */
public class XMLClient {

	public static void main(String[] args) {

		// 基于类路径的xml文件配置
//		AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:application.xml");
		// 基于文件系统的xml文件配置
		AbstractApplicationContext applicationContext = new FileSystemXmlApplicationContext("/spring-client-xml/out/production/resources/application.xml");
//		AbstractApplicationContext applicationContext = new FileSystemXmlApplicationContext();
//		Resource[] resource = applicationContext.getResources("file:///E:\\gitRepository\\spring-framework\\spring-client\\src\\main\\resources\\application.xml");
//		applicationContext.refresh();

		// profile
		applicationContext.getEnvironment().setActiveProfiles("prod");
		applicationContext.refresh();

		// 通过容器获取bean
		System.out.println(applicationContext.getBean("gc").toString());
		System.out.println(applicationContext.getBean("yf").toString());
		System.out.println(applicationContext.getBean("testHouse").toString());

		System.out.println(applicationContext.getBean("amg").toString());
		System.out.println(applicationContext.getBean("v").toString());
		System.out.println(applicationContext.getBean("bmw3").toString());
		System.out.println(applicationContext.getBean("bmw5").toString());
		System.out.println(applicationContext.getBean("bmw7").toString());

		System.out.println(applicationContext.getBean("chineseTeacher").toString());
		System.out.println(applicationContext.getBean("englishTeacher").toString());
		System.out.println(applicationContext.getBean("peTeacher").toString());
		System.out.println(applicationContext.getBean("mathTeacher").toString());
		System.out.println(applicationContext.getBean("王老师").toString());

		System.out.println(applicationContext.getBean("研发部").toString());
		System.out.println(applicationContext.getBean("测试部").toString());
		System.out.println(applicationContext.getBean("产品部").toString());

		// lockup
		Bus bus1 = ((Department) applicationContext.getBean("河南分公司")).createBus();
		Bus bus2 = ((Department) applicationContext.getBean("河南分公司")).createBus();
		System.out.println(bus1 == bus2);

		// replacer
		Bus bus3 = ((Department) applicationContext.getBean("河北分公司")).createBus();
		Bus bus4 = ((Department) applicationContext.getBean("河北分公司")).createBus();
		System.out.println(bus3 == bus4);

		// profile
		System.out.println(applicationContext.getBean("company").toString());

		// MessageSource
		System.out.println(applicationContext.getMessage("w", null, Locale.US));
		System.out.println(applicationContext.getMessage("w", null, Locale.SIMPLIFIED_CHINESE));
		System.out.println(applicationContext.getMessage("w", null, Locale.getDefault()));
		System.out.println(applicationContext.getMessage("w", null, null));
		System.out.println(applicationContext.getMessage("ss", new Object[]{"张三", "坑"}, null));

		// event and listener
		BusPublisher busPublisher = (BusPublisher) applicationContext.getBean("busPublisher");
		BusEvent busEvent = new BusEvent();
		busEvent.setBusName("182");
		busEvent.setEventType("出发");
		busEvent.setDate(new Date());
		busPublisher.publish(busEvent);
		busEvent.setBusName("B28");
		busPublisher.publish(busEvent);


		applicationContext.registerShutdownHook();

	}
}