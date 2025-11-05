package ie.atu.week7lab5;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService personService;
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person create(@RequestBody Person person) {
        return personService.create(person);
    }

    @GetMapping
    public List<Person> findAll() {
        return personService.findAll();
    }

    @GetMapping("/{employeeId}")
    public Person findByEmployeeId(@PathVariable String employeeId) {
        return personService.findByEmployeeId(employeeId);
    }

    /*
    @PutMapping("/{employeeId}")
    public Person update(@PathVariable String employeeId, @RequestBody Person person) {
        return personService.update(person);
    }
     */
}
