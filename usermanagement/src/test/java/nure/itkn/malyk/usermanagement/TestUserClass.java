package nure.itkn.malyk.usermanagement;

import java.text.SimpleDateFormat;

import junit.framework.TestCase;

class TestUserClass extends TestCase {
	private User user;

	protected void setUp() throws Exception {
		super.setUp();
		user = new User(1L, "Иван", "Иванов", new SimpleDateFormat("d-MMM-yyyy").parse("29-Apr-2018"));
	}

}
