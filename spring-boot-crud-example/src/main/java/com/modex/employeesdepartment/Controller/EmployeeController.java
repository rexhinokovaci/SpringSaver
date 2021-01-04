package com.modex.employeesdepartment.Controller;

import com.modex.employeesdepartment.Config.SecurityConfig;
import com.modex.employeesdepartment.Entity.EmployeeEntity;
import com.modex.employeesdepartment.Service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {


    @Autowired
    private EmployeeService service;

//    @RequestMapping
    @PostMapping("/home/addDepartment")
    public EmployeeEntity addDepartment(@RequestBody EmployeeEntity employeeEntity) {
        getLogger();
        return service.saveDepartment(employeeEntity);
    }

    @PostMapping("/home/addDepartments")
    public List<EmployeeEntity> addDepartments(@RequestBody List<EmployeeEntity> employeeEntities) {
        getLogger();
        return service.saveDepartments(employeeEntities);
    }

    @GetMapping("/home/departments")
    public List<EmployeeEntity> findAllDepartments() {
        getLoggerFind();
        return service.getDepartments();
    }

    @GetMapping("/home/departmentById/{id}")
    public EmployeeEntity findDepartmentById(@PathVariable int id) {
        getLoggerFind();
        return service.getDepartmentstById(id);
    }
//departmentbyName
    @GetMapping("/home/departmentbyName/{name}")
    public EmployeeEntity findDepartmentByName(@PathVariable String name) {
        getLoggerFind();
        return service.getDepartmentsByName(name);
    }

    @PutMapping("/home/update")
    public EmployeeEntity updateDepartment(@RequestBody EmployeeEntity employeeEntity) {
        getLoggerUpdate();
        return service.updateDepartment(employeeEntity);
    }

    @DeleteMapping("/home/delete/{id}")
    public String deleteDepartment(@PathVariable int id) {
        getLoggerDelete();
        return service.deleteDepartment(id);
    }


    final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    public Logger getLogger() {
        logger.debug("Employee has Added a department");
        logger.info("Employee is on API");
        return logger;
    }

    public Logger getLoggerFind() {
        logger.debug("Employee is finding deparment by id and name");
        logger.info("Employee is on API");
        return logger;
    }

    public Logger getLoggerUpdate() {
        logger.debug("Employee is updating department by id and name");
        logger.info("Employee is on API");
        return logger;
    }

    public Logger getLoggerDelete() {
        logger.debug("Employee is deleting department by id and name");
        logger.info("Employee is on API");
        return logger;
    }





}
