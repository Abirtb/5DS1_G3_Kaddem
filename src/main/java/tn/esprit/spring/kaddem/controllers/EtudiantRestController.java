package tn.esprit.spring.kaddem.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.kaddem.dto.EtudiantDTO;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.services.IEtudiantService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantRestController {
	@Autowired
	IEtudiantService etudiantService;
	// http://localhost:8089/Kaddem/etudiant/retrieve-all-etudiants
	@GetMapping("/retrieve-all-etudiants")
	public List<Etudiant> getEtudiants() {
		return etudiantService.retrieveAllEtudiants();
	}

	// http://localhost:8089/Kaddem/etudiant/retrieve-etudiant/8
	@GetMapping("/retrieve-etudiant/{etudiant-id}")
	public Etudiant retrieveEtudiant(@PathVariable("etudiant-id") Integer etudiantId) {
		return etudiantService.retrieveEtudiant(etudiantId);
	}

	// http://localhost:8089/Kaddem/etudiant/add-etudiant
	@PostMapping("/add-etudiant")
	public EtudiantDTO addEtudiant(@RequestBody EtudiantDTO etudiantDTO) {
		// You can perform validation and business logic here before adding.

		// If you need to create the entity (Etudiant), create an instance and set the values from EtudiantDTO.
		Etudiant etudiant = new Etudiant();
		etudiant.setNomE(etudiantDTO.getNomE());
		etudiant.setPrenomE(etudiantDTO.getPrenomE());
		etudiant.setOp(etudiantDTO.getOp());

		// Call the service to add the entity if needed.
		etudiantService.addEtudiant(etudiant);

		// You can then convert the added entity to an EtudiantDTO and return it if necessary.
		EtudiantDTO addedDTO = new EtudiantDTO();
		addedDTO.setNomE(etudiant.getNomE());
		addedDTO.setPrenomE(etudiant.getPrenomE());
		addedDTO.setOp(etudiant.getOp());

		return addedDTO;
	}


	// http://localhost:8089/Kaddem/etudiant/remove-etudiant/1
	@DeleteMapping("/remove-etudiant/{etudiant-id}")
	public void removeEtudiant(@PathVariable("etudiant-id") Integer etudiantId) {
		etudiantService.removeEtudiant(etudiantId);
	}

	// http://localhost:8089/Kaddem/etudiant/update-etudiant
	@PutMapping("/update-etudiant")
	public EtudiantDTO updateEtudiant(@RequestBody EtudiantDTO etudiantDTO) {
		Etudiant etudiant = new Etudiant();
		etudiant.setNomE(etudiantDTO.getNomE());
		etudiant.setPrenomE(etudiantDTO.getPrenomE());
		etudiant.setOp(etudiantDTO.getOp());

		etudiant = etudiantService.updateEtudiant(etudiant);

		EtudiantDTO updatedDTO = new EtudiantDTO();
		updatedDTO.setNomE(etudiant.getNomE());
		updatedDTO.setPrenomE(etudiant.getPrenomE());
		updatedDTO.setOp(etudiant.getOp());

		return updatedDTO;
	}


	//@PutMapping("/affecter-etudiant-departement")
	@PutMapping(value="/affecter-etudiant-departement/{etudiantId}/{departementId}")
	public void affecterEtudiantToDepartement(@PathVariable("etudiantId") Integer etudiantId, @PathVariable("departementId")Integer departementId){
		etudiantService.assignEtudiantToDepartement(etudiantId, departementId);
    }
//addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe)
    /* Ajouter un étudiant tout en lui affectant un contrat et une équipe */
@PostMapping("/add-assign-Etudiant/{idContrat}/{idEquipe}")
@ResponseBody
public EtudiantDTO addEtudiantWithEquipeAndContract(@RequestBody EtudiantDTO etudiantDTO, @PathVariable("idContrat") Integer idContrat, @PathVariable("idEquipe") Integer idEquipe) {
	// Convert EtudiantDTO to Etudiant entity
	Etudiant etudiant = new Etudiant();
	etudiant.setNomE(etudiantDTO.getNomE());
	etudiant.setPrenomE(etudiantDTO.getPrenomE());
	etudiant.setOp(etudiantDTO.getOp());

	// Call the service method to add and assign Etudiant to Equipe and Contrat
	etudiant = etudiantService.addAndAssignEtudiantToEquipeAndContract(etudiant, idContrat, idEquipe);

	// Convert the resulting Etudiant entity back to EtudiantDTO
	EtudiantDTO updatedDTO = new EtudiantDTO();
	updatedDTO.setNomE(etudiant.getNomE());
	updatedDTO.setPrenomE(etudiant.getPrenomE());
	updatedDTO.setOp(etudiant.getOp());

	return updatedDTO;
}


	@GetMapping(value = "/getEtudiantsByDepartement/{idDepartement}")
	public List<Etudiant> getEtudiantsParDepartement(@PathVariable("idDepartement") Integer idDepartement) {

		return etudiantService.getEtudiantsByDepartement(idDepartement);
	}

}


