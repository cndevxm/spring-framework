package com.cndevxm.event;

import org.springframework.context.ApplicationListener;

public class MyApplicationListener implements ApplicationListener<MyApplicationEvent> {

	/**
	 * 类型安全
	 *
	 * @param event the event to respond to
	 */
	@Override
	public void onApplicationEvent(MyApplicationEvent event) {
		System.out.println("监听事件");
	}

}
