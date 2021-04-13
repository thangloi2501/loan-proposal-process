package com.loi.loanproposal.db.repository;

import com.loi.loanproposal.db.entity.Education;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface EducationRepository extends CrudRepository<Education, Long>{
}