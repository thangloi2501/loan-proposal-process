package com.loi.loanproposal.db.repository;

import com.loi.loanproposal.db.entity.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerTypeRepo extends JpaRepository<CustomerType, Long> {
}