package com.modex.employeesdepartment;

import com.modex.employeesdepartment.Entity.EmployeeEntity;

import com.modex.employeesdepartment.Repository.EmployeeRepository;
import com.modex.employeesdepartment.Service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.junit4.SpringRunner;


import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeDepartmentTest {


    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepository employeeRepository ;
    @Test
    public void getDepartments(){

        when(employeeRepository.findAll()).thenReturn(Stream.of(new EmployeeEntity(12,"TEST DEpart",12,20),
                new EmployeeEntity(34,"Department 2", 34,12)).collect(Collectors.toList()));

        assertEquals(2,employeeService.getDepartments().size());

    }



    @Test
    public void saveDepartmentTest() {
        EmployeeEntity employeeEntity = new EmployeeEntity(1,"HR DPT",2,20);
        when(employeeRepository.save(employeeEntity)).thenReturn(employeeEntity);
        assertEquals(employeeEntity,employeeService.saveDepartment(employeeEntity));
    }


    @Test
    public void deleteDepartmentTest() {
        EmployeeEntity employeeEntity = new EmployeeEntity(1,"HR DPT",2,20);
        employeeService.deleteDepartment(1);
    }


}
