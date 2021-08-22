package edu.neu.csye7374.adapter;

import java.util.List;

import edu.neu.csye7374.api.BillingAPI;
import edu.neu.csye7374.api.CalculateAPI.OPERATION;
import edu.neu.csye7374.api.MedicalProcedureAPI;

public class CalculatorAdapter implements BillingAPI{

	private final Calculator calc;
	private double sum;
	
	public CalculatorAdapter(Calculator calc) {
		super();
		this.calc = calc;
		this.sum =0;
	}
	
	@Override
	public double accumulation(List<MedicalProcedureAPI> items) {
		// TODO Auto-generated method stub
		sum = 0;
		for(MedicalProcedureAPI item:items) {
			sum = this.calc.operation(OPERATION.ADD,sum,item.getCost());
		}
		return sum;
	}
}
