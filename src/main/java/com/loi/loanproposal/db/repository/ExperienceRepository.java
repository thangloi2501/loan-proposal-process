package com.loi.loanproposal.db.repository;

import org.springframework.stereotype.Repository;
import com.loi.loanproposal.db.entity.Experience;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface ExperienceRepository extends CrudRepository<Experience, Long>{

}