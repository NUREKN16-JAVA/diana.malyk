/**
 * 
 */
package nure.itkn.malyk.usermanagement.db;

import java.util.Date;

import junit.framework.TestCase;
import nure.itkn.malyk.usermanagement.User;

/**
 * @author Diana
 *
 */
public class HsqldbUserDaoTest extends TestCase {
	private HsqldbUserDao dao;
	private ConnectionFactory connectionFactory;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		connectionFactory = new ConnectionFactoryImpl();
		dao = new HsqldbUserDao(connectionFactory);
	}
	/**
	 * Test method for {@link nure.itkn.malyk.usermanagement.db.HsqldbUserDao#create(nure.itkn.malyk.usermanagement.User)}.
	 */
	public void testCreate() {
		try {
			User user = new User();
			user.setFirstName("Diana");
			user.setLastName("Malyk");
			user.setDateOfBirth(new Date());
			assertNull(user.getId());
			user = dao.create(user);
			assertNotNull(user);
			assertNotNull(user.getId());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

}
