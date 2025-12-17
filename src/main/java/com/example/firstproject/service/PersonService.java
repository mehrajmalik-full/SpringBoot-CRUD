package com.example.firstproject.service;

import com.example.firstproject.dao.PersonDao;
import com.example.firstproject.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public String addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPersons() {
        return personDao.selectAllPerson();
    }

    public Optional<Person> getPersonById(String id){
        return personDao.selectPersonById(id);
    }

    public int deletePerson(String id){
        return personDao.deletePersonById(id);
    }

}
