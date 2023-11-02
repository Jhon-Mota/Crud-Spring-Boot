package com.crud.crud.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.sql.Date;


public record EmployeeDto(
        @NotBlank @Size(max = 100) String name,

        @NotBlank String email,

        @NotBlank @Size(max = 16) String rg,

        @NotBlank @Size(max = 16) String cpf,

        @NotBlank @Size(max = 40) String role,

        @NotNull @DecimalMin(value = "1.00") BigDecimal remuneration,

        @NotNull @DecimalMin(value = "1") float workLoad,

        @Size(max = 20) String gender,

        @JsonFormat(pattern = "dd/MM/yyyy") Date dateOfBirth,

        @NotBlank @Size(max = 15) String maritalStatus,

        boolean armyDocument
        ) {
}
