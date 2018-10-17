package nure.itkn.malyk.usermanagement;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import junit.framework.TestCase;

public class TestUserClass extends TestCase {
	private User user;
	
	public TestUserClass() {
	  super();
	  try {
	    setUp();
	  } catch (Exception e) {
	    e.printStackTrace();
	  }
	}

	protected void setUp() throws Exception {
		super.setUp();
		user = new User(Long.valueOf(1L), "Иван", "Иванов", new SimpleDateFormat("dd-MM-yyyy").parse("18-12-1998"));
		
	}
	
	
	public void testGetFullName() {
	  assertEquals("Иванов, Иван", user.getFullName());
	}
	

	
	public void testGetAge() {
	  boolean isThrown = false;
	  try {
	    //18.12.1998
	    assertEquals(19, user.getAge());
	    
	    Calendar calendar = Calendar.getInstance();
	    
      calendar.setTime(new java.util.Date());
	    user.setDateOfBirth(calendar.getTime());
	    assertEquals(0, user.getAge());
	    
	    calendar.add(Calendar.DATE, 1);
      user.setDateOfBirth(calendar.getTime());
      user.getAge();
	    
      calendar.setTime(new java.util.Date());
      calendar.set(Calendar.YEAR, 1998);
      user.setDateOfBirth(calendar.getTime());
      assertEquals(20, user.getAge());
      
      calendar.add(Calendar.DATE, 1);
      user.setDateOfBirth(calendar.getTime());
      assertEquals(19, user.getAge());
      
      calendar.add(Calendar.DATE, -2);
      user.setDateOfBirth(calendar.getTime());
      assertEquals(20, user.getAge());
      
	  } catch(IllegalArgumentException ex) {
	    isThrown = true;
	    }
	    catch(Exception e) {
	      e.printStackTrace();
	    }
	  assertTrue(isThrown);
	 }
}
