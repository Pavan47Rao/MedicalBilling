package edu.neu.csye7374.decorator;

import edu.neu.csye7374.api.MedicalProcedureAPI;
import edu.neu.csye7374.api.MedicalProcedureDecoratorAPI;

public class MRIDecorator extends MedicalProcedureDecoratorAPI{
	public static final String MRI_BILLABLE_DESCRIPTION = "MRI Diagnostic Image";
	public static final double MRI_BILLABLE_COST = 2459.08;
	public static final String MRI_BILLABLE_CODE = "M234";
	private final MedicalProcedureAPI medicalBill;
	
	public MRIDecorator(MedicalProcedureAPI obj) {
		this.medicalBill = obj;
	}
	
	@Override
    public String getCode() {
        return MRI_BILLABLE_CODE;
    }

    @Override
    public String getDesc() {
        return MRI_BILLABLE_DESCRIPTION;
    }

    @Override
    public double getCost() {
        return MRI_BILLABLE_COST;
    }
    
    @Override
   	public String toString() {
   		StringBuilder sb = new StringBuilder();
   		sb.append(medicalBill.toString());
        sb.append("\n#").append(MRI_BILLABLE_CODE);
        sb.append(" $").append(MRI_BILLABLE_COST);
        sb.append(" '").append(MRI_BILLABLE_DESCRIPTION).append("'");
        sb.append("\nTotal Cost: $").append(medicalBill.getCost()+getCost());
        return sb.toString();
   		
   	}
}
