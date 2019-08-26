package com.cndevxm.event;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class BusEventListener {

	@EventListener
	@Async
	@Order(100)
	public void busEventListener1(BusEvent busEvent) {
		String busName = busEvent.getBusName();
		String eventType = busEvent.getEventType();
		Date date = busEvent.getDate();
		String dateStr = new SimpleDateFormat("HH:mm:ss").format(date);
		System.out.println("张三收到公交消息：" + busName + "于" + dateStr + eventType);
	}

	@EventListener
	@Async
	@Order(99)
	public TestEvent busEventListener2(BusEvent busEvent) {
		String busName = busEvent.getBusName();
		String eventType = busEvent.getEventType();
		Date date = busEvent.getDate();
		String dateStr = new SimpleDateFormat("HH:mm:ss").format(date);
		System.out.println("李四收到公交消息：" + busName + "于" + dateStr + eventType);
		TestEvent testEvent = new TestEvent(new Object());
		testEvent.setEventName("李四收到公交消息");
		return testEvent;
	}

	@EventListener
	@Async
	@Order(98)
	public void busEventListener3(BusEvent busEvent) {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String busName = busEvent.getBusName();
		String eventType = busEvent.getEventType();
		Date date = busEvent.getDate();
		String dateStr = new SimpleDateFormat("HH:mm:ss").format(date);
		System.out.println("王五收到公交消息：" + busName + "于" + dateStr + eventType);
	}

	@EventListener(condition = "#busEvent.busName == '182'")
	@Async
	@Order(97)
	public void busEventListenerFor182(BusEvent busEvent) {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String busName = busEvent.getBusName();
		String eventType = busEvent.getEventType();
		Date date = busEvent.getDate();
		String dateStr = new SimpleDateFormat("HH:mm:ss").format(date);
		System.out.println("张三三收到公交消息：" + busName + "于" + dateStr + eventType);
	}

	@EventListener(condition = "#busEvent.busName == 'B28'")
	@Async
	@Order(97)
	public void busEventListenerForB28(BusEvent busEvent) {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String busName = busEvent.getBusName();
		String eventType = busEvent.getEventType();
		Date date = busEvent.getDate();
		String dateStr = new SimpleDateFormat("HH:mm:ss").format(date);
		System.out.println("李四四收到公交消息：" + busName + "于" + dateStr + eventType);
	}


}
