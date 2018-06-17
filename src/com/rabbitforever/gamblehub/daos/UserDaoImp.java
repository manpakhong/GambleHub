package com.rabbitforever.gamblehub.daos;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rabbitforever.gamblehub.models.eos.UserEo;
@Repository
public class UserDaoImp implements UserDao {

	   @Autowired
	   private SessionFactory sessionFactory;
	 
	   @Override
	   public void save(UserEo userEo) {
	      sessionFactory.getCurrentSession().save(userEo);
	   }
	 
	   @Override
	   public List<UserEo> list() {
	      @SuppressWarnings("unchecked")
	      TypedQuery<UserEo> query = sessionFactory.getCurrentSession().createQuery("from User");
	      return query.getResultList();
	   }

}
