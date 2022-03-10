package com.example.springmongodb.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString

@Document(collection = "Employee")
public class Employee {
    @Id
    private int id;
    private String name;
    private String department;
    private int salary;
}
