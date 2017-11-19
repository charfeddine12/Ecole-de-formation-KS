package com.pfa.dao.implement;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pfa.dao.ClasseDao;
import com.pfa.model.Classe;
@Repository("classeDao")
@Transactional
public class ClasseDaoImpl implements ClasseDao {

		@Autowired
		private SessionFactory sessionFactory;
		
		

		public void addClasse(Classe classe) {
			Session session=sessionFactory.getCurrentSession();
			session.saveOrUpdate(classe);
			session.flush();
			
		}
		public void editClasse(Classe classe) {
			Session session=sessionFactory.getCurrentSession();
			session.saveOrUpdate(classe);
			session.flush();
			
		}

		public Classe getClasseById(int id) {
			Session session=sessionFactory.getCurrentSession();
			Classe classe=(Classe)session.get(Classe.class, id);
			session.flush();
			return classe;
		}

		
		public List<Classe> getAllClasses() {
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from Classe");
			List<Classe>classes=query.list();
			session.flush();
			return classes;
		}

		
		public void deleteClasse(int id) {
			Session session=sessionFactory.getCurrentSession();
			session.delete(getClasseById(id));
			session.flush();
			
		}
		
		

	}



