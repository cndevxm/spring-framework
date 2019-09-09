package com.cndevxm.eventAndListener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;

public class ApplicationEventListener {

	static class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {

		@Override
		public void onApplicationEvent(ContextRefreshedEvent event) {
			System.out.println("监听容器refreshed事件...");
		}
	}

	static class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {

		@Override
		public void onApplicationEvent(ContextClosedEvent event) {
			System.out.println("监听容器closed事件...");
		}
	}

	static class ContextStartedEventListener implements ApplicationListener<ContextStartedEvent> {

		@Override
		public void onApplicationEvent(ContextStartedEvent event) {
			System.out.println("监听容器started事件...");
		}
	}

	static class ContextStoppedEventListener implements ApplicationListener<ContextStoppedEvent> {

		@Override
		public void onApplicationEvent(ContextStoppedEvent event) {
			System.out.println("监听容器stopped事件...");
		}
	}
}
