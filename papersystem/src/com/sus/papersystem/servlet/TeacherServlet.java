package com.sus.papersystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sus.papersystem.beans.Paper;
import com.sus.papersystem.beans.Teacher;
import com.sus.papersystem.dao.PaperDao;
import com.sus.papersystem.dao.TeacherDao;
import com.sus.papersystem.dao.impl.PaperDaoImpl;
import com.sus.papersystem.dao.impl.TeacherDaoImpl;
import com.sus.papersystem.utility.MD5;

@WebServlet("/teacher/TeacherServlet")
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = -7562322035472462136L;
	private TeacherDao teacherDao = new TeacherDaoImpl();
	private PaperDao paperDao = new PaperDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
		if(teacher==null) {
			request.setAttribute("teacher", "你还没有登录");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
			return;
		}
		switch (method) {
		case "logout":
			logout(request,response);
			break;
		case "index":
			index(request,response);
			break;
		case "addpaper":
			addpaper(request,response);
			break;
		case "deletepaper":
			deletepaper(request,response);
			break;
		case "viewpaper":
			viewpaper(request,response);
			break;
		default:
			break;
		}
	}

	private void viewpaper(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
		if(teacher==null) {
			request.setAttribute("message", "你还没有登录");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
			return;
		}
		int lwid = Integer.parseInt(request.getParameter("lwid"));
		Paper paper = paperDao.getById(lwid);
		request.setAttribute("paper", paper);
		request.getRequestDispatcher("/jsp/teacher/viewpaper.jsp").forward(request, response);
		return;
	}

	private void deletepaper(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
		if(teacher==null) {
			request.setAttribute("message", "你还没有登录");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
			return;
		}
		int lwid = Integer.parseInt(request.getParameter("lwid"));
		try {
			paperDao.delete(lwid);
			response.sendRedirect(request.getContextPath()+"/teacher/TeacherServlet?method=index");
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "删除失败");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
			return;
		}
	}

	private void addpaper(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
		if(teacher==null) {
			response.getOutputStream().write("{\"ok\":\"false\",\"msg\":\"你还没有登录\"}".getBytes(response.getCharacterEncoding()));
			return;
		}
		String nr = request.getParameter("nr");
		String lwtm = request.getParameter("lwtm");
		String gjc = request.getParameter("gjc");
		String zhy = request.getParameter("zhy");
		String xm = request.getParameter("xm");
		String xy = request.getParameter("xy");
		String zy = request.getParameter("zy");
		String jc = request.getParameter("jc");
		String zdls = request.getParameter("zdls");
		String jb = request.getParameter("jb");
		int jxmsid = teacher.getJxmsid();
		Paper paper = new Paper(-1,lwtm,gjc,zhy,xm,xy,zy,jc,zdls,jb,nr,jxmsid);
		paperDao.add(paper);
		response.getOutputStream().write("{\"ok\":\"true\",\"msg\":\"添加成功！\"}".getBytes(response.getCharacterEncoding()));
		return;
	}          

	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
		if(teacher==null) {
			request.setAttribute("message", "你还没有登录");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
			return;
		}
		List<Paper> paperList = paperDao.getListByTeacher(0, 9999, teacher.getJxmsid());
		request.getSession().setAttribute("paperList", paperList);
		request.getRequestDispatcher("/jsp/teacher/index.jsp").forward(request, response);
		return;
	}


	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().removeAttribute("teacher");
		response.sendRedirect(request.getContextPath()+"/jsp/teacher/login.jsp");
		return;
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String xm = request.getParameter("xm");
		String mm = request.getParameter("mm");
		if(xm==null||xm.trim().equals("")) {
			request.setAttribute("message", "请输入用户名");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
			return;
		}
		if(mm==null||mm.trim().equals("")) {
			request.setAttribute("message", "请输入密码");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
			return;
		}
		Teacher teacher = teacherDao.getByXmAndMm(xm, MD5.getMD5(mm));
		if(teacher==null) {
			request.setAttribute("message", "用户名或者密码输入错误");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
			return;
		}
		request.getSession().setAttribute("teacher", teacher);
		response.sendRedirect(request.getContextPath()+"/teacher/TeacherServlet?method=index");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
