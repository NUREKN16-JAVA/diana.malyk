package nure.itkn.malyk.usermanagement.web;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import nure.itkn.malyk.usermanagement.User;

public class EditServletTest extends MockServletTestCase {

	protected void setUp() throws Exception {
		super.setUp();
		createServlet(EditServlet.class);
	}
	
	public void testEdit() {
		Date date = new Date();
		User user = new User(new Long(1000), "John", "Doe", date);
		getMockUserDao().expect("update", user);
		
		addRequestParameter("id", "1000");
		addRequestParameter("firstName", "John");
		addRequestParameter("lastName", "Doe");
		addRequestParameter("date", DateFormat.getDateInstance().format(date));
		addRequestParameter("okButton", "Ok");
		doPost();
	}
	
	public void  testEditEmptyFirstName() {
		Date date = new Date();
		addRequestParameter("id", "1000");
		addRequestParameter("lastName", "Doe");
		addRequestParameter("date", DateFormat.getDateInstance().format(date));
		addRequestParameter("okButton", "Ok");
		doPost();
		String errorMessage = (String) getWebMockObjectFactory().getMockRequest().getAttribute("error");
		assertNotNull("Could not find error message", errorMessage);
	}
	public void  testEditEmptyLastName() {
		Date date = new Date();
		addRequestParameter("id", "1000");
		addRequestParameter("firstName", "John");
		addRequestParameter("date", DateFormat.getDateInstance().format(date));
		addRequestParameter("okButton", "Ok");
		doPost();
		String errorMessage = (String) getWebMockObjectFactory().getMockRequest().getAttribute("error");
		assertNotNull("Could not find error message", errorMessage);
	}
	public void  testEditEmptyDate() {
		addRequestParameter("id", "1000");
		addRequestParameter("firstName", "John");
		addRequestParameter("lastName", "Doe");
		addRequestParameter("okButton", "Ok");
		doPost();
		String errorMessage = (String) getWebMockObjectFactory().getMockRequest().getAttribute("error");
		assertNotNull("Could not find error message", errorMessage);
	}
	public void testEditInvalidDate() {
		addRequestParameter("id", "1000");
		addRequestParameter("firstName", "John");
		addRequestParameter("lastName", "Doe");
		addRequestParameter("date", "sometext");
		addRequestParameter("okButton", "Ok");
		doPost();
		String errorMessage = (String) getWebMockObjectFactory().getMockRequest().getAttribute("error");
		assertNotNull("Could not find error message", errorMessage);
	}
}
