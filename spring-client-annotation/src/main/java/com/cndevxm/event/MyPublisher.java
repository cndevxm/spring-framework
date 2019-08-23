package com.cndevxm.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class MyPublisher implements ApplicationEventPublisherAware {

	private ApplicationEventPublisher applicationEventPublisher;

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}

	/**
	 * 监听器将监听事件
	 *
	 * @param applicationEvent
	 */
	public void publish(MyApplicationEvent applicationEvent) {
		applicationEventPublisher.publishEvent(applicationEvent);
	}
}
