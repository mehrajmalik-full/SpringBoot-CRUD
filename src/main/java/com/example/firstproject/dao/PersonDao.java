package com.example.firstproject.dao;

import com.example.firstproject.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {
    String insertPerson(Person person);

    List<Person> selectAllPerson();


    Optional<Person> selectPersonById(String id);
    int deletePersonById(String id);
}
