package com.person;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class PersonServiceTest {
    private PersonService personService;

    @BeforeEach
    public void setUp() {
        personService = new PersonService();
    }

    @Test
    public void testAddPerson() {
        Person person = new Person("Jane Doe", 25);
        Person addedPerson = personService.addPerson(person);
        assertNotNull(addedPerson.getId());
    }

    @Test
    public void testRemovePerson() {
        Person person = new Person("Jane Doe", 25);
        Person addedPerson = personService.addPerson(person);
        Person removedPerson = personService.removePerson(addedPerson.getId());
        assertEquals(addedPerson, removedPerson);
        assertThrows(IllegalArgumentException.class, () -> personService.removePerson(addedPerson.getId()));
    }

    @Test
    public void testGetAllPersons() {
        personService.addPerson(new Person("John Doe", 30));
        personService.addPerson(new Person("Jane Doe", 25));
        List<Person> allPersons = personService.getAllPersons();
        assertEquals(2, allPersons.size());
    }

    @Test
    public void testGetPersonsOlderThan() {
        personService.addPerson(new Person("John Doe", 30));
        personService.addPerson(new Person("Jane Doe", 25));
        List<Person> personsOlderThan = personService.getPersonsOlderThan(26);
        assertEquals(1, personsOlderThan.size());
        assertEquals("John Doe", personsOlderThan.getFirst().getName());
    }

    @Test
    public void testGetAllPersonNames() {
        personService.addPerson(new Person("John Doe", 30));
        personService.addPerson(new Person("Jane Doe", 25));
        List<String> names = personService.getAllPersonNames();
        assertEquals(2, names.size());
        assertTrue(names.contains("John Doe"));
        assertTrue(names.contains("Jane Doe"));
    }

    @Test
    public void testGetPersonByName() {
        personService.addPerson(new Person("John Doe", 30));
        Person person = personService.getPerson("John Doe");
        assertEquals("John Doe", person.getName());
        assertEquals(30, person.getAge());
    }

    @Test
    public void testGetPersonById() {
        Person addedPerson = personService.addPerson(new Person("Jane Doe", 25));
        Person person = personService.getPersonById(addedPerson.getId());
        assertEquals("Jane Doe", person.getName());
        assertEquals(25, person.getAge());
    }
}

