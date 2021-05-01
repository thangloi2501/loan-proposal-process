package com.loi.loanproposal.db.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyGroup;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMER", uniqueConstraints = {
        @UniqueConstraint(columnNames = "code")
})

@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq_gen")
    @SequenceGenerator(name = "customer_seq_gen", sequenceName = "CUSTOMER_SEQ")
    private Long id;

    @NaturalId
    @Column
    private String code;

    @Column
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column
    private String address;

    @Column
    private String type;    // customer type code

    @ManyToOne(fetch=FetchType.LAZY)
    @LazyToOne(LazyToOneOption.NO_PROXY)
    @JoinColumn(name="type", referencedColumnName="code", insertable=false, updatable=false)
    private CustomerType customerType;
}