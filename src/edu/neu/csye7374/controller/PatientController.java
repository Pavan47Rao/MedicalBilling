package edu.neu.csye7374.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.neu.csye7374.adapter.Calculator;
import edu.neu.csye7374.adapter.CalculatorAdapter;
import edu.neu.csye7374.api.BillingAPI;
import edu.neu.csye7374.driver.Person;
import edu.neu.csye7374.roles.Patient;
import edu.neu.csye7374.strategy.Console;
import edu.neu.csye7374.strategy.Context;
import edu.neu.csye7374.strategy.NextPage;

@Controller
public class PatientController {

	
	@RequestMapping(value = "/selectPatient", method = RequestMethod.GET)
	public String selectPatient(Model model) {
		List<Integer> userIds = new ArrayList<>(Person.patientDirectory.keySet());
		model.addAttribute("userIds", userIds);
		model.addAttribute("patient", new Patient(0, "", ""));
		return "patient";
	}
	
	@RequestMapping(value = "/viewBill", method = RequestMethod.POST, params = "nextPage")
    public String viewBillInNextPage(@ModelAttribute("patientDetails")Patient patient, Model model) {
		BillingAPI bill = new CalculatorAdapter(new Calculator());
		model.addAttribute("items", Person.patientBillItems.get(patient.getId()));
		model.addAttribute("patient", Person.patientDirectory.get(patient.getId()));
		model.addAttribute("total", bill.accumulation(Person.patientBillItems.get(patient.getId())));
		NextPage nextPage = new NextPage();
		Context context = new Context(nextPage);
		return context.displayBillItems(patient);
    }
	
	@RequestMapping(value = "/viewBill", method = RequestMethod.POST, params = "console")
    public String viewBillInConsole(@ModelAttribute("patientDetails")Patient patient, Model model) {
		RoleController.person = Person.getInstance();
		Patient patientt = Person.patientDirectory.get(patient.getId());
		RoleController.person.setRole(patientt);
		Console console = new Console();
		Context context = new Context(console);
		context.displayBillItems(patientt);
		return selectPatient(model);
    }
	
	@RequestMapping(value = "/unauthorizedAdmitPatient", method = RequestMethod.GET)
    public String unauthorizedAdmitPatient(Model model) {
		RoleController.person = Person.getInstance();
		Patient patient = new Patient(0, "", "");
		RoleController.person.setRole(patient);
		RoleController.person.admitPatient(patient);
		return selectPatient(model);
    }
	
	@RequestMapping(value = "/unauthorizedUpdateBill", method = RequestMethod.GET)
    public String unauthorizedUpdateBill(Model model) {
		RoleController.person = Person.getInstance();
		Patient patient = new Patient(0, "", "");
		RoleController.person.setRole(patient);
		RoleController.person.addExpenseToPatient(patient, "");
		return selectPatient(model);
    }
}
