package fr.uha.anis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.uha.anis.models.vehicule.VehicleModel;
import fr.uha.anis.models.vehicule.Vehicule;
import fr.uha.anis.services.VehiculeModelService;
import fr.uha.anis.services.VehiculeService;

@Controller
public class VehiculeController {

	@Autowired
	private VehiculeService vehiculeService;
	
	@GetMapping("/vehicules")
	public String getVehicules(Model model)
	{
		List<Vehicule> vehicules=vehiculeService.getVehicules();
		model.addAttribute("vehicules", vehicules);
		return "vehicules";
	}
}
