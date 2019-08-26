package com.cndevxm.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class TestEventListener {

	@EventListener
	public void testEventListener1(TestEvent testEvent) {
		System.out.println("testEventListener1监听到发生了" + testEvent.getEventName() + "事件");
	}

	@EventListener
	public void testEventListener2(TestEvent testEvent) {
		System.out.println("testEventListener2监听到发生了" + testEvent.getEventName() + "事件");
	}
}
