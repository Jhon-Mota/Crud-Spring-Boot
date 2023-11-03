package com.crud.crud.services;

import com.crud.crud.models.EmployeeModel;
import com.crud.crud.repositories.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Transactional
    public EmployeeModel save(EmployeeModel employeeModel) {

        return employeeRepository.save(employeeModel);
    }

    public List<EmployeeModel> findAll() {

        return employeeRepository.findAll();
    }

    public Optional<EmployeeModel> findById(UUID id) {

        return employeeRepository.findById(id);
    }

    public void delete(EmployeeModel employeeModel) {
        employeeRepository.delete(employeeModel);
    }
}