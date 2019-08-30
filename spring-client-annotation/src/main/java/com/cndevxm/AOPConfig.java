package com.cndevxm;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
// 添加AspectJ的支持
@EnableAspectJAutoProxy
@ComponentScan({"com.cndevxm.service", "com.cndevxm.aop"})
public class AOPConfig {

}
