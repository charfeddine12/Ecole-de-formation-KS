package com.pfa.dao;

import java.util.List;

import com.pfa.model.Eleve;

public interface EleveDao {

	void addEleve(Eleve eleve);
	Eleve getEleveById(int id);
	List<Eleve>getAllEleves();
	void deleteEleve(int id);
	void editEleve(Eleve eleve);
	
}