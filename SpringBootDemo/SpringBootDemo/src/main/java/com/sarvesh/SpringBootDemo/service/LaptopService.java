package com.sarvesh.SpringBootDemo.service;

import com.sarvesh.SpringBootDemo.Repository.LaptopRepository;
import com.sarvesh.SpringBootDemo.model.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {

    @Autowired //Field Injection
    private LaptopRepository repository;

    //Does some processing
    public void addLaptop(Laptop laptop) {
        System.out.println("Service Method called...");
        repository.save(laptop);
    }

    //Now I want to store this "laptop" object's data into database with the help og JDBC
    //But don't write any JDBC steps in this class.
    //We have a separate class for it called as Repository class.

}
