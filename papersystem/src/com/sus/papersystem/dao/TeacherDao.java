package com.sus.papersystem.dao;

import java.util.List;

import com.sus.papersystem.beans.Teacher;

public interface TeacherDao {
	public void add(Teacher t);
	public void delete(int id);
	public void update(Teacher t);
	public Teacher getById(int id);
	public List<Teacher> getAll();
	public Teacher getByXmAndMm(String xm, String mm);
	public Teacher getByXm(String xm);
}
