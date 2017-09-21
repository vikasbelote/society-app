package com.society.repository;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
				accessRights.getAccessRightsId().setUserId(user.getUserId());
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
	
	public List<UserJPA> getSocietyUserList(Integer societyId) {
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<UserJPA> criteriaQuery = criteriaBuilder.createQuery(UserJPA.class);
		Root<UserJPA> root = criteriaQuery.from(UserJPA.class);
		root.fetch("role", JoinType.INNER);
		root.fetch("society", JoinType.INNER);
		root.fetch("person", JoinType.INNER);
		criteriaQuery.select(root);
		
		Predicate societyIdPredicate = criteriaBuilder.equal(root.<Integer>get("society").get("societyId"), societyId);
		
		criteriaQuery.where(societyIdPredicate);
		
		List<UserJPA> userList;
		try {
			userList = entityManager.createQuery(criteriaQuery).getResultList();
		}
		catch(Exception e) {
			userList = null;
		}
		return userList;
	}
}
