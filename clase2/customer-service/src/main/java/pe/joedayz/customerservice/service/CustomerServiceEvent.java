package pe.joedayz.customerservice.service;

import org.springframework.context.ApplicationEvent;

/**
 * This is an optional class used in publishing application events.
 * This can be used to inject events into the Spring Boot audit management endpoint.
 */
public class CustomerServiceEvent extends ApplicationEvent {

    public CustomerServiceEvent(Object source) {
        super(source);
    }

    public String toString() {
        return "My CustomerService Event";
    }
}