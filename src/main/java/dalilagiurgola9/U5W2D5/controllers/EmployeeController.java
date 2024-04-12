package dalilagiurgola9.U5W2D5.controllers;

import dalilagiurgola9.U5W2D5.entities.Employee;
import dalilagiurgola9.U5W2D5.exceptions.BadRequestException;
import dalilagiurgola9.U5W2D5.payloads.EmployeeDTO;
import dalilagiurgola9.U5W2D5.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    //ATTRIBUTES LIST:
    @Autowired
    private EmployeeService employeeService;

    //CRUD METHODS:
    @GetMapping
    private Page<Employee> getAllEmployees(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sort) {
        return this.employeeService.findAll(page, size, sort);
    }

    @GetMapping("/{id}")
    private Employee getEmployeeById(@PathVariable long id) {
        return this.employeeService.findById(id);
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    private Employee saveNewEmployee(@RequestBody @Validated EmployeeDTO body, BindingResult validation){
        if (validation.hasErrors()) throw new BadRequestException(validation.get)
    }

    @PutMapping("/{id}")
    private Employee findByIdAndUpdate(@PathVariable long id, @RequestBody Employee body) {

    }
}
