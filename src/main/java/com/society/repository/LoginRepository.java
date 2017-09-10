package com.society.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.society.model.jpa.UserJPA;

@Repository
public class LoginRepository extends BaseRepository {
	
	public UserJPA validateLogin(UserJPA userJPA) {
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<UserJPA> criteriaQuery = criteriaBuilder.createQuery(UserJPA.class);
		Root<UserJPA> root = criteriaQuery.from(UserJPA.class);
		criteriaQuery.select(root);
		
		Predicate userNamePredicate = criteriaBuilder.equal(root.<String> get("userName"), userJPA.getUserName());
		Predicate userPasswordPredicate = criteriaBuilder.equal(root.<String> get("userPassword"), userJPA.getUserPassword());
		
		Predicate andPredicate = criteriaBuilder.and(userNamePredicate, userPasswordPredicate);
		
		criteriaQuery.where(andPredicate);
	
		return entityManager.createQuery(criteriaQuery).getSingleResult();
	}
}
