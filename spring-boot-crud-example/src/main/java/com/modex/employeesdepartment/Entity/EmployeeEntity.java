package com.modex.employeesdepartment.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DEPARTMENT_TABLE")
public class EmployeeEntity {


    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int DepartmentId;
    private double quota;
}
