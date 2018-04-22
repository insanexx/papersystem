package com.sus.papersystem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sus.papersystem.beans.Teacher;
import com.sus.papersystem.dao.TeacherDao;
import com.sus.papersystem.utility.DBConnectionManager;

public class TeacherDaoImpl implements TeacherDao {

	@Override
	public void add(Teacher teacher) {
		String sql = "insert into teacher(xm,mm,xy) values(?,?,?)";
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DBConnectionManager.getJDBCConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, teacher.getXm());
			pst.setString(2, teacher.getMm());
			pst.setString(3, teacher.getXy());
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
	public void delete(int jxmsid) {
		String sql = "delete from teacher where jxmsid=?";
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DBConnectionManager.getJDBCConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, jxmsid);
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
	public void update(Teacher teacher) {
		String sql = "update teacher set xm=?,mm=?,xy=? where jxmsid=?";
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DBConnectionManager.getJDBCConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1,teacher.getXm());
			pst.setString(2, teacher.getMm());
			pst.setString(3, teacher.getXy());
			pst.setInt(4, teacher.getJxmsid());
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
	public Teacher getById(int id) {
		Teacher teacher = null;
		String sql = "select * from teacher where jxmsid=?";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		conn = DBConnectionManager.getJDBCConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()) {
				teacher = new Teacher();
				teacher.setJxmsid(id);
				teacher.setMm(rs.getString("mm"));
				teacher.setXm(rs.getString("xm"));
				teacher.setXy(rs.getString("xy"));
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
		return teacher;
	}

	@Override
	public List<Teacher> getAll() {
		List<Teacher> list = new ArrayList<Teacher>();
		String sql = "select * from teacher";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		conn = DBConnectionManager.getJDBCConnection();
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				Teacher teacher = new Teacher();
				teacher.setJxmsid(rs.getInt("jxmsid"));
				teacher.setMm(rs.getString("mm"));
				teacher.setXm(rs.getString("xm"));
				teacher.setXy(rs.getString("xy"));
				list.add(teacher);
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
	public Teacher getByXmAndMm(String xm, String mm) {
		Teacher teacher = null;
		String sql = "select * from teacher where xm=? and mm=?";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		conn = DBConnectionManager.getJDBCConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, xm);
			pst.setString(2, mm);
			rs = pst.executeQuery();
			if(rs.next()) {
				teacher = new Teacher();
				teacher.setJxmsid(rs.getInt("jxmsid"));
				teacher.setMm(rs.getString("mm"));
				teacher.setXm(rs.getString("xm"));
				teacher.setXy(rs.getString("xy"));
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
		return teacher;
	}

	@Override
	public Teacher getByXm(String xm) {
		Teacher teacher = null;
		String sql = "select * from teacher where xm=?";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		conn = DBConnectionManager.getJDBCConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, xm);
			rs = pst.executeQuery();
			if(rs.next()) {
				teacher = new Teacher();
				teacher.setJxmsid(rs.getInt("jxmsid"));
				teacher.setMm(rs.getString("mm"));
				teacher.setXm(rs.getString("xm"));
				teacher.setXy(rs.getString("xy"));
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
		return teacher;
	}
}
