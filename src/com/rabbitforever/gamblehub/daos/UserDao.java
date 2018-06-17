package com.rabbitforever.gamblehub.daos;

import java.util.List;

import com.rabbitforever.gamblehub.models.eos.UserEo;

public interface UserDao {
	public void save(UserEo userEo);
	public List<UserEo> list();
}
