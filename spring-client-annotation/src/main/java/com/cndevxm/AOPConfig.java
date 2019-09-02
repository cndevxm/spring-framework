package com.cndevxm;

import com.cndevxm.service.AuthService;
import com.cndevxm.service.impl.AuthServiceImpl;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
// 添加AspectJ的支持
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan({"com.cndevxm.service", "com.cndevxm.aop"})
public class AOPConfig {

	// 基于ProxyFactoryBean生成代理对象
	@Bean("proxyAuthService")
	public ProxyFactoryBean createProxyFactoryBean() throws ClassNotFoundException {
		ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
		proxyFactoryBean.setProxyTargetClass(true);
		proxyFactoryBean.setProxyInterfaces(new Class[]{AuthService.class});
		proxyFactoryBean.setTarget(new AuthServiceImpl());
		proxyFactoryBean.setInterceptorNames(new String[]{"authServiceBeforAdvice", "authServiceInterceptor"});
		return proxyFactoryBean;
	}

	@Bean("autoProxyAuthService")
	public AuthService myAuthService() {
		return new AuthServiceImpl();
	}

	// 基于自动代理创建
	@Bean
	public BeanNameAutoProxyCreator MyBeanNameAutoProxyCreator() {
		BeanNameAutoProxyCreator beanNameAutoProxyCreator = new BeanNameAutoProxyCreator();
		beanNameAutoProxyCreator.setBeanNames("autoProxyAuthService");
		beanNameAutoProxyCreator.setInterceptorNames(new String[]{"authServiceBeforAdvice", "authServiceInterceptor"});
		return beanNameAutoProxyCreator;
	}

}
