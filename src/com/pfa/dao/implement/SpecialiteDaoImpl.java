package com.pfa.dao.implement;

import com.pfa.dao.SpecialiteDao;
import com.pfa.model.Specialite;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository("specialiteDao")
@Transactional
public class SpecialiteDaoImpl implements SpecialiteDao {

		@Autowired
		private SessionFactory sessionFactory;
		
		

		public void addSpecialite(Specialite specialite) {
			Session session=sessionFactory.getCurrentSession();
			session.saveOrUpdate(specialite);
			session.flush();
			
		}
		public void editSpecialite(Specialite specialite) {
			Session session=sessionFactory.getCurrentSession();
			session.saveOrUpdate(specialite);
			session.flush();
			
		}

		public Specialite getSpecialiteById(int id) {
			Session session=sessionFactory.getCurrentSession();
			Specialite specialite=(Specialite)session.get(Specialite.class, id);
			session.flush();
			return specialite;
		}

		
		public List<Specialite> getAllSpecialites() {
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from Specialite");
			List<Specialite>specialites=query.list();
			session.flush();
			return specialites;
		}

		
		public void deleteSpecialite(int id) {
			Session session=sessionFactory.getCurrentSession();
			session.delete(getSpecialiteById(id));
			session.flush();
			
		}

	}
