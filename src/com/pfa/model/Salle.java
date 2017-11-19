package com.pfa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="salle")
public class Salle implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idSalle")
	private int idSalle;
	
	@Column(name="nomSalle")
	private String nomSalle;
	
	@Column(name="formeSalle")
	private String formeSalle;
	
	@OneToOne(mappedBy="salle")
	private Matiere matiere;
	
	@OneToOne(mappedBy="salle")
	private Classe classe;
	
	@OneToOne(mappedBy="salle")
	private Professeur professeur;
	
	public Salle(){
		
	}

	public int getIdSalle() {
		return idSalle;
	}

	public void setIdSalle(int idSalle) {
		this.idSalle = idSalle;
	}

	public String getNomSalle() {
		return nomSalle;
	}

	public void setNomSalle(String nomSalle) {
		this.nomSalle = nomSalle;
	}

	public String getFormeSalle() {
		return formeSalle;
	}

	public void setFormeSalle(String formeSalle) {
		this.formeSalle = formeSalle;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Professeur getProfesseur() {
		return professeur;
	}

	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}
	
	

}
