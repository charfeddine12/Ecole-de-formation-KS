package com.pfa.dao;

import java.util.List;

import com.pfa.model.Professeur;

public interface ProfesseurDao {

	void addProfesseur(Professeur professeur);
	Professeur getProfesseurById(int id);
	List<Professeur>getAllProfesseurs();
	void deleteProfesseur(int id);
	void editProfesseur(Professeur professeur);
	
}
