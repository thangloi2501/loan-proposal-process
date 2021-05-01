package com.loi.loanproposal.dto;

import lombok.*;

import java.io.Serializable;

/**
 * @author Loi Nguyen
 *
 */
@Data @Builder
@ToString @AllArgsConstructor @NoArgsConstructor
public class DMN implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long loanAmount;
    private Long loanTerm;
}
