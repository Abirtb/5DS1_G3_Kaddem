package tn.esprit.spring.kaddem.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.kaddem.entities.Contrat;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.entities.Niveau;
import tn.esprit.spring.kaddem.repositories.EquipeRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@AllArgsConstructor
@Service
public class EquipeServiceImpl implements IEquipeService{
	EquipeRepository equipeRepository;


	public List<Equipe> retrieveAllEquipes(){
	return  (List<Equipe>) equipeRepository.findAll();
	}
	public Equipe addEquipe(Equipe e){
		return (equipeRepository.save(e));
	}

	public  void deleteEquipe(Integer idEquipe){
		Equipe e=retrieveEquipe(idEquipe);
		equipeRepository.delete(e);
	}

	public Equipe retrieveEquipe(Integer equipeId){
		Optional<Equipe> e = equipeRepository.findById(equipeId);
		if (e.isPresent()) {
			return e.get();
		}
		else return null;

	}

	public Equipe updateEquipe(Equipe e){
	return (	equipeRepository.save(e));
	}

	public void refactorMethod() {
		List<Equipe> equipes = (List<Equipe>) equipeRepository.findAll();

		for (Equipe equipe : equipes) {
			if (isJuniorOrSenior(equipe)) {
				int activeContractCount = countActiveContracts(equipe);

				if (activeContractCount >= 3) {
					updateTeamLevel(equipe);
				}
			}
		}
	}

	private boolean isJuniorOrSenior(Equipe equipe) {
		return equipe.getNiveau().equals(Niveau.JUNIOR) || equipe.getNiveau().equals(Niveau.SENIOR);
	}

	private int countActiveContracts(Equipe equipe) {
		int activeContractCount = 0;

		for (Etudiant etudiant : equipe.getEtudiants()) {
			Set<Contrat> contrats = etudiant.getContrats();

			for (Contrat contrat : contrats) {
				if (isActiveContract(contrat)) {
					activeContractCount++;
					break;
				}
			}

			if (activeContractCount >= 3) {
				break;
			}
		}

		return activeContractCount;
	}

	private boolean isActiveContract(Contrat contrat) {
		Date dateSysteme = new Date();
		long differenceInTime = dateSysteme.getTime() - contrat.getDateFinContrat().getTime();
		long differenceInYears = (differenceInTime / (1000l * 60 * 60 * 24 * 365));
		return !contrat.getArchive() && differenceInYears > 1;
	}

	private void updateTeamLevel(Equipe equipe) {
		if (equipe.getNiveau().equals(Niveau.JUNIOR)) {
			equipe.setNiveau(Niveau.SENIOR);
		} else if (equipe.getNiveau().equals(Niveau.SENIOR)) {
			equipe.setNiveau(Niveau.EXPERT);
		}

		equipeRepository.save(equipe);
	}

}
