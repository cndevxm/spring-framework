package com.cndevxm.entity.factory;

import com.cndevxm.entity.Bus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class BusFactory {

	//	@Bean(value = "182", initMethod = "init", destroyMethod = "des")
	@Bean("182")
	@Scope("prototype")
	public Bus create182() {
		System.out.println("创建182...");
		return new Bus("182");
	}

	@Bean("B28")
	@Scope("prototype")
	public Bus createB28() {
		System.out.println("创建B28...");
		return new Bus("B28");
	}

}
