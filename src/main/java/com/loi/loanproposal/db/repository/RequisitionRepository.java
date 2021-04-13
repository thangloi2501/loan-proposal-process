package com.loi.loanproposal.db.repository;

import com.loi.loanproposal.db.entity.Requisition;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface RequisitionRepository extends CrudRepository<Requisition, Long>{
}