package com.loi.loanproposal.model;

import com.loi.loanproposal.enums.LoanType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter @Setter
@AllArgsConstructor @Builder
public class Loan {
    private String id; //L.YYYYMMDD.XXX
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
