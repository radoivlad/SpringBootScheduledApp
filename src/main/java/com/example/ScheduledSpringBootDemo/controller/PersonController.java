package com.example.ScheduledSpringBootDemo.controller;

import com.example.ScheduledSpringBootDemo.model.Person;
import com.example.ScheduledSpringBootDemo.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

/**
 * Our Controller for the person database, containing the handler methods for inserting a person and updating unprocessed entries;
 * Using @Scheduled for the Put method, with an initial delay of 10 seconds and fixed rate of 10 seconds;
 * That way, every 10 seconds, entries with "false" unprocessed values have them updated to "true";
 */

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {

        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<String> insertPerson(@RequestBody Person person) {

        try {
            personService.insertPerson(person);
            return ResponseEntity.status(HttpStatus.OK).body("Person inserted successfully.");
        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to insert person: " + e.getMessage());
        }
    }

    @Scheduled(fixedRate = 10000, initialDelay = 10000)
    public ResponseEntity<String> updateUnprocessedEntries() {

        try {
            personService.updateUnprocessedEntries();
            return ResponseEntity.status(HttpStatus.OK).body("Unprocessed entries updated successfully.");
        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to update unprocessed persons: " + e.getMessage());
        }
    }
}