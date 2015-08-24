package com.nath.dao;

import com.nath.model.User;

public interface IUserDao /*extends AbstractDAO*/{

	public User getUserByName(String userName) ;
}
