package com.loi.loanproposal.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component("Requisition")
public class Requisition implements Serializable {

	private static final long serialVersionUID = 2805327594604148244L;

	private String reqNum;
	private String requester;
	private String empType;
	private Boolean approvalNeeded;
	private Date date;
	private String department;
	private String location;
	private Integer empNum;
	private String gmApproval;
	private String gmComments;
	private String instanceId;

	public String getReqNum() {
		return reqNum;
	}
	public void setReqNum(String reqNum) {
		this.reqNum = reqNum;
	}
	public String getRequester() {
		return requester;
	}
	public void setRequester(String requester) {
		this.requester = requester;
	}
	public String getEmpType() {
		return empType;
	}
	public void setEmpType(String empType) {
		this.empType = empType;
	}
	public Boolean getApprovalNeeded() {
		return approvalNeeded;
	}
	public void setApprovalNeeded(Boolean approvalNeeded) {
		this.approvalNeeded = approvalNeeded;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Integer getEmpNum() {
		return empNum;
	}
	public void setEmpNum(Integer empNum) {
		this.empNum = empNum;
	}
	public String getGmApproval() {
		return gmApproval;
	}
	public void setGmApproval(String gmApproval) {
		this.gmApproval = gmApproval;
	}
	public String getGmComments() {
		return gmComments;
	}
	public void setGmComments(String gmComments) {
		this.gmComments = gmComments;
	}
	public String getInstanceId() {
		return instanceId;
	}
	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}
}
