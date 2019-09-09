package com.cndevxm.eventAndListener;

import org.springframework.context.ApplicationEvent;

import java.util.Date;

public class BusEvent extends ApplicationEvent {

	private String busName;

	private String eventType;

	private Date date;

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BusEvent() {
		super(new Object());
	}

	/**
	 * Create a new ApplicationEvent.
	 *
	 * @param source the object on which the event initially occurred (never {@code null})
	 */
	public BusEvent(Object source) {
		super(source);
	}
}
