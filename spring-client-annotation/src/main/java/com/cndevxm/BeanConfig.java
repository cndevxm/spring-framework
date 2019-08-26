package com.cndevxm;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@ComponentScan(basePackages = {"com.cndevxm"})
@PropertySource(value = "classpath:jdbc.properties")
@EnableAsync
public class BeanConfig {

	@Bean("messageSource")
	public MessageSource getmessageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setDefaultEncoding("gbk");
		messageSource.setFallbackToSystemLocale(true);
		messageSource.setBasenames("classpath:i18n");
		return messageSource;
	}


}
