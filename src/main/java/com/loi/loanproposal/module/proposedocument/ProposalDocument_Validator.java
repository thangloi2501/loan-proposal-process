package com.loi.loanproposal.module.proposedocument;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.impl.form.validator.FormFieldValidator;
import org.camunda.bpm.engine.impl.form.validator.FormFieldValidatorContext;

@Slf4j
public class ProposalDocument_Validator implements FormFieldValidator {

    @Override
    public boolean validate(Object submittedValue, FormFieldValidatorContext validatorContext) {

        log.info("VALIDATOR....");
        log.info("Submitted value: ", submittedValue);
        
        return true;
    }
}