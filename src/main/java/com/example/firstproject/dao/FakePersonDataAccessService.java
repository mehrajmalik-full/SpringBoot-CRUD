package com.example.firstproject.dao;

import com.example.firstproject.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements  PersonDao{
    private static List<Person> DB = new ArrayList<>();
    @Override
    public String insertPerson(Person person) {
        DB.add(new Person(person.getId(), person.getName()));
        return person.getId();
    }

    @Override
    public List<Person> selectAllPerson() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(String id) {
        return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
    }

    @Override
    public int deletePersonById(String id) {
        Optional<Person> personToDelete = selectPersonById(id);
        if(personToDelete.isEmpty())
            return 0;

        DB.remove(personToDelete.get());
        return 1;
    }
}
