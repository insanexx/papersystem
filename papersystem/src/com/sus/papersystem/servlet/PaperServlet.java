package com.sus.papersystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sus.papersystem.beans.Teacher;
import com.sus.papersystem.beans.Paper;
import com.sus.papersystem.dao.PaperDao;
import com.sus.papersystem.dao.impl.PaperDaoImpl;

@WebServlet("/paper/PaperServlet")
public class PaperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PaperDao paperDao = new PaperDaoImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
		if(teacher==null) {
			request.setAttribute("message", "你还没有登录");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
			return;
		}
		String method = request.getParameter("method");
		if (method == null || method.trim().equals("")) {
			return;
		}
		switch (method) {
		case "addpaper":
			addpaper(request,response);
			break;
		case "deletepaper":
			deletepaper(request,response);
			break;
		case "index":
			index(request,response);
			break;
		default:
			break;
		}
	}
	
	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
		List<Paper> paperList = paperDao.getListByTeacher(0, 9999, teacher.getJxmsid());
		request.getSession().setAttribute("courseList", paperList);
		response.sendRedirect(request.getServletContext().getContextPath()+"/jsp/teacher/index.jsp");
		return;
	}

	private void deletepaper(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			int id = Integer.parseInt(request.getParameter("paperid"));
			paperDao.delete(id);
			index(request, response);
			return;
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "删除失败");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
			return;
		}
	}

	private void addpaper(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
			Paper paper = null;
			paper = createPaper(request,teacher);
			int paperid = paperDao.add(paper);
			paper.setLwid(paperid);
			response.sendRedirect(request.getContextPath()+"/teacher/TeacherServlet?method=index");
			return;
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "添加失败");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
			return;
		}
	}

	private Paper createPaper(HttpServletRequest request,Teacher teacher) {
		String lwtm = request.getParameter("lwtm");
		String gjc = request.getParameter("gjc");
		String zhy = request.getParameter("zhy");
		String xm = request.getParameter("xm");
		String xy = request.getParameter("xy");
		String zy = request.getParameter("zy");
		String jc = request.getParameter("jc");
		String zdls = request.getParameter("zdls");
		String jb = request.getParameter("jb");
		String nr = request.getParameter("nr");
		Paper paper = new Paper(-1, lwtm, gjc, zhy, xm, xy, zy, jc, zdls, jb, nr,teacher.getJxmsid());
		return paper;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
