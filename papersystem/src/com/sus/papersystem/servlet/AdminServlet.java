package com.sus.papersystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sus.papersystem.beans.Admin;
import com.sus.papersystem.beans.Teacher;
import com.sus.papersystem.beans.Paper;
import com.sus.papersystem.beans.User;
import com.sus.papersystem.dao.AdminDao;
import com.sus.papersystem.dao.TeacherDao;
import com.sus.papersystem.dao.PaperDao;
import com.sus.papersystem.dao.UserDao;
import com.sus.papersystem.dao.impl.AdminDaoImpl;
import com.sus.papersystem.dao.impl.TeacherDaoImpl;
import com.sus.papersystem.dao.impl.PaperDaoImpl;
import com.sus.papersystem.dao.impl.UserDaoImpl;
import com.sus.papersystem.utility.MD5;

@WebServlet("/admin/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 699433544864966126L;
	private AdminDao adminDao = new AdminDaoImpl();
	private UserDao userDao = new UserDaoImpl();
	private TeacherDao teacherDao = new TeacherDaoImpl();
	private PaperDao paperDao = new PaperDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String method = request.getParameter("method");
		if (method == null || method.trim().equals("")) {
			return;
		}
		if("login".equals(method)) {
			login(request,response);
			return;
		}
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if(admin==null) {
			request.setAttribute("message", "你还没有登录………");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
			return;
		}
		switch (method) {
		case "logout":
			logout(request,response);
			break;
		case "teacherlist":
			teacherlist(request,response);
			break;
		case "userlist":
			userlist(request,response);
			break;
		case "index":
			index(request,response);
			break;
		case "addteacher":
			addteacher(request,response);
			break;
		default:
			break;
		}
	}
	
	private void addteacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if(admin==null) {
			request.setAttribute("message", "你还没有登录");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
			return;
		}
		String xm = request.getParameter("xm");
		String mm = request.getParameter("mm");
		String xy = request.getParameter("xy");
		if(xm==null||xm.trim().equals("")) {
			request.setAttribute("message", "请输入姓名");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
			return;
		}
		if(mm==null||mm.trim().equals("")) {
			request.setAttribute("message", "请输入密码");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
			return;
		}
		if(xy==null||xy.trim().equals("")) {
			request.setAttribute("message", "请输入学院");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
			return;
		}
		Teacher teacher = teacherDao.getByXm(xm);
		if(teacher!=null) {
			request.setAttribute("message", "姓名已被使用，请输入其他姓名");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
			return;
		}
		teacher = new Teacher(-1,xm,mm,xy);
		teacher.setMm(MD5.getMD5(teacher.getMm()));
		try {
			teacherDao.add(teacher);
			response.sendRedirect(request.getContextPath()+"/admin/AdminServlet?method=teacherlist");
			return;
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "添加失败");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
			return;
		}
	}

	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if(admin==null) {
			request.setAttribute("message", "你还没有登录");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
			return;
		}
		List<Paper> paperList = paperDao.getList(0, 9999);
		request.getSession().setAttribute("paperList", paperList);
		request.getRequestDispatcher("/jsp/admin/index.jsp").forward(request, response);
		return;
	}

	private void teacherlist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Teacher> teacherList = teacherDao.getAll();
		request.setAttribute("teacherList", teacherList);
		request.getRequestDispatcher("/jsp/admin/teacherlist.jsp").forward(request, response);
		return;
	}

	private void userlist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> userList = userDao.getList(0, 9999);
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("/jsp/admin/userlist.jsp").forward(request, response);
		return;
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().removeAttribute("admin");
		response.sendRedirect(request.getContextPath()+"/jsp/admin/login.jsp");
		return;
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String xm = request.getParameter("xm");
		String mm = request.getParameter("mm");
		if(xm==null) {
			request.setAttribute("message", "请输入管理员姓名");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
			return;
		}
		if(mm==null||mm.trim().equals("")) {
			request.setAttribute("message", "请输入密码");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
			return;
		}
		Admin admin = adminDao.getByXmAndMm(xm, MD5.getMD5(mm));
		if(admin==null) {
			request.setAttribute("message", "管理员姓名或者密码输入错误");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
			return;
		}
		request.getSession().setAttribute("admin", admin);
		response.sendRedirect(request.getContextPath()+"/admin/AdminServlet?method=index");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
