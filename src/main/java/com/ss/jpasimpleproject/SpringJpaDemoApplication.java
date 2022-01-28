package com.ss.jpasimpleproject;


import com.ss.jpasimpleproject.entity.Person;
import com.ss.jpasimpleproject.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;


@SpringBootApplication
public class SpringJpaDemoApplication implements CommandLineRunner {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonJpaRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("All users -> {}",
                repository.findAll()
        );

        logger.info("User with Id 10001 -> {}",
                repository.findById(10001)
        );

        repository.deleteById(10003);

        logger.info("Inserting User -> Number of rows inserted {}",
                repository.insert(new Person("Stamat", "Vratsa", new Date()))
        );
        logger.info("updating User with Id 10002 -> Number of rows updated {}",
                repository.update(new Person(10002, "Petar", "Vratsa", new Date()))
        );
    }
}
