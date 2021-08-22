package edu.neu.csye7374.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.neu.csye7374.decorator.MRIDecorator;
import edu.neu.csye7374.decorator.XRAYDecorator;
import edu.neu.csye7374.driver.Expense;
import edu.neu.csye7374.driver.MedicalBill;
import edu.neu.csye7374.driver.Person;
import edu.neu.csye7374.item.ItemRepository;
import edu.neu.csye7374.roles.Patient;
import edu.neu.csye7374.util.FileUtil;

@Controller
public class AdminController {

	int selectedPatientId;
	
	@RequestMapping(value = "/admitPatient", method = RequestMethod.GET)
	public String viewPatientForm(Model model) {
		model.addAttribute("patient", new Patient(0, "", ""));
		return "admitPatient";
	}
	
	@RequestMapping(value = "/admitPatient", method = RequestMethod.POST)
    public String savePatient(@ModelAttribute("patientDetails")Patient patient, ModelMap model) {
        model.addAttribute("lastName", patient.getLastName());
        model.addAttribute("firstName", patient.getFirstName());
        model.addAttribute("id", patient.getId());
        RoleController.person.admitPatient(patient);
        return "viewPatient";
    }
	
	@RequestMapping(value = "/updateBill", method = RequestMethod.GET)
	public String viewServices(Model model) {
		List<Integer> userIds = new ArrayList<>(Person.patientDirectory.keySet());
		List<String> services = Arrays.asList("XRay", "MRI", "ToothPaste", "Tylenol");
		Expense expense = new Expense();
		model.addAttribute("userIds", userIds);
		model.addAttribute("services", services);
		model.addAttribute("expense", expense);
		return "updateBill";
	}
	
	@RequestMapping(value = "/updateBill", method = RequestMethod.POST)
	public String updateBill(@ModelAttribute("expenseDetails")Expense expense, ModelMap model) {
		ItemRepository.loadItems();
		Patient patient = Person.patientDirectory.get(expense.getPatientId());
		selectedPatientId = patient.getId();
		switch (expense.getService()) {
		case "XRay":
			RoleController.person.addExpenseToPatient(patient, new XRAYDecorator(new MedicalBill()));
			break;
		case "MRI":
			RoleController.person.addExpenseToPatient(patient, new MRIDecorator(patient.getMedicalBill()));
			break;
		case "ToothPaste":
		case "Tylenol":
			RoleController.person.addExpenseToPatient(patient, expense.getService());
			break;
		}
		List<Integer> userIds = new ArrayList<>(Person.patientDirectory.keySet());
		List<String> services = Arrays.asList("XRay", "MRI", "ToothPaste", "Tylenol");
		model.addAttribute("userIds", userIds);
		model.addAttribute("services", services);
		model.addAttribute("expense", expense);
		return "updateBill";
	}
	
	@RequestMapping("/uploadBill")
	public String uploadBill(ModelMap model) {
		FileUtil.writeToCSV("/Users/pavanrao/Desktop/MedicalBilling/src/PatientBill.csv", selectedPatientId);
		List<Integer> userIds = new ArrayList<>(Person.patientDirectory.keySet());
		List<String> services = Arrays.asList("XRay", "MRI", "ToothPaste", "Tylenol");
		model.addAttribute("userIds", userIds);
		model.addAttribute("services", services);
		model.addAttribute("expense", new Expense());
		return "updateBill";
	}
	
}
