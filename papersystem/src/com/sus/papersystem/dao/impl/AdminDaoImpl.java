package com.sus.papersystem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sus.papersystem.beans.Admin;
import com.sus.papersystem.dao.AdminDao;
import com.sus.papersystem.utility.DBConnectionManager;

public class AdminDaoImpl implements AdminDao {

	@Override
	public void add(Admin admin) {
		String sql = "insert into admin(xm,mm) values(?,?)";
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DBConnectionManager.getJDBCConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, admin.getXm());
			pst.setString(2, admin.getMm());
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
	public void delete(int glyid) {
		String sql = "delete from admin where glyid=?";
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DBConnectionManager.getJDBCConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, glyid);
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
	public void update(Admin admin) {
		String sql = "update admin set mm=? where glyid=?";
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DBConnectionManager.getJDBCConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, admin.getMm());
			pst.setInt(2, admin.getGlyid());
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
	public Admin getById(int glyid) {
		Admin a = null;
		String sql = "select * from admin where glyid=?";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		conn = DBConnectionManager.getJDBCConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, glyid);
			rs = pst.executeQuery();
			if(rs.next()) {
				a = new Admin();
				a.setGlyid(glyid);
				a.setMm(rs.getString("mm"));
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
		return a;
	}

	@Override
	public List<Admin> getAll() {
		List<Admin> list = new ArrayList<Admin>();
		String sql = "select * from admin";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		conn = DBConnectionManager.getJDBCConnection();
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				Admin a = new Admin();
				a.setGlyid(rs.getInt("glyid"));
				a.setMm(rs.getString("mm"));
				list.add(a);
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
	public Admin getByXmAndMm(String xm, String mm) {
		Admin a = null;
		String sql = "select * from admin where xm=? and mm=?";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		conn = DBConnectionManager.getJDBCConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1,xm);
			pst.setString(2, mm);
			rs = pst.executeQuery();
			if(rs.next()) {
				a = new Admin();
				a.setGlyid(rs.getInt("glyid"));
				a.setXm(xm);
				a.setMm(mm);
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
		return a;
	}

}
