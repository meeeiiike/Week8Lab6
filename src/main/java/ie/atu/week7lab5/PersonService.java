package ie.atu.week7lab5;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person create(Person person) {
        return personRepository.save(person);
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findByEmployeeId(String id) {
        return personRepository.findByEmployeeId(id).orElseThrow(() -> new IllegalArgumentException("Person with id " + id + " not found"));
    }

}
