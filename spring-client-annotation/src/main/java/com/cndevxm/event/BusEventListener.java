package com.cndevxm.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class BusEventListener {

	@EventListener
	public void busEventListener1(BusEvent busEvent) {
		String busName = busEvent.getBusName();
		String eventType = busEvent.getEventType();
		Date date = busEvent.getDate();
		String dateStr = new SimpleDateFormat("HH:mm:ss").format(date);
		System.out.println("张三收到公交消息：" + busName + "于" + dateStr + eventType);
	}

	@EventListener
	public void busEventListener2(BusEvent busEvent) {
		String busName = busEvent.getBusName();
		String eventType = busEvent.getEventType();
		Date date = busEvent.getDate();
		String dateStr = new SimpleDateFormat("HH:mm:ss").format(date);
		System.out.println("李四收到公交消息：" + busName + "于" + dateStr + eventType);
	}

	@EventListener
	public void busEventListener3(BusEvent busEvent) {
		String busName = busEvent.getBusName();
		String eventType = busEvent.getEventType();
		Date date = busEvent.getDate();
		String dateStr = new SimpleDateFormat("HH:mm:ss").format(date);
		System.out.println("王五收到公交消息：" + busName + "于" + dateStr + eventType);
	}

	@EventListener(condition = "#busEvent.busName == '182'")
	public void busEventListenerFor182(BusEvent busEvent) {
		String busName = busEvent.getBusName();
		String eventType = busEvent.getEventType();
		Date date = busEvent.getDate();
		String dateStr = new SimpleDateFormat("HH:mm:ss").format(date);
		System.out.println("张三三收到公交消息：" + busName + "于" + dateStr + eventType);
	}

	@EventListener(condition = "#busEvent.busName == 'B28'")
	public void busEventListenerForB28(BusEvent busEvent) {
		String busName = busEvent.getBusName();
		String eventType = busEvent.getEventType();
		Date date = busEvent.getDate();
		String dateStr = new SimpleDateFormat("HH:mm:ss").format(date);
		System.out.println("李四四收到公交消息：" + busName + "于" + dateStr + eventType);
	}


}
