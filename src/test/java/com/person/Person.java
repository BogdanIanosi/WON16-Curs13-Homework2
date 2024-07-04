package com.person;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonTest {

    @Test
    public void testValidPersonCreation() {
        Person person = new Person("John Doe", 30);
        assertNotNull(person);
        assertEquals("John Doe", person.getName());
        assertEquals(30, person.getAge());
    }

    @Test
    public void testInvalidPersonCreation() {
        assertThrows(IllegalArgumentException.class, () -> new Person(null, 30));
        assertThrows(IllegalArgumentException.class, () -> new Person("", 30));
        assertThrows(IllegalArgumentException.class, () -> new Person("John Doe", -1));
        assertThrows(IllegalArgumentException.class, () -> new Person("John Doe", 120));
    }
}

