package edu.neu.csye7374.decorator;

import edu.neu.csye7374.api.MedicalProcedureAPI;
import edu.neu.csye7374.api.MedicalProcedureDecoratorAPI;

public class XRAYDecorator extends MedicalProcedureDecoratorAPI{
	public static final String XRAY_BILLABLE_DESCRIPTION = "X-RAY Diagnostic Image";
	public static final double XRAY_BILLABLE_COST = 7345.73;
	public static final String XRAY_BILLABLE_CODE = "X456";
	private final MedicalProcedureAPI medicalBill;
	
	public XRAYDecorator(MedicalProcedureAPI obj) {
		this.medicalBill = obj;
	}
	
	@Override
    public String getCode() {
        return medicalBill.getCode() + " " + XRAY_BILLABLE_CODE;
    }

    @Override
    public String getDesc() {
        return medicalBill.getDesc() + " " + XRAY_BILLABLE_DESCRIPTION;
    }

    @Override
    public double getCost() {
        return XRAY_BILLABLE_COST;
    }
    
    @Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(medicalBill.toString());
        sb.append("\n#").append(XRAY_BILLABLE_CODE);
        sb.append(" $").append(XRAY_BILLABLE_COST);
        sb.append(" '").append(XRAY_BILLABLE_DESCRIPTION).append("'");
        sb.append("\nTotal Cost: $").append(medicalBill.getCost()+getCost());
        
        return sb.toString();
		
	}
}
