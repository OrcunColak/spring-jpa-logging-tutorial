package com.colak.springtutorial;

import com.colak.springtutorial.jpa.Person;
import com.colak.springtutorial.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SpringTutorialApplication implements CommandLineRunner {

    private PersonService personService;

    public static void main(String[] args) {
        SpringApplication.run(SpringTutorialApplication.class, args);
    }

    // Logs are
    // Name:dataSource, Connection:4, Time:0, Success:True
    // Type:Prepared, Batch:False, QuerySize:1, BatchSize:0
    // Query:["select p1_0.id,p1_0.name from person p1_0 where p1_0.id=?"]
    // Params:[(1)]

    // Name:dataSource, Connection:4, Time:1, Success:True
    // Type:Prepared, Batch:False, QuerySize:1, BatchSize:0
    // Query:["insert into person (name,id) values (?,?)"]
    // Params:[(person-name,1)]
    @Override
    public void run(String... args) {
        Person person = new Person(1L, "person-name");

        Person savedPerson = personService.save(person);
        log.info("savedPerson : {}", savedPerson);
    }

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
}
