package fr.uha.anis.controllers;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.uha.anis.models.country.Country;
import fr.uha.anis.models.vehicule.VehicleStatus;
import fr.uha.anis.services.CountryService;
import fr.uha.anis.services.VehiculeStatusService;

@Controller
public class VehiculeStatusController {
	
	@Autowired
	private VehiculeStatusService vehiculeStatusService;
	
	@GetMapping("/vehiculestatus")
	public String getVehiculeStatus(Model model)
	{
		List<VehicleStatus> vehiculestatuss=vehiculeStatusService.getVehicleStatus();
		model.addAttribute("vehiculestatuss", vehiculestatuss);
		return "vehicule_status";
	}
	/*
	@PostMapping("/addcountry")
	
	public String addCountry(Country country)
	{
		System.out.println(country.toString());
		countryService.save(country);
		return "redirect:/countries";
	}
	
	@RequestMapping("/findbyid/{id}")
	public String findById(@PathVariable("id") int id, Model model)
	{
		
	 Country country=countryService.findById(id).get();
	 model.addAttribute("country", country);
	 return "editCountryForm";
	}
	
	@PostMapping("/updatecountry/{id}")
	public String updateCountry(@PathVariable("id") long id,@Validated Country country, 
			  BindingResult result, Model model)
	{
		
		countryService.save(country);
		return "redirect:/countries";
	}
	
	@GetMapping("/deletecountry/{id}")
	@Transactional
	public String deleteCountry(@PathVariable("id") int id)
	{
		countryService.delete(id);
		return  "redirect:/countries";
	}
	*/
}
