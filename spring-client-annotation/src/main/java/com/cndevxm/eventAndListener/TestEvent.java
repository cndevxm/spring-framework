package com.cndevxm.eventAndListener;

import org.springframework.context.ApplicationEvent;

public class TestEvent extends ApplicationEvent {

	private String eventName;

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	/**
	 * Create a new ApplicationEvent.
	 *
	 * @param source the object on which the event initially occurred (never {@code null})
	 */
	public TestEvent(Object source) {
		super(source);
	}
}
