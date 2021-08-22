package edu.neu.csye7374.strategy;

import edu.neu.csye7374.api.ViewBillAPI;
import edu.neu.csye7374.controller.RoleController;
import edu.neu.csye7374.roles.Patient;

public class Console implements ViewBillAPI{

	@Override
	public String displayBillItems(Patient patient) {
		// TODO Auto-generated method stub
		RoleController.person.viewMedicalExpenses(patient);
		return null;
	}

}