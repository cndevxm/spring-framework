package com.cndevxm.event;

import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;

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
	public void onApplicationEvent(BusEvent event) {
		String busName = event.getBusName();
		String eventType = event.getEventType();
		Date date = event.getDate();
		String dateStr = new SimpleDateFormat("HH:mm:ss").format(date);
		System.out.println("王五收到公交消息：" + busName + "于" + dateStr + eventType);
	}

}
