package com.example.ScheduledSpringBootDemo.repository;

import com.example.ScheduledSpringBootDemo.model.Person;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * The repository of the person database - methods for interacting with the database;
 * Two methods available: POST new person, PUT update processed false -> true at a @Scheduled interval;
 * Using a Logger object to provide information throughout the different database manipulation steps;
 * Getting the database connection values from application.properties, by @Value;
 */

@Repository
public class PersonRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonRepository.class);

    @Value("${db.url}")
    private String DB_URL;

    @Value("${db.user}")
    private String DB_USER;

    @Value("${db.pass}")
    private String DB_PASS;

    public void insertPerson(Person person) throws Exception {

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            LOGGER.info("Connected to MySQL database;");

            PreparedStatement statement = connection.prepareStatement("INSERT INTO person VALUES(?, ?, ?)");
            LOGGER.info("Prepared statement;");

            statement.setInt(1, person.getId());
            statement.setString(2, person.getName());
            statement.setBoolean(3, person.isProcessed());

            statement.execute();
            System.out.println(person);
            LOGGER.info("Entry added successfully;");
        } catch (SQLException e) {

            LOGGER.error("Connection failure", e);
            throw new Exception(e.getMessage());
        }
    }

    public void updateUnprocessedPersons() throws Exception {

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            LOGGER.info("Connected to MySQL database;");

            PreparedStatement statement = connection.prepareStatement("UPDATE person SET processed = true WHERE processed = false");
            LOGGER.info("Prepared statement;");

            statement.execute();
            LOGGER.info("Updated unprocessed entries to true.");
        } catch (SQLException e) {

            LOGGER.error("Connection failure", e);
            throw new Exception(e.getMessage());
        }
    }
}