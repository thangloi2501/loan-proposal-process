package com.loi.loanproposal.db.entity;

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
public class Position{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "position_seq_gen")
    @SequenceGenerator(name = "position_seq_gen", sequenceName = "POSITION_SEQ")
    private Long id;

    @Column
    private String positionType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Employee replacement;
    
    @Column
    private String jobTitle;
    
    @Column
	private String ild;
}