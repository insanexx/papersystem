package com.sus.papersystem.dao;

import java.util.List;

import com.sus.papersystem.beans.Paper;

public interface PaperDao {
	public int add(Paper paper);
	public void delete(int id);
	public void update(Paper paper);
	public Paper getById(int id);
	public List<Paper> getList(int pageIndex, int pageSize);
	public List<Paper> getListByTeacher(int pageIndex, int pageSize,int jxmsid);
	public List<Paper> query(String lwtm, String gjc, String jc, String zy,int pageIndex, int pageSize);
	
}
