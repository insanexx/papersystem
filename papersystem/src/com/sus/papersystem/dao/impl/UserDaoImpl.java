package com.sus.papersystem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sus.papersystem.beans.User;
import com.sus.papersystem.dao.UserDao;
import com.sus.papersystem.utility.DBConnectionManager;

public class UserDaoImpl implements UserDao {

	@Override
	public void add(User u) {
		String sql = "insert into user(xm,mm,xy,zy,jc) values(?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DBConnectionManager.getJDBCConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, u.getXm());
			pst.setString(2, u.getMm());
			pst.setString(3, u.getXy());
			pst.setString(4, u.getZy());
			pst.setString(5, u.getJc());
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
	public void delete(int id) {
		String sql = "delete from user where yhid=?";
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DBConnectionManager.getJDBCConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
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
	public void update(User u) {
		String sql = "update user set mm=?,xm=?,xy=?,zy=?,jc=?  where yhid=?";
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DBConnectionManager.getJDBCConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, u.getMm());
			
			pst.setString(2, u.getXm());
			pst.setString(3, u.getXy());
			pst.setString(4, u.getZy());
			pst.setString(5, u.getJc());
			pst.setInt(6, u.getYhid());
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
	public User getById(int yhid) {
		User u = null;
		String sql = "select * from user where yhid=?";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		conn = DBConnectionManager.getJDBCConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, yhid);
			rs = pst.executeQuery();
			if(rs.next()) {
				u = new User();
				u.setJc(rs.getString("jc"));
				u.setMm(rs.getString("mm"));
				u.setXm(rs.getString("xm"));
				u.setXy(rs.getString("xy"));
				u.setYhid(yhid);
				u.setZy(rs.getString("zy"));
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
		return u;
	}

	@Override
	public List<User> getList(int pageIndex, int pageSize) {
		List<User> list = new ArrayList<User>();
		String sql = "select * from user limit ?,?";
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
				User u = new User();
				u.setJc(rs.getString("jc"));
				u.setMm(rs.getString("mm"));
				u.setXm(rs.getString("xm"));
				u.setXy(rs.getString("xy"));
				u.setYhid(rs.getInt("yhid"));
				u.setZy(rs.getString("zy"));
				list.add(u);
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
	public User getByXmAndMm(String xm, String mm) {
		User u = null;
		String sql = "select * from user where xm=? and mm=?";
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
				u = new User();
				u.setJc(rs.getString("jc"));
				u.setMm(rs.getString("mm"));
				u.setXm(rs.getString("xm"));
				u.setXy(rs.getString("xy"));
				u.setYhid(rs.getInt("yhid"));
				u.setZy(rs.getString("zy"));
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
		return u;
	}

}
