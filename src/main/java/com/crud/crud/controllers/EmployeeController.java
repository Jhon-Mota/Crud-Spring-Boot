package com.crud.crud.controllers;

import com.crud.crud.dtos.EmployeeDto;
import com.crud.crud.models.EmployeeModel;
import com.crud.crud.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/employee")
    public ResponseEntity<EmployeeModel> registerEmployee(@RequestBody @Valid EmployeeDto employeeDto){
        var employeeModel = new EmployeeModel();
        BeanUtils.copyProperties(employeeDto, employeeModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.save(employeeModel));
    }
}
