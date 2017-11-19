package com.pfa.dao.implement;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pfa.dao.ProfesseurDao;
import com.pfa.model.Professeur;

@Repository("professeurDao")
@Transactional
public class ProfesseurDaoImpl implements ProfesseurDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	

	public void addProfesseur(Professeur professeur) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(professeur);
		session.flush();
		
	}
	public void editProfesseur(Professeur professeur) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(professeur);
		session.flush();
		
	}

	public Professeur getProfesseurById(int id) {
		Session session=sessionFactory.getCurrentSession();
		Professeur prof=(Professeur)session.get(Professeur.class, id);
		session.flush();
		return prof;
	}

	
	public List<Professeur> getAllProfesseurs() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Professeur");
		List<Professeur>professeurs=query.list();
		session.flush();
		return professeurs;
	}

	
	public void deleteProfesseur(int id) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(getProfesseurById(id));
		session.flush();
		
	}
	
	

}
