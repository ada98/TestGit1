package com.yc.web.servlets;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.yc.bean.Bean;
import com.yc.bean.User;
import com.yc.dao.UserDao;
import com.yc.dao.impl.UserDaoImpl;

@WebServlet("/user.action")
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private UserDao ud=new UserDaoImpl();
	protected void doPost(HttpServletRequest req, HttpServletResponse resp){
		try {
			if(op.equals("login")){
				login(req,resp);
			}else if(op.equals("findAll")){
				findAll(req,resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void findAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		List<User> list=ud.findAll();
		Gson gson=new Gson();
		Bean bean=new Bean();
		bean.setList(list);
		String jsonStr=gson.toJson(bean);
		super.outJsonStr(jsonStr, resp);
		
	}

	private void login(HttpServletRequest req, HttpServletResponse resp) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		User user=RequestUtil.getParemeter(req, User.class);
		
		User flag=ud.isUser(user);
		HttpSession session=req.getSession();
		if(flag!=null){
			session.setAttribute("user", flag);
			resp.sendRedirect("main.jsp");//要修改
		}else{
			resp.sendRedirect("index.jsp");
		}
	}
	
	
}
