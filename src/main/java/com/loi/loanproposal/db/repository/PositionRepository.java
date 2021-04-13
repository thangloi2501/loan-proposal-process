package com.loi.loanproposal.db.repository;

import com.loi.loanproposal.db.entity.Position;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface PositionRepository extends CrudRepository<Position, Long>{
}