package pe.joedayz.personservice.service;

import org.springframework.context.ApplicationEvent;
import pe.joedayz.personservice.domain.Person;

public class PersonServiceEvent extends ApplicationEvent {

    Person eventPerson;
    String eventType;
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public PersonServiceEvent(Object source, String eventType, Person person) {
        super(source);
        this.eventType = eventType;
        this.eventPerson = person;
    }

    public String toString() {
        return "My PersonService Event";
    }

    public Person getEventPerson() {
        return eventPerson;
    }

    public void setEventPerson(Person eventPerson) {
        this.eventPerson = eventPerson;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

}
