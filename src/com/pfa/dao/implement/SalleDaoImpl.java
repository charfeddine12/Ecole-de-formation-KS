package com.pfa.dao.implement;

import com.pfa.dao.SalleDao;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pfa.model.Salle;
@Repository("salleDao")
@Transactional
public class SalleDaoImpl implements SalleDao{
	
		@Autowired
		private SessionFactory sessionFactory;
		
		public void addSalle(Salle salle) {
			Session session=sessionFactory.getCurrentSession();
			session.saveOrUpdate(salle);
			session.flush();
			
		}
		public void editSalle(Salle salle) {
			Session session=sessionFactory.getCurrentSession();
			session.saveOrUpdate(salle);
			session.flush();
			
		}

		public Salle getSalleById(int id) {
			Session session=sessionFactory.getCurrentSession();
			Salle salle=(Salle)session.get(Salle.class, id);
			session.flush();
			return salle;
		}

		
		public List<Salle> getAllSalles() {
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from Salle");
			List<Salle>salles=query.list();
			session.flush();
			return salles;
		}

		
		public void deleteSalle(int id) {
			Session session=sessionFactory.getCurrentSession();
			session.delete(getSalleById(id));
			session.flush();
			
		}
		
		

	}



