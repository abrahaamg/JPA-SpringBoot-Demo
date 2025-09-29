package com.example.demo.controller;

import com.example.demo.Person;
import com.example.demo.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getALl(){
        return personService.findAll();
    }

    @PostMapping
    public Person create(@RequestBody Person person){
        return personService.create(person);
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Long id) {
        return personService.getPersonById(id);
    }

    @PutMapping("/{id}")
    public Person updatePersonById(@PathVariable Long id, @RequestBody Person nuevaPersona) {
        return personService.updatePersonById(id, nuevaPersona);
    }

    @DeleteMapping("/{id}")
    public void updatePersonById(@PathVariable Long id) {
        personService.deletePerson(id);
    }
}