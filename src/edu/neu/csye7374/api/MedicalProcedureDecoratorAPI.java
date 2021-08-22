package edu.neu.csye7374.api;

public class MedicalProcedureDecoratorAPI implements MedicalProcedureAPI {

	private MedicalProcedureAPI procedure;
    
    public MedicalProcedureDecoratorAPI() {}
    
    /**
     * Constructor that has the MedicalProcedureAPI for it
     * @param procedure
     */
     public MedicalProcedureDecoratorAPI(MedicalProcedureAPI procedure) {
        this.procedure = procedure;
    }
    
    @Override
    public String getCode() {
        return this.procedure.getCode();
    }

    @Override
    public String getDesc() {
        return this.procedure.getDesc();
    }

    @Override
    public double getCost() {
        return this.procedure.getCost();
    }

 

}