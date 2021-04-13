package com.loi.loanproposal.db.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.GenerationType;

@Entity
public class Employee{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq_gen")
    @SequenceGenerator(name = "employee_seq_gen", sequenceName = "EMPLOYEE_SEQ")
    private Long id;

    @Column
    private String lastName;
    
    @Column
    private String firstName;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    private Employee supervisor;
    
    @Column
    private Date startDate;
    
    @Column
    private String payLevel;
    
    @Column
    private String payType;
    
    @Column
    private String notes;
}