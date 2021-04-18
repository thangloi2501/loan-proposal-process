package com.loi.loanproposal.dto;

import com.loi.loanproposal.model.Customer;
import com.loi.loanproposal.model.Loan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author Loi Nguyen
 *
 */
@Getter @Setter
@AllArgsConstructor @Builder
public class ProposalDocument implements Serializable {
    private String proposalId;
    private LocalDateTime proposalDateTime;
    private Customer customer;
    private Loan loan;
    private String rmCode;

    @Override
    public int hashCode() {
        return Objects.hash(this.proposalId);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;

        if (!(other instanceof ProposalDocument))
            return false;

        ProposalDocument that = (ProposalDocument) other;
        return Objects.equals(that.proposalId, this.proposalId);
    }
}
