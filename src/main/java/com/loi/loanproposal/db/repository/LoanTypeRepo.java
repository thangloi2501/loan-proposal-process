package com.loi.loanproposal.db.repository;

import com.loi.loanproposal.db.entity.LoanType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanTypeRepo extends JpaRepository<LoanType, Long> {
}