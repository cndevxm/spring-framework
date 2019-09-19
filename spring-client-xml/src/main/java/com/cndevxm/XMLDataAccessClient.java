package com.cndevxm;

import com.cndevxm.entity.Org;
import com.cndevxm.service.OrgService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 基于XML配置的application
 */
public class XMLDataAccessClient {

	public static void main(String[] args) throws Exception {

		// 基于类路径的xml文件配置
		AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:application-jdbc.xml");

		// 声明式事务
//		MemberService memberService = (MemberService) applicationContext.getBean("memberService");
//
//		Member member = new Member();
//		member.setName("张三");
//		member.setAge(18);
//		member.setIdCard("4111111");
//		memberService.insMember(member);

		// 编程式事务
		OrgService orgService = (OrgService) applicationContext.getBean("orgService");
		Org org = new Org();
		org.setOrgId("20190909001");
		org.setOrgName("20190909001");
		org.setId("680a855d-d248-11e9-b369-5254003b83d8");
		orgService.updateOrg(org);

		List<Org> orgs = orgService.selectOrg(new Org());
		orgs.forEach(o -> System.out.println(o));

		applicationContext.registerShutdownHook();
	}
}