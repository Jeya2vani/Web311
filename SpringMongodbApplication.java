package com.example.springmongodb;

import com.example.springmongodb.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages ={"com.example.springmongodb.repository"} )
@SpringBootApplication
public class SpringMongodbApplication implements CommandLineRunner {
	@Autowired
	private EmployeeRepository employeeRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringMongodbApplication.class, args);
	}
	@Override
	public void run(String... args)throws Exception{
		System.out.println(employeeRepository.findBySalaryGreaterThan(10000));
	}
}
