package com.cndevxm.event;

import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;

import java.text.SimpleDateFormat;
import java.util.Date;

@Order(1)
public class BusListener2 implements ApplicationListener<BusEvent> {

	/**
	 * 类型安全
	 *
	 * @param event the event to respond to
	 */
	@Override
	@Async
	public void onApplicationEvent(BusEvent event) {
		System.out.println("王五开始收听公交消息...");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String busName = event.getBusName();
		String eventType = event.getEventType();
		Date date = event.getDate();
		String dateStr = new SimpleDateFormat("HH:mm:ss").format(date);
		System.out.println("王五收到公交消息：" + busName + "于" + dateStr + eventType);
	}

}
