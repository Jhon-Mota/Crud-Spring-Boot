package com.crud.crud.repositories;

import com.crud.crud.models.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, UUID> {

    boolean existsByCpf(String cpf);
    boolean existsByRg(String rg);
}
