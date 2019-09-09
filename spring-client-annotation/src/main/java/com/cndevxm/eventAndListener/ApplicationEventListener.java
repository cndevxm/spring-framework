package com.cndevxm.eventAndListener;

import org.springframework.context.event.*;
import org.springframework.stereotype.Component;

@Component
public class ApplicationEventListener {

	@EventListener(classes = ContextRefreshedEvent.class)
	public void contextRefreshedEventListener() {
		System.out.println("监听容器refreshed事件...");
	}

	@EventListener(classes = ContextClosedEvent.class)
	public void contextClosedEventListener() {
		System.out.println("监听容器closed事件...");
	}

	@EventListener(classes = ContextStartedEvent.class)
	public void contextStartedEventListener() {
		System.out.println("监听容器started事件...");
	}

	@EventListener(classes = ContextStoppedEvent.class)
	public void contextStoppedEventListener() {
		System.out.println("监听容器stopped事件...");
	}

}
