package com.pfa.dao;

import java.util.List;

import com.pfa.model.Matiere;

public interface MatiereDao {


	void addMatiere(Matiere matiere);
	Matiere getMatiereById(int id);
	List<Matiere>getAllMatieres();
	void deleteMatiere(int id);
	void editMatiere(Matiere matiere);
}
