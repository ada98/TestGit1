

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
	
	public TestUser() {
		super();
	}

		
}
