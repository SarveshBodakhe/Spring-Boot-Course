package com.sarvesh.SpringBootDemo;

import com.sarvesh.SpringBootDemo.model.Alien;
import com.sarvesh.SpringBootDemo.model.Laptop;
import com.sarvesh.SpringBootDemo.service.LaptopService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

//Assume that it is our client, and we have to send some request or store some data in database
//Here we don't have controller right now to accept the request
@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootDemoApplication.class, args);

		LaptopService service = context.getBean(LaptopService.class);

		Laptop laptop = context.getBean(Laptop.class);

		//I want to store some data from laptop object into the database by doing some processing
		//So, from here request goes to service class, it does some processing.
		service.addLaptop(laptop);
	}

}
