package com.modex.employeesdepartment.Repository;

import com.modex.employeesdepartment.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer> {
    EmployeeEntity findByName(String name);


}

