package com.cndevxm;

import com.cndevxm.entity.Dog;
import com.cndevxm.propertyEditors.DogEditor;
import com.cndevxm.propertyEditors.MyEditorRegistrar;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.HashMap;

/**
 * 基于注解的配置
 */
@Configuration
// 使用@Import注解完成其他配置类的注入
@Import(BeanConfig.class)
@EnableAsync
public class AppConfig {

	// 配置自定义propertyEditor
	@Bean("myCustomEditorConfigurer")
	public CustomEditorConfigurer createCustomEditorConfigurer() {
		CustomEditorConfigurer customEditorConfigurer = new CustomEditorConfigurer();
		customEditorConfigurer.setCustomEditors(new HashMap() {{
			put(Dog.class, DogEditor.class);
		}});
		customEditorConfigurer.setPropertyEditorRegistrars(new MyEditorRegistrar[]{new MyEditorRegistrar()});
		return customEditorConfigurer;
	}

}
