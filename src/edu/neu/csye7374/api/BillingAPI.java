package edu.neu.csye7374.api;

import java.util.List;

public interface BillingAPI {
	double accumulation(List<MedicalProcedureAPI> billItems);
}
