package com.kesselrun.springdatarest.payroll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// This class is marked with Spring’s @Component annotation
// so that it is automatically picked up by @SpringBootApplication.
@Component
//It implements Spring Boot’s CommandLineRunner so that it gets run after all the beans are created and registered.
public class DatabaseLoader implements CommandLineRunner {

    private final EmployeeRepository repository;

    @Autowired
    //It uses constructor injection and autowiring to get Spring Data’s automatically created EmployeeRepository.
    public DatabaseLoader(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    //The run() method is invoked with command line arguments, loading up your data.
    public void run(String... strings) throws Exception {
        this.repository.save(new Employee("Frodo", "Baggins", "ring bearer"));
    }
}