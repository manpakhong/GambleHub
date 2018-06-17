package com.rabbitforever.gamblehub.daos;


import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rabbitforever.gamblehub.models.eos.UserEo;
@Repository
public class UserDaoImp implements UserDao {

	   @Autowired
	   private SessionFactory sessionFactory;
	 
	   @Override
	   public void save(UserEo userEo) {
		      Session session  = sessionFactory.getCurrentSession();
		      Transaction transaction = session.getTransaction();
		      transaction.begin();
		      userEo.setStatus("active");
		      userEo.setEnabled(true);
		      userEo.setCreatedBy("admin");
		      userEo.setCreateDate(new Date());
		      userEo.setUpdatedBy("admin");
		      userEo.setUpdateDate(new Date());
		      session.save(userEo);
	      transaction.commit();
	   }
	 
	   @Override
	   public List<UserEo> list() {
	      @SuppressWarnings("unchecked")
	      List<UserEo> userEoList = null;
	      Session session  = sessionFactory.getCurrentSession();
	      Transaction transaction = session.getTransaction();
	      transaction.begin();
	      TypedQuery<UserEo> query = session.createQuery("from UserEo");
	      userEoList = query.getResultList();
	      transaction.commit();
	      return userEoList;
	   }

}
