package com.cndevxm;

import com.cndevxm.entity.Member;
import com.cndevxm.service.MemberService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 基于XML配置的application
 */
public class XMLDataAccessClient {

	public static void main(String[] args) {

		// 基于类路径的xml文件配置
		AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:application-dataaccess.xml");

		MemberService memberService = (MemberService) applicationContext.getBean("memberService");

		Member member = new Member();
		member.setName("张三");
		member.setAge(18);
		member.setIdCard("4111111");
		memberService.insMember(member);

		applicationContext.registerShutdownHook();
	}
}