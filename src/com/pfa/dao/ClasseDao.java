package com.pfa.dao;

import java.util.List;

import com.pfa.model.Classe;



public interface ClasseDao {

	void addClasse(Classe classe);
	Classe getClasseById(int id);
	List<Classe>getAllClasses();
	void deleteClasse(int id);
	void editClasse(Classe classe);
}
