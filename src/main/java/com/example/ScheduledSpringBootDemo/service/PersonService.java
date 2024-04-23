package com.example.ScheduledSpringBootDemo.service;

import com.example.ScheduledSpringBootDemo.model.Person;
import com.example.ScheduledSpringBootDemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Our Service class for person database;
 */

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {

        this.personRepository = personRepository;
    }

    public void insertPerson(Person person) throws Exception {

        validateInsertPersonInput(person);

        personRepository.insertPerson(person);
    }

    public void updateUnprocessedEntries() throws Exception {

        personRepository.updateUnprocessedPersons();
    }

    private static void validateInsertPersonInput(Person person) throws Exception {

        try {

            if (!person.getName().matches("[a-zA-Z\\s]+")) {

                throw new Exception("Invalid Input for Name - Please insert letters only!");
            }

            if (!(person.isProcessed() == true || person.isProcessed()==false)) {

                throw new Exception(
                        "Invalid Input for Processed - Please insert a true/false value!");
            }
        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }
}