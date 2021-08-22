package edu.neu.csye7374.api;
/**
 * interface MedicalProcedureAPI is an API which all Medical Procedure subclasses implement
 * to model the billing for medical procedures incurred during a hospital stay.
 * 
 * @author pavanrao
 *
 */
public interface MedicalProcedureAPI {
	/**
     * get the identifying code
     * 
     * @return    String code(s) for the specific expenses billed in statement
     */
    String getCode();
    /**
     * get a String description of the billing statement to patient
     * 
     * @return    String description of the specific expenses billed in statement
     */
    String getDesc();
    /**
     * get the cost as billed to the patient for hospital expenses
     * 
     * @return    cost as billed in statement
     */
    double getCost();
}
