package projetjava.example.gestionEtudiants.Controllers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import projetjava.example.gestionEtudiants.Models.Etudiant;
import projetjava.example.gestionEtudiants.Repository.EtudiantRepository;
import projetjava.example.gestionEtudiants.Services.EtudiantService;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping(value="/etudiant")
@AllArgsConstructor
@NoArgsConstructor
public class EtudiantController {

	
	@Autowired
	EtudiantService etudiantService;
	@Autowired
	EtudiantRepository etudiantRepository;

	@GetMapping("/formEtudiant")
	public String formEtudiant(Model model){
		model.addAttribute("etudiant", new Etudiant());
		return "formEtudiant";
	}

	@PostMapping("/saveEtudiant")
	public String saveEtudiant(Model model, Etudiant etudiant){
		etudiantService.saveEtudiant(etudiant);

		/*List<Etudiant> etudiants = etudiantService.EtudiantList();
		model.addAttribute("etudiant", etudiants);*/
		model.addAttribute("successMessage", "Etudiant inséré avec succès");
		return "formEtudiant";
	}

	@GetMapping("/editer/{id}")
	public String editerEtudiant(@PathVariable("id") Long id, Model model){
		Optional<Etudiant> etudiant = etudiantService.getEtudiant(id);
		model.addAttribute("etudiant", etudiant);
		return "updateEtudiant";
	}

	@PostMapping("/update")
	public String updateEtudiant(Etudiant etudiant, Model model) {
		Optional<Etudiant> etudiantResult = etudiantService.getEtudiant(etudiant.getId());
		if (etudiantResult.isPresent()) {
			Etudiant etudiantToUpdate = etudiantResult.get();
			etudiantToUpdate.setNom(etudiant.getNom());
			etudiantToUpdate.setPrenom(etudiant.getPrenom());
			etudiantToUpdate.setEmail(etudiant.getEmail());
			etudiantToUpdate.setDateNaissance(etudiant.getDateNaissance());
			etudiantService.saveEtudiant(etudiantToUpdate);
		}

		List<Etudiant> etudiants = etudiantService.EtudiantList();
		model.addAttribute("etudiant", etudiants);
		model.addAttribute("successMessage", "Etudiant update avec succès");

		return "etudiants";
	}

	@GetMapping("/delete/{id}")
	public String deleteEtudiant(@PathVariable("id") Long id, Model model){
		etudiantService.deleteEtudiant(id);
		List<Etudiant> etudiants = etudiantService.EtudiantList();
		model.addAttribute("etudiant", etudiants);
		model.addAttribute("messageSucces", "Etudiant supprimer avec succès!!!");
		return "etudiants";
	}

	@GetMapping("/")
	public String index(Model model){
		List<Etudiant> etudiants = etudiantService.EtudiantList();
		model.addAttribute("etudiant", etudiants);
		return "etudiants";
	}

	/*@PostMapping("/recherche")
	public String rechercheEtudiant(String motCle, Model model){
		Etudiant etudiant = (Etudiant) etudiantRepository.findByMc(motCle);
		model.addAttribute("etudiant", etudiant);
		return "etudiants";
	}*/
	
}
