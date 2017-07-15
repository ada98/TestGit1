

import java.util.List;

import com.yc.bean.User;
import com.yc.dao.UserDao;
import com.yc.dao.impl.UserDaoImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestUser extends TestCase {
	public static Test suite(){
		return new TestSuite(TestUser.class);
	}
	

	public TestUser(String name) {
		
		super(name);
	}
	
	public void TestUser() {
		UserDao ud=new UserDaoImpl();
		List<User> list=ud.findAll();
		for(User user:list){
			System.out.println(user);
		}
		
	}

		
}
