package com.sus.papersystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sus.papersystem.beans.Paper;
import com.sus.papersystem.beans.User;
import com.sus.papersystem.dao.PaperDao;
import com.sus.papersystem.dao.UserDao;
import com.sus.papersystem.dao.impl.PaperDaoImpl;
import com.sus.papersystem.dao.impl.UserDaoImpl;
import com.sus.papersystem.utility.MD5;

@WebServlet("/user/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = -8112567064311676904L;
	private UserDao userDao = new UserDaoImpl();
	private PaperDao paperDao = new PaperDaoImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String method = request.getParameter("method");
		if (method == null || method.trim().equals("")) {
			return;
		}
		if("register".equals(method)) {
			register(request,response);
			return;
		}else if("login".equals(method)) {
			login(request,response);
			return;
		}
		User u = (User) request.getSession().getAttribute("user");
		if(u==null) {
			request.setAttribute("message", "你还没有登录");
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
		default:
			break;
		}
	}

	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if(user==null) {
			request.setAttribute("message", "你还没有登录");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
			return;
		}
		List<Paper> courseList = paperDao.getList(0, 9999);
		request.getSession().setAttribute("courseList", courseList);
		request.getRequestDispatcher("/jsp/user/index.jsp").forward(request, response);
		return;
	}


	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().removeAttribute("user");
		response.sendRedirect(request.getContextPath()+"/jsp/user/login.jsp");
		return;
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		User user = userDao.getByXmAndMm(xm,MD5.getMD5(mm));
		if(user==null) {
			request.setAttribute("message", "用户名或者密码输入错误");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
			return;
		}
		request.getSession().setAttribute("user", user);
		response.sendRedirect(request.getContextPath()+"/user/UserServlet?method=index");
		return;
	}

	private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = createUser(request);
		String errorMessage = null;
		errorMessage = validate(user);
		if(errorMessage==null) {
			user.setMm(MD5.getMD5(user.getMm()));
			userDao.add(user);
			request.setAttribute("message", "注册成功");
			request.setAttribute("user", user);
			request.getRequestDispatcher("/jsp/user/login.jsp").forward(request, response);
			return;
		}else {
			request.setAttribute("message", "注册失败:"+errorMessage);
			request.setAttribute("user", user);
			request.getRequestDispatcher("/jsp/user/register.jsp").forward(request, response);
			return;
		}
	}

	private String validate(User user) {
		if(user.getMm()==null||user.getMm().trim().equals("")) {
			return "密码不能为空";
		}
		if(user.getXm()==null||user.getXm().trim().equals("")) {
			return "用户名不能为空";
		}
		return null;
	}

	private User createUser(HttpServletRequest request) {
		int yhid = Integer.parseInt(request.getParameter("yhid"));
		String mm = request.getParameter("mm");;
		String xm = request.getParameter("xm");;
		String xy = request.getParameter("xy");;
		String zy = request.getParameter("zy");;
		String jc = request.getParameter("jc");;
		User user = new User(yhid,mm,xm,xy,zy,jc);
		return user;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
