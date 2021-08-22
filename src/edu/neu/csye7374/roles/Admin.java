package edu.neu.csye7374.roles;

import java.util.ArrayList;

import edu.neu.csye7374.api.MedicalProcedureAPI;
import edu.neu.csye7374.api.MedicalProcedureDecoratorAPI;
import edu.neu.csye7374.api.RoleAPI;
import edu.neu.csye7374.decorator.ParameterizedDecorator;
import edu.neu.csye7374.driver.Person;

public class Admin extends Person implements RoleAPI{

	public Admin(int id, String firstName, String lastName) {
		super.setId(id);
		super.setFirstName(firstName);
		super.setLastName(lastName);
	}
	
	@Override
	public void admitPatient(Patient patient) {
		if(Person.patientDirectory.containsKey(patient.getId())) {
			System.out.println("Patient already admitted!");
		}
		else {
			Person.patientDirectory.put(patient.getId(), patient);
			System.out.println("Patient admitted to the hospital");
		}
	}
	
	@Override
	public void addExpenseToPatient(Patient patient, MedicalProcedureDecoratorAPI medicalBill) {
		patient.setMedicalBill(medicalBill);
		if(!Person.patientBillItems.containsKey(patient.getId()))
			Person.patientBillItems.put(patient.getId(), new ArrayList<>());
		Person.patientBillItems.get(patient.getId()).add(medicalBill);
		System.out.println("Added "+ medicalBill.getDesc()+" to the bill");
	}
	
	@Override
	public void addExpenseToPatient(Patient patient, String item) {
		MedicalProcedureAPI legacyBill = new ParameterizedDecorator(item, patient.getMedicalBill());
		patient.setMedicalBill(legacyBill);
		if(!Person.patientBillItems.containsKey(patient.getId()))
			Person.patientBillItems.put(patient.getId(), new ArrayList<>());
		Person.patientBillItems.get(patient.getId()).add((MedicalProcedureDecoratorAPI) legacyBill);
		System.out.println("Added "+item+" to the bill");
	}
	
	@Override
	public void viewMedicalExpenses(Patient patient) {
		System.out.println("You can't view the bill");
	}
}
