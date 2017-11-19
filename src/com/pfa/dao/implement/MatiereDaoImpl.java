package com.pfa.dao.implement;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pfa.dao.MatiereDao;
import com.pfa.model.Matiere;

@Repository("matiereDao")
@Transactional
public class MatiereDaoImpl implements MatiereDao{

		@Autowired
		private SessionFactory sessionFactory;
		
		

		public void addMatiere(Matiere matiere) {
			Session session=sessionFactory.getCurrentSession();
			session.saveOrUpdate(matiere);
			session.flush();
			
		}
		public void editMatiere(Matiere matiere) {
			Session session=sessionFactory.getCurrentSession();
			session.saveOrUpdate(matiere);
			session.flush();
			
		}

		public Matiere getMatiereById(int id) {
			Session session=sessionFactory.getCurrentSession();
			Matiere matiere=(Matiere)session.get(Matiere.class, id);
			session.flush();
			return matiere;
		}

		
		public List<Matiere> getAllMatieres() {
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from Matiere");
			List<Matiere>matieres=query.list();
			session.flush();
			return matieres;
		}

		
		public void deleteMatiere(int id) {
			Session session=sessionFactory.getCurrentSession();
			session.delete(getMatiereById(id));
			session.flush();
			
		}
		
		

	}



