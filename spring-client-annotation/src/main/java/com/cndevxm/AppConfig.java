package com.cndevxm;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 基于注解的配置
 */
@Configuration
// 使用@Import注解完成其他配置类的注入
@Import(BeanConfig.class)
public class AppConfig {

}
