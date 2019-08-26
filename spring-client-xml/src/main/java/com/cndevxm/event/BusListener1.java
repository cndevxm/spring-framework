package com.cndevxm.event;

import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;

import java.text.SimpleDateFormat;
import java.util.Date;

@Order(2)
public class BusListener1 implements ApplicationListener<BusEvent> {

	/**
	 * 类型安全
	 *
	 * @param event the event to respond to
	 */
	@Override
	@Async
	public void onApplicationEvent(BusEvent event) {
		String busName = event.getBusName();
		String eventType = event.getEventType();
		Date date = event.getDate();
		String dateStr = new SimpleDateFormat("HH:mm:ss").format(date);
		System.out.println("李四收到公交消息：" + busName + "于" + dateStr + eventType);
	}

}
