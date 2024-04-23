package com.example.ScheduledSpringBootDemo.model;

/**
 * Our Person POJO;
 * Encapsulated - using getter methods;
 */

public class Person {

    private int id;

    private String name;

    private boolean processed;

    public Person() {

    }

    public int getId() {

        return id;
    }

    public String getName() {

        return name;
    }

    public boolean isProcessed() {

        return processed;
    }
}
