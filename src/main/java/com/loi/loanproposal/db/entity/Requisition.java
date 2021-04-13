package com.loi.loanproposal.db.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.GenerationType;

@Entity
public class Requisition{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "requisition_seq_gen")
    @SequenceGenerator(name = "requisition_seq_gen", sequenceName = "requisition_SEQ")
    private Long id;

    @Column
    private String reqNum;
    
    @Column
    private String requester;
    
    @Column
    private String empType;
    
    @Column
    private Boolean approvalNeeded;
    
    @Column
    private Date date;
    
    @Column
    private String department;
    
    @Column
	private String location;
    
    @Column
    private Integer empNum;
    
    @Column
    private String gmApproval;
    
    @Column
    private String gmComments;
    
    @Column
    private String instanceId;
}