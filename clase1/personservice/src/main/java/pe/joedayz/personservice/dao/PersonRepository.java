package pe.joedayz.personservice.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import pe.joedayz.personservice.domain.Person;


import java.util.List;

public interface PersonRepository
    extends PagingAndSortingRepository<Person, Long> {


    Person findPersonByAge(int age);  //finders

    List<Person> findPersonByLastName(String lastName);

    Page findAll(Pageable pageable);
}
