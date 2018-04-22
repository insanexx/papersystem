package com.sus.papersystem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sus.papersystem.beans.Paper;
import com.sus.papersystem.dao.PaperDao;
import com.sus.papersystem.utility.DBConnectionManager;

public class PaperDaoImpl implements PaperDao {

	@Override
	public int add(Paper paper) {
		String sql = "insert into paper(lwtm,gjc,zhy,xm,xy,zy,jc,zdls,jb,nr,jxmsid) values(?,?,?,?,?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DBConnectionManager.getJDBCConnection();
		try {
			pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, paper.getLwtm());
			pst.setString(2, paper.getGjc());
			pst.setString(3, paper.getZhy());
			pst.setString(4, paper.getXm());
			pst.setString(5, paper.getXy());
			pst.setString(6, paper.getZy());
			pst.setString(7, paper.getJc());
			pst.setString(8, paper.getZdls());
			pst.setString(9, paper.getJb());
			pst.setString(10, paper.getNr());
			pst.setInt(11, paper.getJxmsid());
			pst.executeUpdate();
			ResultSet rs2 = pst.getGeneratedKeys();
			if(rs2.next()) {
				return rs2.getInt(1);
			}
			return -1;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally{
			if(pst!=null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	

	@Override
	public void delete(int lwid) {
		String sql = "delete from paper where lwid=?";
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DBConnectionManager.getJDBCConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, lwid);
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally{
			if(pst!=null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void update(Paper paper) {
		String sql = "update paper set lwtm=?,gjc=?,zhy=?,xm=?,xy=?,zy=?,jc=?,zdls=?,jb=?,nr=?  where lwid=?";
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DBConnectionManager.getJDBCConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, paper.getLwtm());
			pst.setString(2, paper.getGjc());
			pst.setString(3, paper.getZhy());
			pst.setString(4, paper.getXm());
			pst.setString(5, paper.getXy());
			pst.setString(6, paper.getZy());
			pst.setString(7, paper.getJc());
			pst.setString(8, paper.getZdls());
			pst.setString(9, paper.getJb());
			pst.setString(10, paper.getNr());
			pst.setInt(11, paper.getLwid());
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally{
			if(pst!=null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public Paper getById(int lwid) {
		Paper paper = null;
		String sql = "select * from paper where lwid=?";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		conn = DBConnectionManager.getJDBCConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, lwid);
			rs = pst.executeQuery();
			if(rs.next()) {
				paper = new Paper();
				paper.setGjc(rs.getString("gjc"));
				paper.setJb(rs.getString("jb"));
				paper.setJc(rs.getString("jc"));
				paper.setLwid(lwid);
				paper.setLwtm(rs.getString("lwtm"));
				paper.setNr(rs.getString("nr"));
				paper.setXm(rs.getString("xm"));
				paper.setXy(rs.getString("xy"));
				paper.setZdls(rs.getString("zdls"));
				paper.setZhy(rs.getString("zhy"));
				paper.setZy(rs.getString("zy"));
				paper.setJxmsid(rs.getInt("jxmsid"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pst!=null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return paper;
	}



	@Override
	public List<Paper> getList(int pageIndex, int pageSize) {
		List<Paper> list = new ArrayList<Paper>();
		String sql = "select * from paper limit ?,?";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		conn = DBConnectionManager.getJDBCConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, pageIndex);
			pst.setInt(2, pageSize);
			rs = pst.executeQuery();
			while(rs.next()) {
				Paper paper = new Paper();
				paper.setGjc(rs.getString("gjc"));
				paper.setJb(rs.getString("jb"));
				paper.setJc(rs.getString("jc"));
				paper.setLwid(rs.getInt("lwid"));
				paper.setLwtm(rs.getString("lwtm"));
				paper.setNr(rs.getString("nr"));
				paper.setXm(rs.getString("xm"));
				paper.setXy(rs.getString("xy"));
				paper.setZdls(rs.getString("zdls"));
				paper.setZhy(rs.getString("zhy"));
				paper.setZy(rs.getString("zy"));
				paper.setJxmsid(rs.getInt("jxmsid"));
				list.add(paper);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pst!=null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}


	@Override
	public List<Paper> getListByTeacher(int pageIndex, int pageSize, int jxmsid) {
		List<Paper> list = new ArrayList<Paper>();
		String sql = "select * from paper where jxmsid=? limit ?,?";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		conn = DBConnectionManager.getJDBCConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, jxmsid);
			pst.setInt(2, pageIndex);
			pst.setInt(3, pageSize);
			rs = pst.executeQuery();
			while(rs.next()) {
				Paper paper = new Paper();
				paper.setGjc(rs.getString("gjc"));
				paper.setJb(rs.getString("jb"));
				paper.setJc(rs.getString("jc"));
				paper.setLwid(rs.getInt("lwid"));
				paper.setLwtm(rs.getString("lwtm"));
				paper.setNr(rs.getString("nr"));
				paper.setXm(rs.getString("xm"));
				paper.setXy(rs.getString("xy"));
				paper.setZdls(rs.getString("zdls"));
				paper.setZhy(rs.getString("zhy"));
				paper.setZy(rs.getString("zy"));
				paper.setJxmsid(rs.getInt("jxmsid"));
				list.add(paper);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pst!=null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
	
}
