package com.loi.loanproposal.db.repository;

import com.loi.loanproposal.db.entity.Skill;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface SkillRepository extends CrudRepository<Skill, Long>{
}