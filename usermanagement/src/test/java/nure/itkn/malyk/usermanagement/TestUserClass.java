package nure.itkn.malyk.usermanagement;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import junit.framework.TestCase;

public class TestUserClass extends TestCase {
	private static final String DATE_OF_BIRTH_ETALON = "18-12-1998";
	private static final Long ID_ETALON = Long.valueOf(1L);
	private static final String NAME_ETALON = "Иванов, Иван";
	private static final String LAST_NAME = "Иванов";
	private static final String FIRST_NAME = "Иван";
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
		user = new User(ID_ETALON, FIRST_NAME, LAST_NAME,
				new SimpleDateFormat("dd-MM-yyyy").parse(DATE_OF_BIRTH_ETALON));

	}

	public void testGetFullName() {
		assertEquals(NAME_ETALON, user.getFullName());
	}
	
	public void testGetAge_inFuture() {
		// 18.12.1998
		final int AGE = 19;
		assertEquals(AGE, user.getAge());
	}
	public void testGetAge_NewbornNow() {
		final int AGE = 0;
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new java.util.Date());
			user.setDateOfBirth(calendar.getTime());
			assertEquals(AGE, user.getAge());
		}  catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void testGetAge_AdultNow() {
		final int YEAR_OF_BIRTH = 1998;
		final int AGE = 20;
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new java.util.Date());
			calendar.set(Calendar.YEAR, YEAR_OF_BIRTH);
			user.setDateOfBirth(calendar.getTime());
			assertEquals(AGE, user.getAge());
		}  catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void testGetAge_AdultTommorow() {
		final int YEAR_OF_BIRTH = 1998;
		final int AGE = 19;
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new java.util.Date());
			calendar.set(Calendar.YEAR, YEAR_OF_BIRTH);
			calendar.add(Calendar.DATE, 1);
			user.setDateOfBirth(calendar.getTime());
			assertEquals(AGE, user.getAge());
		}  catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testGetAge_AdultYesterday() {
		final int YEAR_OF_BIRTH = 1998;
		final int AGE = 20;
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new java.util.Date());
			calendar.set(Calendar.YEAR, YEAR_OF_BIRTH);
			calendar.add(Calendar.DATE, -1);
			user.setDateOfBirth(calendar.getTime());
			assertEquals(AGE, user.getAge());
		}  catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
