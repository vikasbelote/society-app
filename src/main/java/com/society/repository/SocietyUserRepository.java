package com.society.repository;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class SocietyUserRepository extends BaseRepository {
	
	public boolean insertSocietyUserDeatils() {
		
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			session.getTransaction().commit();
			return true;
		}
		catch(Exception e) {
			if(session != null)
				session.getTransaction().rollback();
			return false;
		}
		finally {
			if(session != null)
				session.close();
		}
	}
}
