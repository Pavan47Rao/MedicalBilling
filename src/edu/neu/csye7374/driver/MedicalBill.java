package edu.neu.csye7374.driver;

import edu.neu.csye7374.api.MedicalProcedureAPI;

/**
 * class MedicalBill implements MedicalProcedureAPI to initialize underlying summary
 * 
 * @author pavanrao
 *
 */
public class MedicalBill implements MedicalProcedureAPI{
	
	public MedicalBill() {}
	
	private String code = "";
	private String description = "";
	private double cost = 0.0;
	
	@Override
	public String getCode() {
		return code;
	}

	@Override
	public String getDesc() {
		return description;
	}

	@Override
	public double getCost() {
		return cost;
	}
	
	/**
     * return a String representation of the object state
     */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
        return sb.toString();
		
	}

}
