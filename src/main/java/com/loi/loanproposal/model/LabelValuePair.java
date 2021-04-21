package com.loi.loanproposal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
@AllArgsConstructor @Builder
public class LabelValuePair implements Serializable{
    private String label;
    private String value;
}