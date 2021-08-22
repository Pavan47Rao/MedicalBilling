package edu.neu.csye7374.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.neu.csye7374.adapter.Calculator;
import edu.neu.csye7374.adapter.CalculatorAdapter;
import edu.neu.csye7374.api.BillingAPI;
import edu.neu.csye7374.api.MedicalProcedureAPI;
import edu.neu.csye7374.controller.RoleController;
import edu.neu.csye7374.driver.MedicalBill;
import edu.neu.csye7374.driver.Person;
import edu.neu.csye7374.roles.Patient;

public class FileUtil {
	
	public static void writeToCSV(String filePath, int patientId) {
		try {
			File file = new File(filePath);
			file.createNewFile();
			FileWriter fileWriter = new FileWriter(filePath, true);
			List<MedicalProcedureAPI> billItems = Person.patientBillItems.get(patientId);
			Patient patient = Person.patientDirectory.get(patientId);
			
			fileWriter.append("Patient Id").append(",");
			fileWriter.append("Patient First Name").append(",");
			fileWriter.append("Patient Last Name").append("\n");
			
			fileWriter.append(""+patient.getId()).append(",");
			fileWriter.append(patient.getFirstName()).append(",");
			fileWriter.append(patient.getLastName()).append("\n\n");
			
			fileWriter.append("Code").append(",");
			fileWriter.append("Description").append(",");
			fileWriter.append("Cost").append("\n");
			
			fileWriter.append("Bill Items:\n");
			for(MedicalProcedureAPI item: billItems) {
				fileWriter.append(item.getCode()).append(",");
				fileWriter.append(item.getDesc()).append(",");
				fileWriter.append("$"+item.getCost()).append("\n");
			}
			BillingAPI bill = new CalculatorAdapter(new Calculator());
			fileWriter.append("\nTotal Cost: ").append(",").append(",").append("$"+bill.accumulation(billItems));
			fileWriter.flush();
			fileWriter.close();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static List<MedicalProcedureAPI> readFromCSV(String filePath, int patientId) {
		List<MedicalProcedureAPI> billItems = new ArrayList<>();
		try {
			File file = new File(filePath);
			if (!file.exists()) {
				System.out.println("Do not find the specific file...");
				return null;
			}
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			String row;
			while ((row = bufferedReader.readLine()) != null) {
			    String[] data = row.split(",");
			    billItems.add(null);
			}
			bufferedReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Person.patientBillItems.get(patientId);
	}
}
