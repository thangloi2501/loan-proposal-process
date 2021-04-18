package com.loi.loanproposal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Loi Nguyen
 */
@Getter @Setter
@AllArgsConstructor @Builder
public class ProcessData implements Serializable {
    private String processId;

    private String rmCode;
    private String rmDecision;
    private String rmComment;

    private String rmManager1Code;
    private String rmManager1Decision;
    private String rmManager1Comment;

    private String rmManager2Code;
    private String rmManager2Decision;
    private String rmManager2Comment;

    @Override
    public int hashCode() {
        return Objects.hash(this.processId);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;

        if (!(other instanceof ProcessData))
            return false;

        ProcessData that = (ProcessData) other;
        return Objects.equals(that.processId, this.processId);
    }
}
