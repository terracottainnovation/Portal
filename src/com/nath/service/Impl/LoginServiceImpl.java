package com.nath.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.nath.dao.IUserDao;
import com.nath.model.User;
import com.nath.service.ILoginService;

public class LoginServiceImpl implements ILoginService {

	@Autowired
	@Qualifier("userDao")
	IUserDao userDao;		
	
	@Override
	public User getUser(String userName) {
		return userDao.getUserByName(userName);
	}

}
