package projetjava.example.gestionEtudiants.Models;

import java.io.Serializable;
import java.util.Date;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Data
@Table(name = "Etudiant")
public class Etudiant implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Getter
	@Column(name = "nom")
	private String nom;
	@Getter
	@Column(name = "prenom")
	private String prenom;
	@Getter
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date dateNaissance;
 	@Getter
	@Column(name = "email")
	private String email;

	public Etudiant(Long id, String nom, String prenom, Date dateNaissance, String email) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.email = email;
	}

	public Etudiant(){

	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
