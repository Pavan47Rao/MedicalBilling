package edu.neu.csye7374.roles;

import java.util.List;

import edu.neu.csye7374.adapter.Calculator;
import edu.neu.csye7374.adapter.CalculatorAdapter;
import edu.neu.csye7374.api.BillingAPI;
import edu.neu.csye7374.api.MedicalProcedureAPI;
import edu.neu.csye7374.api.MedicalProcedureDecoratorAPI;
import edu.neu.csye7374.api.RoleAPI;
import edu.neu.csye7374.driver.Person;
import edu.neu.csye7374.util.FileUtil;

public class Patient extends Person implements RoleAPI{

	public Patient(int id, String firstName, String lastName) {
		super.setId(id);
		super.setFirstName(firstName);
		super.setLastName(lastName);
	}

	private MedicalProcedureAPI medicalBill;
    
    public MedicalProcedureAPI getMedicalBill() {
		return medicalBill;
	}

	public void setMedicalBill(MedicalProcedureAPI medicalBill) {
		this.medicalBill = medicalBill;
	}
	
	@Override
	public void viewMedicalExpenses(Patient patient) {
		List<MedicalProcedureAPI> billItems = Person.patientBillItems.get(patient.getId());
		System.out.println("#"+patient.getId()+" "+patient.getFirstName()+" "+patient.getLastName());
		System.out.println("Your bill is as follows:");
		BillingAPI bill = new CalculatorAdapter(new Calculator());
		for(MedicalProcedureAPI item: billItems) {
			System.out.println("#"+item.getCode()+" "+item.getDesc()+" $"+item.getCost());
		}
		System.out.println("Total Cost: $"+bill.accumulation(billItems));
	}
	
	@Override
	public void admitPatient(Patient patient) {
		System.out.println("You're not authorized to admit patient");
	}
	
	@Override
	public void addExpenseToPatient(Patient patient, MedicalProcedureDecoratorAPI medicalBill) {
		System.out.println("You're not authorized to update the bill");
	}
	
	@Override
	public void addExpenseToPatient(Patient patient, String item) {
		System.out.println("You're not authorized to update the bill");
	}
	
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("#").append(super.getId());
	    sb.append(" ").append(super.getFirstName());
	    sb.append(" ").append(super.getLastName());
	    sb.append(medicalBill);
	    return sb.toString();
	}

}
