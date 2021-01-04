package com.modex.employeesdepartment.Service;

import com.modex.employeesdepartment.Entity.EmployeeEntity;
import com.modex.employeesdepartment.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public EmployeeEntity saveDepartment(EmployeeEntity employeeEntity) {
        return repository.save(employeeEntity);
    }

    public List<EmployeeEntity> saveDepartments(List<EmployeeEntity> employeeEntities) {
        return repository.saveAll(employeeEntities);
    }

    public List<EmployeeEntity> getDepartments() {
        List<EmployeeEntity> employeeEntities = repository.findAll();
        System.out.println("Database is taken from the employeedepartment: " + employeeEntities);
        return repository.findAll();
//        return employeeEntities;
    }

    public EmployeeEntity getDepartmentstById(int id) {
        return repository.findById(id).orElse(null);
    }

    public EmployeeEntity getDepartmentsByName(String name) {
        return repository.findByName(name);
    }

    public String deleteDepartment(int id) {
        repository.deleteById(id);
        return "Department with id: " + id + " removed";
    }

    public EmployeeEntity updateDepartment(EmployeeEntity employeeEntity) {
        EmployeeEntity existingEmployeeEntity = repository.findById(employeeEntity.getId()).orElse(null);
        existingEmployeeEntity.setName(employeeEntity.getName());
        existingEmployeeEntity.setDepartmentId(employeeEntity.getDepartmentId());
        existingEmployeeEntity.setQuota(employeeEntity.getQuota());
        return repository.save(existingEmployeeEntity);
    }


}
