package fr.uha.anis.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.uha.anis.models.client.Client;
import fr.uha.anis.models.client.Supplier;
import fr.uha.anis.models.country.Country;
import fr.uha.anis.models.country.State;
import fr.uha.anis.models.person.Employee;
import fr.uha.anis.services.ClientService;
import fr.uha.anis.services.CountryService;
import fr.uha.anis.services.EmployeeService;
import fr.uha.anis.services.StateService;
import fr.uha.anis.services.SupplierService;

@Controller
public class SupplierController {
	@Autowired
	private SupplierService supplierService;
	@Autowired
	private CountryService countryService;
	@Autowired
	private StateService stateService;

	@GetMapping("/suppliers")
	public String getSuppliers(Model model) {
		List<Supplier> suppliers = supplierService.getSuppliers();
		model.addAttribute("suppliers", suppliers);

		List<State> states = stateService.getStates();
		model.addAttribute("states", states);

		List<Country> countries = countryService.getCountries();
		model.addAttribute("countries", countries);
		return "suppliers";
	}

	@PostMapping("/addsupplier")

	public String addCountry(Supplier supplier) {
		supplierService.save(supplier);
		return "redirect:/suppliers";
	}

	@RequestMapping("/supplier/{id}")
	public String findById(@PathVariable("id") int id, Model model) {
		List<Supplier> suppliers = supplierService.getSuppliers();
		model.addAttribute("suppliers", suppliers);

		List<State> states = stateService.getStates();
		model.addAttribute("states", states);

		List<Country> countries = countryService.getCountries();
		model.addAttribute("countries", countries);

		Supplier supplier = supplierService.findById(id).get();
		model.addAttribute("supplier", supplier);
		return "editSupplier";
	}

	@PostMapping("/updatesupplier/{id}")
	public String updateCountry(@PathVariable("id") long id, @Validated Supplier supplier, BindingResult result,
			Model model) {

		supplierService.save(supplier);
		return "redirect:/suppliers";
	}
	
	@GetMapping("/deletesupplier/{id}")
	@Transactional
	public String deleteCountry(@PathVariable("id") int id)
	{
		supplierService.delete(id);
		return  "redirect:/suppliers";
	}
}
