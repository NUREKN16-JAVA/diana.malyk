
package nure.itkn.malyk.usermanagement.db;

import java.util.Collection;
import java.util.Date;

import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.XmlDataSet;

import junit.framework.TestCase;
import nure.itkn.malyk.usermanagement.User;

/**
 * @author Diana
 *
 */
public class HsqldbUserDaoTest extends DatabaseTestCase {
	private HsqldbUserDao dao;
	private ConnectionFactory connectionFactory;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
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
			user.setDateOfBirth(new java.util.Date());
			assertNull(user.getId());
			user = dao.create(user);
			assertNotNull(user);
			assertNotNull(user.getId());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}
	public void testFindAll() {
		try {
			Collection findAll = dao.findAll();
			assertNotNull("Collection is null", findAll);
			assertEquals("Collection size", 2, findAll.size());
		} catch (DatabaseException e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}
	@Override
	protected IDatabaseConnection getConnection() throws Exception {
		connectionFactory = new ConnectionFactoryImpl("org.hsqldb.jdbcDriver", 
				"jdbc:hsqldb:file:db/usermanagement", "sa", "");
		return new DatabaseConnection(connectionFactory.createConnection());
	}
	@Override
	protected IDataSet getDataSet() throws Exception {
		IDataSet dataSet = new XmlDataSet(getClass().getClassLoader().getResourceAsStream("usersDataSet.xml"));
		return dataSet;
	}

}
