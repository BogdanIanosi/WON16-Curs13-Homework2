package com.person;

public class Person {
    private Integer id;
    private String name;
    private int age;

    public Person(String name, int age) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (age <= 0 || age >= 120) {
            throw new IllegalArgumentException("Age must be between 1 and 119");
        }
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

