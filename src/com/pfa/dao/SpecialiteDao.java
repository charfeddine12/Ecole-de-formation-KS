package com.pfa.dao;

import java.util.List;

import com.pfa.model.Specialite;

public interface SpecialiteDao {


	void addSpecialite(Specialite specialite);
	Specialite getSpecialiteById(int id);
	List<Specialite>getAllSpecialites();
	void deleteSpecialite(int id);
	void editSpecialite(Specialite specialite);
}
