package tn.esprit.spring.kaddem.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.kaddem.dto.DepartementDTO;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.services.IDepartementService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/departement")
public class DepartementRestController {
	IDepartementService departementService;
	// http://localhost:8089/Kaddem/departement/retrieve-all-departements
	@GetMapping("/retrieve-all-departements")
	public List<Departement> getDepartements() {
		return departementService.retrieveAllDepartements();
	}

	// http://localhost:8089/Kaddem/departement/retrieve-departement/8
	@GetMapping("/retrieve-departement/{departement-id}")
	public Departement retrieveDepartement(@PathVariable("departement-id") Integer departementId) {
		return departementService.retrieveDepartement(departementId);
	}

	// http://localhost:8089/Kaddem/departement/add-departement
	@PostMapping("/add-departement")
	public DepartementDTO addDepartement(@RequestBody DepartementDTO departementDTO) {
		// You can perform validation and business logic here before adding

		// If you need to create the entity (Departement), create an instance and set the values from DepartementDTO
		Departement departement = new Departement();
		departement.setNomDepart(departementDTO.getNomDepart());

		// Call the service to add the entity if needed

		// You can then convert the added entity to a DTO and return it if necessary
		DepartementDTO addedDTO = new DepartementDTO();
		addedDTO.setNomDepart(departement.getNomDepart());

		return addedDTO;
	}


	// http://localhost:8089/Kaddem/departement/remove-departement/1
	@DeleteMapping("/remove-departement/{departement-id}")
	public void removeDepartement(@PathVariable("departement-id") Integer departementId) {
		departementService.deleteDepartement(departementId);
	}

	// http://localhost:8089/Kaddem/departement/update-departement
	@PutMapping("/update-departement")
	public DepartementDTO updateDepartement(@RequestBody DepartementDTO departementDTO) {
		// You can perform validation and business logic here before updating

		// If you need to update the entity (Departement), create an instance and set the values from DepartementDTO
		Departement departement = new Departement(); // Corrected the variable name
		departement.setNomDepart(departementDTO.getNomDepart());

		// Call the service to update the entity if needed

		// You can then convert the updated entity to a DTO and return it if necessary
		DepartementDTO updatedDTO = new DepartementDTO();
		updatedDTO.setNomDepart(departement.getNomDepart());

		return updatedDTO;
	}
}


