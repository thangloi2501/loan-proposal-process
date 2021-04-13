package com.loi.loanproposal.module.validator;

import org.camunda.bpm.engine.impl.form.validator.FormFieldValidator;
import org.camunda.bpm.engine.impl.form.validator.FormFieldValidatorContext;

import java.util.logging.Logger;

public class SubmitApplicationValidator implements FormFieldValidator {

    private final Logger LOGGER = Logger.getLogger(SubmitApplicationValidator.class.getName());

    @Override
    public boolean validate(Object submittedValue, FormFieldValidatorContext validatorContext) {
        // LOGGER.info("test validator");
        // LOGGER.info("Submitted values: " + submittedValue);
        // // get access to all form fields submitted in the form submit
        // Map<String,Object> completeSubmit = validatorContext.getSubmittedValues();
        // Iterator<Object> it = (Iterator<Object>) completeSubmit.values();
        // while(it.hasNext()){
        //     ObjectValue o = Variables.serializedObjectValue(it.next().toString())
        //             .serializationDataFormat(Variables.SerializationDataFormats.JAVA)
        //             .objectTypeName("com.example.Order")
        //             .create();
        // }
        
// LOGGER.info("requisition: " + completeSubmit.get("qualification"));
        // Variables.serializedObjectValue(completeSubmit.get("requisition").toString())
        //         .serializationDataFormat(Variables.SerializationDataFormats.JAVA)
        //         .objectTypeName("com.example.Order")
        //         .create();

        // Requisition requisition = (Requisition)((ObjectValue)completeSubmit.get("requisition")).getValue();
        // LOGGER.info("submitted variables: " + completeSubmit);
        // LOGGER.info("requisition: " + requisition.toString());
        return true;
    }
}