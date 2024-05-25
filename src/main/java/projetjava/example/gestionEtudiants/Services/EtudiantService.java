package projetjava.example.gestionEtudiants.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetjava.example.gestionEtudiants.Models.Etudiant;
import projetjava.example.gestionEtudiants.Repository.EtudiantRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService {
    // auto injection et résolution des dépendances
    @Autowired
    EtudiantRepository etudiantRepository;

    // creation d'un étudiant
    public  void saveEtudiant(Etudiant etudiant){
          etudiantRepository.save(etudiant);
    }

    // recupération des étudiants
    public List<Etudiant> EtudiantList(){
        return etudiantRepository.findAll();
    }

    // recuperation d'un étudant particulier
    public Optional<Etudiant> getEtudiant(Long id){
        return etudiantRepository.findById(id);
    }

    public Optional<Etudiant> udateEtudiant(Long id){
        return etudiantRepository.findById(id);
    }

    public  void deleteEtudiant(Long id){
         etudiantRepository.deleteById(id);
    }


}
