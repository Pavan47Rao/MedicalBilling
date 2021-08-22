package edu.neu.csye7374.driver;

public class Expense {
	
	public Expense(){};
	
	String service;
	int patientId;
	
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	
}
