package fr.uha.anis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.uha.anis.models.client.Client;
import fr.uha.anis.models.person.Employee;
import fr.uha.anis.services.ClientService;
import fr.uha.anis.services.EmployeeService;
@Controller
public class ClientController {
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/clients")
	public String getClients(Model model)
	{
		List<Client> clients=clientService.getClients();
		model.addAttribute("clients", clients);
		return "clients";
	}
}
