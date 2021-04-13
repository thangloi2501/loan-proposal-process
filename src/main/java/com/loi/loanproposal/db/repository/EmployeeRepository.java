package com.loi.loanproposal.db.repository;

import com.loi.loanproposal.db.entity.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}