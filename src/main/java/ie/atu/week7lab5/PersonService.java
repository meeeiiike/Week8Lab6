package ie.atu.week7lab5;

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

    public Person update(String employeeId, Person person) {
        Person toUpdate = personRepository.findByEmployeeId(employeeId).orElseThrow(() -> new IllegalArgumentException("Person with id " + employeeId + " not found"));
        toUpdate.setName(person.getName());
        toUpdate.setEmail(person.getEmail());
        toUpdate.setPosition(person.getPosition());
        toUpdate.setDepartment(person.getDepartment());
        return personRepository.save(toUpdate);
    }

    public void delete(String employeeId) {
        Person toDelete = personRepository.findByEmployeeId(employeeId).orElseThrow(() -> new IllegalArgumentException("Person with id " + employeeId + " not found"));
        personRepository.delete(toDelete);
    }
}