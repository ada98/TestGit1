package com.yc.dao;

import java.util.List;

import com.yc.bean.User;

public interface UserDao {
	public User isUser(User user);

	public List<User> findAll();
}
