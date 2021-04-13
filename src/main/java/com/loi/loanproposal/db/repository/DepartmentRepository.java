package com.loi.loanproposal.db.repository;

import com.loi.loanproposal.db.entity.Department;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long>{
}