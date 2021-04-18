package com.loi.loanproposal.module.proposedocument;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;

/**
 * @author Loi Nguyen
 *
 */
public class ProposeDocument_CompleteListener implements TaskListener {

        @Override
        public void notify(DelegateTask delegateTask) {

                // String refNo = String.valueOf(delegateTask.getVariable("referenceNo"));
                // String instanceId = delegateTask.getProcessInstanceId();
                // Calendar cal = Calendar.getInstance();
                // cal.setTime(new Date());
                // cal.add(Calendar.DATE, 1);
                
                // Requisition requisition = new Requisition();
                // requisition.setEmpNum(1);
                // requisition.setDate(cal.getTime());
                // requisition.setEmpType("fullTime");
                // requisition.setDepartment("IT");
                // requisition.setLocation("");
                // requisition.setReqNum(refNo);
                // requisition.setInstanceId(instanceId);
                // requisition.setRequester(delegateTask.getOwner());

                // Qualification qualification = new Qualification();
                // Position position = new Position();
                // position.setJobTitle("");
                // position.setPositionType("");
                // position.setReplacement(new Person());

                // ObjectValue customerDataValue1 = Variables.objectValue(requisition)
                //                 .serializationDataFormat(Variables.SerializationDataFormats.JSON).create();

                // ObjectValue customerDataValue2 = Variables.objectValue(qualification)
                //                 .serializationDataFormat(Variables.SerializationDataFormats.JSON).create();

                // ObjectValue customerDataValue3 = Variables.objectValue(position)
                //                 .serializationDataFormat(Variables.SerializationDataFormats.JSON).create();

                // delegateTask.setVariableLocal("requisition", customerDataValue1);
                // delegateTask.setVariableLocal("qualification", customerDataValue2);
                // delegateTask.setVariableLocal("position", customerDataValue3);

                delegateTask.setVariableLocal("processData", delegateTask.getVariable("processData"));
        }
}