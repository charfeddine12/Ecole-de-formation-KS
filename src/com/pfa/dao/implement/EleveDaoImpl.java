package com.pfa.dao.implement;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pfa.dao.EleveDao;
import com.pfa.model.Eleve;

@Repository("eleveDao")
@Transactional
public class EleveDaoImpl implements EleveDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	

	public void addEleve(Eleve eleve) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(eleve);
		session.flush();
		
	}
	public void editEleve(Eleve eleve) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(eleve);
		session.flush();
		
	}

	public Eleve getEleveById(int id) {
		Session session=sessionFactory.getCurrentSession();
		Eleve eleve=(Eleve)session.get(Eleve.class, id);
		session.flush();
		return eleve;
	}

	
	public List<Eleve> getAllEleves() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Eleve");
		List<Eleve>eleves=query.list();
		session.flush();
		return eleves;
	}

	
	public void deleteEleve(int id) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(getEleveById(id));
		session.flush();
		
	}
	
	

}
