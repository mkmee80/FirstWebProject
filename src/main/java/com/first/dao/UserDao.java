package com.first.dao;

import java.util.List;

import com.first.model.User;

public interface UserDao {

	public List<User> list();

	public void adduser(User user);
}
