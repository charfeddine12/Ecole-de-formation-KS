package com.pfa.dao;

import java.util.List;

import com.pfa.model.Salle;

public interface SalleDao {
	

	void addSalle(Salle salle);
	Salle getSalleById(int id);
	List<Salle>getAllSalles();
	void deleteSalle(int id);
	void editSalle(Salle salle);

}
