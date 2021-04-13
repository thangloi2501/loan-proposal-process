package com.loi.loanproposal.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component("Person")
public class Person implements Serializable {

	private static final long serialVersionUID = -8399719043236396435L;
	
	private String lastName;
	private String firstName;
	private String supervisor;
	private Date startDate;
	private String payLevel;
	private String payType;
	private String notes;
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getPayLevel() {
		return payLevel;
	}
	public void setPayLevel(String payLevel) {
		this.payLevel = payLevel;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
}
