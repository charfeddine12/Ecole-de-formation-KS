package com.pfa.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="professeur")
public class Professeur implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idProf")
	private int idProf;
	
	@Column(name="nomProf")
	private String nomProf;
	
	@Column(name="prenomProf")
	private String prenomProf;
	
	@Column(name="telProf")
	private int telProf;
	
	@Column(name="emailProf")
	private String emailProf;
	
	@Column(name="adresseProf")
	private String adresseProf;
	
	@Transient
	private MultipartFile imgProf;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="idSpec")
	private Specialite specialite;
	
	@OneToOne(mappedBy="professeur")
	private Matiere matiere;
	
	@OneToOne(mappedBy="professeur")
	private Classe classe;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(name="idSalle")
	private Salle salle;
	
	public Professeur(){
		
	}
	

	public MultipartFile getImgProf() {
		return imgProf;
	}


	public void setImgProf(MultipartFile imgProf) {
		this.imgProf = imgProf;
	}


	public int getIdProf() {
		return idProf;
	}

	public void setIdProf(int idProf) {
		this.idProf = idProf;
	}

	public String getNomProf() {
		return nomProf;
	}

	public void setNomProf(String nomProf) {
		this.nomProf = nomProf;
	}

	public String getPrenomProf() {
		return prenomProf;
	}

	public void setPrenomProf(String prenomProf) {
		this.prenomProf = prenomProf;
	}

	public int getTelProf() {
		return telProf;
	}

	public void setTelProf(int telProf) {
		this.telProf = telProf;
	}

	public String getEmailProf() {
		return emailProf;
	}

	public void setEmailProf(String emailProf) {
		this.emailProf = emailProf;
	}

	public String getAdresseProf() {
		return adresseProf;
	}

	public void setAdresseProf(String adresseProf) {
		this.adresseProf = adresseProf;
	}

	public Specialite getSpecialite() {
		return specialite;
	}

	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
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

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}
	
	
}
