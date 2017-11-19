package com.pfa.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="matiere")
public class Matiere implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idMat")
	private int idMat;
	
	@Column(name="nomMat")
	private String nomMat;
	
	@Column(name="coefMat")
	private float coefMat;
	
	@ManyToMany(cascade=CascadeType.ALL,mappedBy="matieres")
	private Set<Eleve>eleves=new HashSet<Eleve>();
	
	@OneToOne(cascade=CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(name="idSalle")
	private Salle salle;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(name="idCl")
	private Classe classe;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(name="idProf")
	private Professeur professeur;
	
	
	public Matiere(){
		
	}


	public int getIdMat() {
		return idMat;
	}


	public void setIdMat(int idMat) {
		this.idMat = idMat;
	}


	public String getNomMat() {
		return nomMat;
	}


	public void setNomMat(String nomMat) {
		this.nomMat = nomMat;
	}


	public float getCoefMat() {
		return coefMat;
	}
	


	public void setCoefMat(float coefMat) {
		this.coefMat = coefMat;
	}


	public Set<Eleve> getEleves() {
		return eleves;
	}


	public void setEleves(Set<Eleve> eleves) {
		this.eleves = eleves;
	}


	public Salle getSalle() {
		return salle;
	}


	public void setSalle(Salle salle) {
		this.salle = salle;
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
