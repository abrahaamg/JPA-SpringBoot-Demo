package com.example.demo.service;

import com.example.demo.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository repo;

    public PersonService(PersonRepository repo){
        this.repo = repo;
    }

    public List<Person> findAll(){
        return repo.findAll();
    }

    public Person create(Person person){
        return repo.save(person);
    }

    public Person getPersonById(Long id){
        return repo.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Ese id no existe"
                        )
                );
    }

    public Person updatePersonById(Long id, Person nuevaPersona){
        Person existente = repo.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));

        existente.setNombre(nuevaPersona.getNombre());
        existente.setEdad(nuevaPersona.getEdad());

        return repo.save(existente);
    }

    public void deletePerson(Long id){
        repo.deleteById(id);
    }
}
