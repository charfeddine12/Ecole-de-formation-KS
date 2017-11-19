package com.pfa.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;




import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="classe")
public class Classe implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idCl")
	private int idCl;
	
	@Column(name="nomCl")
	private String nomCl;
	
	@Column(name="niveauCl")
	private String niveauCl;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="classe",fetch=FetchType.EAGER)
	@JsonIgnore
	private List<Eleve>eleves=new ArrayList<Eleve>();
	
	@OneToOne(mappedBy="classe")
	private Matiere matiere;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(name="idSalle")
	private Salle salle;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(name="idProf")
	private Professeur professeur;
	
	public Classe(){
		
	}

	public int getIdCl() {
		return idCl;
	}

	public void setIdCl(int idCl) {
		this.idCl = idCl;
	}

	public String getNomCl() {
		return nomCl;
	}

	public void setNomCl(String nomCl) {
		this.nomCl = nomCl;
	}

	public String getNiveauCl() {
		return niveauCl;
	}

	public void setNiveauCl(String niveauCl) {
		this.niveauCl = niveauCl;
	}

	public List<Eleve> getEleves() {
		return eleves;
	}

	public void setEleves(List<Eleve> eleves) {
		this.eleves = eleves;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public Professeur getProfesseur() {
		return professeur;
	}

	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}
	

	
}
