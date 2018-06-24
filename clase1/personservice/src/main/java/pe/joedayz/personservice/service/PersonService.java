package pe.joedayz.personservice.service;


import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pe.joedayz.personservice.dao.PersonRepository;
import pe.joedayz.personservice.domain.Person;

@Service
public class PersonService {

    private static final Logger log = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private CounterService counterService;

    public PersonService() {
    }

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public Person getPerson(long id) {
        return personRepository.findOne(id);
    }

    public void updatePerson(Person person) {
        personRepository.save(person);
    }

    public void deletePerson(Long id) {
        personRepository.delete(id);
    }

    public Page<Person> getAllPersons(Integer page, Integer size){
        Page pageOfPersons = personRepository.findAll(new PageRequest(page, size));
        if(size> 50){
            counterService.increment("pe.joedayz.personservice.getAll.largePayload");
        }
        return pageOfPersons;
    }
}
