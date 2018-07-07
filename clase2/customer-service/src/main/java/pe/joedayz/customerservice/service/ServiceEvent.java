package pe.joedayz.customerservice.service;

import org.springframework.context.ApplicationEvent;
import pe.joedayz.customerservice.domain.Customer;


/**
 * This is an optional class used in publishing application events. This can be
 * used to inject events into the Spring Boot audit management endpoint.
 */
public class ServiceEvent extends ApplicationEvent {
	
	Customer eventCustomer;
	String eventType;
	
	public ServiceEvent(Object source) {
		super(source);
	}

	public String toString() {
		return "My CustomerService Event";
	}

	public Customer getEventCustomer() {
		return eventCustomer;
	}

	public void setEventCustomer(Customer eventCustomer) {
		this.eventCustomer = eventCustomer;
	}
	
	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public ServiceEvent(Object source, Customer eventCustomer, String eventType) {
		super(source);
		this.eventCustomer = eventCustomer;
		this.eventType = eventType;
	}
	
	
}
