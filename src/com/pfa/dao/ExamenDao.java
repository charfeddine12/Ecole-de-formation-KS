package com.pfa.dao;

import java.util.List;

import com.pfa.model.Examen;

public interface ExamenDao {


	void addExamen(Examen examen);
	Examen getExamenById(int id);
	List<Examen>getAllExamens();
	void deleteExamen(int id);
	void editExamen(Examen examen);
}
