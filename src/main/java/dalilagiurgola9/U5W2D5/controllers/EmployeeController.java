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
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
        if (validation.hasErrors()) throw new BadRequestException(validation.getAllErrors());
        else return this.employeeService.save(body);
    }

    @PutMapping("/{id}")
    private Employee findByIdAndUpdate(@PathVariable long id, @RequestBody @Validated EmployeeDTO body, BindingResult validation) {
        if(validation.hasErrors()) throw new BadRequestException(validation.getAllErrors());
        else return this.employeeService.findByIdAndUpdate(id, body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteEmployee(@PathVariable long id) {
        this.employeeService.findByIdAndDelete(id);
    }

    @PatchMapping("/{id}/upload")
    private Employee uploadAvatar(@PathVariable long id, @RequestParam("avatar")MultipartFile image) throws IOException {
        return this.employeeService.changeAvatarImage(id, image);
    }
}
