package com.society.repository;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.society.model.jpa.RoleJPA;
import com.society.model.jpa.SocietyUserAccessRightsJPA;
import com.society.model.jpa.UserJPA;

@Repository
public class SocietyUserRepository extends BaseRepository {
	
	public boolean insertSocietyUserDeatils(UserJPA user, List<SocietyUserAccessRightsJPA> rightList) {
		
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			RoleJPA role = session.load(RoleJPA.class, new Integer(3));
			user.setRole(role);
			session.persist(user);
			
			for(SocietyUserAccessRightsJPA accessRights : rightList) {
				session.persist(accessRights);
			}
			
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
