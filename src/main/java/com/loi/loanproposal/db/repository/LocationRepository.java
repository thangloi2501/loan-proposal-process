package com.loi.loanproposal.db.repository;

import com.loi.loanproposal.db.entity.Location;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long>{
}