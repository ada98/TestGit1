package com.yc.web.servlets;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yc.bean.User;
import com.yc.dao.UserDao;
import com.yc.dao.impl.UserDaoImpl;

@WebServlet("/user.action")
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp){
		try {
			if(op.equals("login")){
				login(req,resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void login(HttpServletRequest req, HttpServletResponse resp) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		User user=RequestUtil.getParemeter(req, User.class);
		UserDao ud=new UserDaoImpl();
		User flag=ud.isUser(user);
		HttpSession session=req.getSession();
		System.out.println(1111);
		if(flag!=null){
			session.setAttribute("user", flag);
			resp.sendRedirect("main.jsp");//要修改
		}else{
			resp.sendRedirect("index.jsp");
		}
	}
	
	
}
