package edu.neu.csye7374.api;

import edu.neu.csye7374.roles.Patient;

public interface RoleAPI {
	public void admitPatient(Patient patient);
	public void addExpenseToPatient(Patient patient, MedicalProcedureDecoratorAPI medicalBill);
	public void addExpenseToPatient(Patient patient, String item);
	public void viewMedicalExpenses(Patient patient);
}
