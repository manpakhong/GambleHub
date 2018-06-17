package com.rabbitforever.gamblehub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rabbitforever.gamblehub.daos.UserDao;
import com.rabbitforever.gamblehub.models.eos.UserEo;
@Service
public class UserServiceImp implements UserService {

	   @Autowired
	   private UserDao userDao;
	 
	   @Transactional
	   public void save(UserEo userEo) {
	      userDao.save(userEo);
	   }
	 
	   @Transactional(readOnly = true)
	   public List<UserEo> list() {
	      return userDao.list();
	   }

}
