package com.example.springmongodb.resource;

import com.example.springmongodb.model.Employee;
import com.example.springmongodb.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/addEmployee")
    public String saveEmployee(@RequestBody Employee employee){
        employeeRepository.save(employee);
        return "Added employee with id : "+employee.getId();
    }
    @GetMapping("/findAllEmployee")
    public List<Employee> getEmployee(){
        return employeeRepository.findAll();
    }
    @GetMapping("/findAllEmployee/{id}")
    public Optional<Employee> getEmployee(@PathVariable int id){
        return employeeRepository.findById(id);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id){
        employeeRepository.deleteById(id);
        return "Employee deleted with id : "+id;
    }
    /*@GetMapping("/findSalary/{salary}")
    public List<Employee> getEmployeeSalary(@PathVariable int salary){
        return employeeRepository.findBySalaryGreaterThan(salary);
    }*/
    @GetMapping("/findSalary")
    public ResponseEntity<List<Employee>> getEmployeeBySalary(@RequestParam int salary){
        return new ResponseEntity<List<Employee>>(employeeRepository.findBySalaryGreaterThan(salary), HttpStatus.OK);
    }
}
