package edu.neu.csye7374.driver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.neu.csye7374.api.MedicalProcedureAPI;
import edu.neu.csye7374.api.MedicalProcedureDecoratorAPI;
import edu.neu.csye7374.api.RoleAPI;
import edu.neu.csye7374.roles.Patient;

/**
 * Person class to model a person hospitalized with a resulting medical bill.
 * 
 * @author pavanrao
 *
 */
public class Person implements RoleAPI{
	private int id;
    private String firstName;
    private String lastName;
    public static Map<Integer, Patient> patientDirectory = new HashMap<>();
    public static Map<Integer, List<MedicalProcedureAPI>> patientBillItems = new HashMap<>();
    private static Person person;
    
    private RoleAPI role;
       
    public Person() {
    	person = null;
    }
    
    public static synchronized Person getInstance() {
    	if(person == null) {
    		person = new Person();
    	}
    	return person;
    }
    /**
     * getters and setters
     */
    public int getId() {
    	return this.id;
    }
 
    public void setId(int id) {
    	this.id = id;
    }
    
    public String getFirstName() {
    	return this.firstName;
    }
    
    public void setFirstName(String firstName) {
    	this.firstName = firstName;
    }
    
    public String getLastName() {
    	return this.lastName;
    }
    
    public void setLastName(String lastName) {
    	this.lastName = lastName;
    }
    
	public RoleAPI getRole() {
		return role;
	}

	public void setRole(RoleAPI role) {
		this.role = role;
	}

	/**
     * return a String representation of the object state
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("#").append(id);
        sb.append(" ").append(firstName);
        sb.append(" ").append(lastName);
        
        return sb.toString();
    }

	@Override
	public void viewMedicalExpenses(Patient patient) {
		this.role.viewMedicalExpenses(patient);
	}

	@Override
	public void admitPatient(Patient patient) {
		this.role.admitPatient(patient);
	}

	@Override
	public void addExpenseToPatient(Patient patient, MedicalProcedureDecoratorAPI medicalBill) {
		this.role.addExpenseToPatient(patient, medicalBill);
	}

	@Override
	public void addExpenseToPatient(Patient patient, String item) {
		this.role.addExpenseToPatient(patient, item);
	}

}
