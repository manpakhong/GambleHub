package com.rabbitforever.gamblehub.services;

import java.util.List;

import com.rabbitforever.gamblehub.models.eos.UserEo;

public interface UserMgr {
	public void save(UserEo userEo);
	public List<UserEo> list();
}
