package com.sus.papersystem.dao;

import java.util.List;

import com.sus.papersystem.beans.Admin;

public interface AdminDao {
	public void add(Admin a);
	public void delete(int id);
	public void update(Admin a);
	public Admin getById(int id);
	public List<Admin> getAll();
	public Admin getByXmAndMm(String xm, String password);
}
