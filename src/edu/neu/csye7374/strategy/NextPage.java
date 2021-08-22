package edu.neu.csye7374.strategy;

import edu.neu.csye7374.api.ViewBillAPI;
import edu.neu.csye7374.roles.Patient;

public class NextPage implements ViewBillAPI{

	@Override
	public String displayBillItems(Patient patient) {
		// TODO Auto-generated method stub
		return "viewBill";
	}

}
