package com.crud.crud.controllers;

import com.crud.crud.dtos.EmployeeDto;
import com.crud.crud.models.EmployeeModel;
import com.crud.crud.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeModel> registerEmployee(@RequestBody @Valid EmployeeDto employeeDto, String cpf){
        var employeeModel = new EmployeeModel();

        BeanUtils.copyProperties(employeeDto, employeeModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.save(employeeModel));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeModel>> getAllEmployees(){
        return ResponseEntity.status(HttpStatus.FOUND).body(employeeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneEmployee(@PathVariable(value = "id") UUID id){

        Optional<EmployeeModel> infoEmployee = employeeService.findById(id);

        if(!infoEmployee.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found.");
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(infoEmployee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeModel> updateEmployee(@PathVariable(value = "id")UUID id,
                                                        @RequestBody @Valid EmployeeDto employeeDto){

        Optional<EmployeeModel> infoEmployeeOptional = employeeService.findById(id);
        var infoEmployee = infoEmployeeOptional.get();
        BeanUtils.copyProperties(employeeDto, infoEmployee);
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.save(infoEmployee));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable(value = "id") UUID id){

        Optional<EmployeeModel> infoEmployeeOptional = employeeService.findById(id);
        employeeService.delete(infoEmployeeOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Employee deleted.");
    }

}
