package com.sarvesh.SpringBootDemo.Repository;

import com.sarvesh.SpringBootDemo.model.Laptop;
import org.springframework.stereotype.Repository;

@Repository
public class LaptopRepository {
    //Write all the steps to save the data in database
    public void save(Laptop laptop)
    {
        System.out.println("Data Saved in Database...");
    }
}
