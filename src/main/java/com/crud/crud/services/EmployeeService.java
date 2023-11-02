package com.crud.crud.services;

import com.crud.crud.models.EmployeeModel;
import com.crud.crud.repositories.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
     EmployeeRepository employeeRepository;

    @Transactional
    public EmployeeModel save(EmployeeModel employeeModel) {
        return employeeRepository.save(employeeModel);
    }
}
