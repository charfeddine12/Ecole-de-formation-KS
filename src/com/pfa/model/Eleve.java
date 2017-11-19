package com.pfa.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="eleve")
public class Eleve implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="matricule")
	private int matricule;
	
	@Column(name="nomEl")
	private String nomEl;
	
	@Column(name="prenomEl")
	private String prenomEl;
	
	@Column(name="telEl")
	private Long telEl;
	
	@Column(name="emailEl")
	private String emailEl;
	
	@Column(name="adresseEl")
	private String adresseEl;
	
	@Transient
	private MultipartFile imgEl;
	
	@ManyToOne
	@JoinColumn(name="idCl")
	@JsonIgnore
	private Classe classe;
	
	 
	@ManyToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinTable(name="examen",joinColumns=@JoinColumn(name="matricule"),
	inverseJoinColumns=@JoinColumn(name="idMat"))
	private Set<Matiere>matieres=new HashSet<Matiere>();
	
	public Eleve(){
		
	}
	

	public MultipartFile getImgEl() {
		return imgEl;
	}


	public void setImgEl(MultipartFile imgEl) {
		this.imgEl = imgEl;
	}


	public int getMatricule() {
		return matricule;
	}

	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}

	public String getNomEl() {
		return nomEl;
	}

	public void setNomEl(String nomEl) {
		this.nomEl = nomEl;
	}

	public String getPrenomEl() {
		return prenomEl;
	}

	public void setPrenomEl(String prenomEl) {
		this.prenomEl = prenomEl;
	}

	public Long getTelEl() {
		return telEl;
	}

	public void setTelEl(Long telEl) {
		this.telEl = telEl;
	}

	public String getEmailEl() {
		return emailEl;
	}

	public void setEmailEl(String emailEl) {
		this.emailEl = emailEl;
	}

	public String getAdresseEl() {
		return adresseEl;
	}

	public void setAdresseEl(String adresseEl) {
		this.adresseEl = adresseEl;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Set<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(Set<Matiere> matieres) {
		this.matieres = matieres;
	}
	
	
}
