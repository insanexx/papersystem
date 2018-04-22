package com.sus.papersystem.dao;

import java.util.List;

import com.sus.papersystem.beans.User;

public interface UserDao {
	public void add(User u);
	public void delete(int id);
	public void update(User u);
	public User getById(int id);
	public List<User> getList(int pageIndex,int pageSize);
	public User getByXmAndMm(String username, String password);
}
