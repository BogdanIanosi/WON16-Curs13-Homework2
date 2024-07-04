package com.person;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PersonService {
    private List<Person> persons = new ArrayList<>();
    private AtomicInteger idGenerator = new AtomicInteger(1);

    public Person addPerson(Person person) {
        person.setId(idGenerator.getAndIncrement());
        persons.add(person);
        return person;
    }

    public Person removePerson(int id) {
        Person personToRemove = persons.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Person with ID " + id + " does not exist"));
        persons.remove(personToRemove);
        return personToRemove;
    }

    public List<Person> getAllPersons() {
        return new ArrayList<>(persons);
    }

    public List<Person> getPersonsOlderThan(int age) {
        if (age <= 0 || age >= 120) {
            throw new IllegalArgumentException("Age must be between 1 and 119");
        }
        List<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (person.getAge() > age) {
                result.add(person);
            }
        }
        return result;
    }

    public List<String> getAllPersonNames() {
        List<String> names = new ArrayList<>();
        for (Person person : persons) {
            names.add(person.getName());
        }
        return names;
    }

    public Person getPerson(String name) {
        return persons.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Person with name " + name + " does not exist"));
    }

    public Person getPersonById(int id) {
        return persons.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Person with ID " + id + " does not exist"));
    }
}
