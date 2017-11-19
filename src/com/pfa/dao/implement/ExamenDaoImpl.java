package com.pfa.dao.implement;

import com.pfa.dao.ExamenDao;
import com.pfa.model.Examen;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository("examenDao")
@Transactional
public class ExamenDaoImpl implements ExamenDao{
		@Autowired
		private SessionFactory sessionFactory;
		
		

		public void addExamen(Examen examen) {
			Session session=sessionFactory.getCurrentSession();
			session.saveOrUpdate(examen);
			session.flush();
			
		}
		public void editExamen(Examen examen) {
			Session session=sessionFactory.getCurrentSession();
			session.saveOrUpdate(examen);
			session.flush();
			
		}

		public Examen getExamenById(int id) {
			Session session=sessionFactory.getCurrentSession();
			Examen examen=(Examen)session.get(Examen.class, id);
			session.flush();
			return examen;
		}

		
		public List<Examen> getAllExamens() {
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from Examen");
			List<Examen>examens=query.list();
			session.flush();
			return examens;
		}

		
		public void deleteExamen(int id) {
			Session session=sessionFactory.getCurrentSession();
			session.delete(getExamenById(id));
			session.flush();
			
		}
		
		

	}

