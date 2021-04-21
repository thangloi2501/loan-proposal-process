package com.loi.loanproposal.model;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author Loi Nguyen
 *
 */
@Component("loan")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor @Builder
public class Loan {
    private String id; //L.YYYYMMDD.UUID
    private Long amount; //VND
    private Long term; //in months
    private Double interestRate;
    private LoanType type;

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;

        if (!(other instanceof Loan))
            return false;

        Loan that = (Loan) other;
        return Objects.equals(that.id, this.id);
    }
}
