package com.loi.loanproposal.db.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMER_TYPE", uniqueConstraints = {
        @UniqueConstraint(columnNames = "code")
})

@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_type_seq_gen")
    @SequenceGenerator(name = "customer_type_seq_gen", sequenceName = "CUSTOMER_TYPE_SEQ")
    private Long id;

    @NaturalId
    @Column
    private String code;

    @Column
    private String name;
}