package com.loi.loanproposal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
@AllArgsConstructor
public class LabelValuePair implements Serializable{
    private String label;
    private String value;
}