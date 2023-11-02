package com.crud.crud.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "tb_employees")
@Data
public class EmployeeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @CreationTimestamp
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date admissionDate;

    @Column(nullable = false, length = 100)
    @NotBlank
    @Size(max = 100)
    private String name;

    @Column(nullable = false,length = 50)
    @NotBlank
    @Size(max = 50)
    private String email;

    @Column(nullable = false, unique = true, length = 14)
    @NotBlank
    @Size(max = 16)
    private String rg;

    @Column(nullable = false, unique = true, length = 14)
    @NotBlank
    @Size(max = 16)
    private String cpf;

    @Column(nullable = false, length = 40)
    @NotBlank
    @Size(max = 40)
    private String role;

    @Column(nullable = false, length = 10)
    @NotNull
    @DecimalMin(value = "1.00")
    private BigDecimal remuneration;

    @Column(nullable = false, length = 30)
    @NotNull
    @DecimalMin(value = "1")
    private float workLoad;

    @Column(nullable = true, length = 20)
    @Size(max = 20)
    private String gender;

    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dateOfBirth;

    @Column(nullable = false, length = 15)
    @NotBlank
    @Size(max = 15)
    private String maritalStatus;

    @Column(nullable = false)
    private boolean armyDocument;

}
