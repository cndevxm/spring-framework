package com.cndevxm;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@ComponentScan(basePackages = {"com.cndevxm"})
@PropertySource(value = "classpath:jdbc.properties")
public class BeanConfig {

	@Bean("messageSource")
	public MessageSource getmessageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setDefaultEncoding("gbk");
		messageSource.setFallbackToSystemLocale(true);
		messageSource.setBasenames("classpath:i18n");
		return messageSource;
	}

	@Bean("myExecutor")
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(5);
		executor.setMaxPoolSize(10);
		executor.setQueueCapacity(25);
		executor.setThreadNamePrefix("myExecutor_");
		executor.initialize();
		return executor;
	}
}
