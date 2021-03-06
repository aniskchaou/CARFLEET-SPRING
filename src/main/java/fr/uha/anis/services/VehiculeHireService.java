package fr.uha.anis.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import fr.uha.anis.models.country.Country;
import fr.uha.anis.models.person.JobTitle;
import fr.uha.anis.models.vehicule.VehicleModel;
import fr.uha.anis.models.vehicule.VehiculeHire;
import fr.uha.anis.repositories.CountryRepository;
import fr.uha.anis.repositories.JobTitleRepository;
import fr.uha.anis.repositories.LocationRepository;
import fr.uha.anis.repositories.StateRepository;
import fr.uha.anis.repositories.VehiculeHireRepository;
import fr.uha.anis.repositories.VehiculeModelRepository;

@Service
public class VehiculeHireService {

	@Autowired
	private VehiculeHireRepository vehiculeHireRepository;
	

	
	public List<VehiculeHire> getVehiculeHires()
	{
		return vehiculeHireRepository.findAll();
	}
	
	public void save(VehiculeHire hire)
	{
		vehiculeHireRepository.save(hire);
	}
	/*
	public Optional<Country> findById(int id)
	{
		return countryRepository.findById(id);
	}
	
	public void delete(int id)
	{
		
		countryRepository.delete(countryRepository.getOne(id));
		
	}
*/

	public  Optional<VehiculeHire> findById(int id) {
		// TODO Auto-generated method stub
		return vehiculeHireRepository.findById(id);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		vehiculeHireRepository.delete(vehiculeHireRepository.findById(id).get());
	}
}
