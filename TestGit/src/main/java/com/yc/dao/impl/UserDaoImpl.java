package com.yc.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yc.bean.User;
import com.yc.dao.UserDao;

public class UserDaoImpl implements UserDao {

	@Override
	public User isUser(User user) {
		SqlSession session=null;
		try {
			session=MyBatisHelper.getSession();
			User u=session.selectOne(User.class.getName()+".selectUser" , user);
			return u;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(session!=null){
				session.close();
			}
		}
		return null;
	}

}
