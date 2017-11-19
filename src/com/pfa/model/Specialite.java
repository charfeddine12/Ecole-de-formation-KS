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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="specialite")
public class Specialite implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idSpec")
	private int idSpec;
	
	@Column(name="libelleSpec")
	private String libelleSpec;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="specialite",fetch=FetchType.EAGER)
	@JsonIgnore
	private List<Professeur>proffeseurs=new ArrayList<Professeur>();
	
	public Specialite(){
		
	}

	public int getIdSpec() {
		return idSpec;
	}

	public void setIdSpec(int idSpec) {
		this.idSpec = idSpec;
	}

	public String getLibelleSpec() {
		return libelleSpec;
	}

	public void setLibelleSpec(String libelleSpec) {
		this.libelleSpec = libelleSpec;
	}

	public List<Professeur> getProffeseurs() {
		return proffeseurs;
	}

	public void setProffeseurs(List<Professeur> proffeseurs) {
		this.proffeseurs = proffeseurs;
	}

	
}
