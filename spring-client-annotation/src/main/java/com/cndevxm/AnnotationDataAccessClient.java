package com.cndevxm;

import com.cndevxm.entity.Member;
import com.cndevxm.service.MemberService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * 基于注解启动的application
 */
public class AnnotationDataAccessClient {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DataAccessConfig.class);
		MemberService memberService = (MemberService) applicationContext.getBean("memberService");

		Member member = new Member();
		member.setName("张三");
		member.setAge(19);
		member.setIdCard("20000");
		try {
			memberService.insertMember(member);
		} catch (Exception e) {

		}

		List<Member> members = memberService.selectMember(new Member());
		members.forEach(m -> System.out.println(m.toString()));
		applicationContext.registerShutdownHook();

	}
}
