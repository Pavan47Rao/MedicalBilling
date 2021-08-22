package edu.neu.csye7374.strategy;

import edu.neu.csye7374.api.ViewBillAPI;
import edu.neu.csye7374.roles.Patient;

public class Context {
	
	private ViewBillAPI viewBill;

	public void setViewBill(ViewBillAPI viewBill) {
		this.viewBill = viewBill;
	}

	public Context(ViewBillAPI viewBill) {
		this.viewBill = viewBill;
	}
	
	public String displayBillItems(Patient patient) {
		return viewBill.displayBillItems(patient);
	}
	
}
