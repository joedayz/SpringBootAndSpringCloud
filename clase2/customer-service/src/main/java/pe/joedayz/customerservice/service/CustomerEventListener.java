package pe.joedayz.customerservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CustomerEventListener implements ApplicationListener<ServiceEvent> {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public void onApplicationEvent(ServiceEvent event) {
		ServiceEvent customeEvent = (ServiceEvent) event;
		logger.info("Person " + event.getEventType() + " with details : " + event.getEventCustomer());
	}
}
