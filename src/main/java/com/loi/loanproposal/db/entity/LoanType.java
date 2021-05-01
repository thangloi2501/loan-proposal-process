package com.loi.loanproposal.db.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "LOAN_TYPE", uniqueConstraints = {
        @UniqueConstraint(columnNames = "code")
})

@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class LoanType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loan_type_seq_gen")
    @SequenceGenerator(name = "loan_type_seq_gen", sequenceName = "LOAN_TYPE_SEQ")
    private Long id;

    @NaturalId
    @Column
    private String code;

    @Column
    private String name;
}