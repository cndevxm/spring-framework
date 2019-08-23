package com.cndevxm.event;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.*;

@Configuration
public class ApplicationEventListenerConfig {

	@EventListener({ContextRefreshedEvent.class})
	public void contextRefreshedEventListener() {
		System.out.println("监听容器refreshed事件...");
	}

	@EventListener({ContextClosedEvent.class})
	public void contextClosedEventListener() {
		System.out.println("监听容器closed事件...");
	}

	@EventListener({ContextStartedEvent.class})
	public void contextStartedEventListener() {
		System.out.println("监听容器started事件...");
	}

	@EventListener({ContextStoppedEvent.class})
	public void contextStoppedEventListener() {
		System.out.println("监听容器stopped事件...");
	}
}
