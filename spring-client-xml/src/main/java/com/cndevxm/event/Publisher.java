package com.cndevxm.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class Publisher implements ApplicationEventPublisherAware {

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
	public void publish(BusEvent applicationEvent) {
		applicationEventPublisher.publishEvent(applicationEvent);
	}
}
