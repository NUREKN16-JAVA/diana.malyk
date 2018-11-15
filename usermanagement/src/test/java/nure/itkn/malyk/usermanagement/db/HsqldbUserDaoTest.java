
package nure.itkn.malyk.usermanagement.db;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.dbunit.Assertion;
import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.ITableIterator;
import org.dbunit.dataset.filter.DefaultColumnFilter;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.XmlDataSet;

import junit.framework.TestCase;
import nure.itkn.malyk.usermanagement.User;

/**
 * @author Diana
 *
 */
public class HsqldbUserDaoTest extends DatabaseTestCase {
	private static final String USER_SURNAME = "Malyk";
	private static final String USER_NAME = "Diana";
	private static final String DATE_OF_BIRTH_ETALON = "18-12-1998";
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
			user.setFirstName(USER_NAME);
			user.setLastName(USER_SURNAME);
			user.setDateOfBirth(new SimpleDateFormat("dd-MM-yyyy").parse(DATE_OF_BIRTH_ETALON));
			assertNull(user.getId());
			user = dao.create(user);
			assertNotNull(user);
			assertNotNull(user.getId());
		} catch (ParseException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	/**
	 * Test method for {@link nure.itkn.malyk.usermanagement.db.
	 * HsqldbUserDao#findAll(nure.itkn.malyk.usermanagement.User)}.
	 */
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

	/**
	 * Test method for {@link nure.itkn.malyk.usermanagement.db.
	 * HsqldbUserDao#update(nure.itkn.malyk.usermanagement.User)}.
	 */
	public void testUpdate() {
		try {
			User user = new User();
			user.setFirstName(USER_NAME+"Update");
			user.setLastName(USER_SURNAME+"Update");
			user.setDateOfBirth(new SimpleDateFormat("dd-MM-yyyy").parse(DATE_OF_BIRTH_ETALON));
			user.setId(1000L);
			
			dao.update(user);
			
			IDataSet databaseDataSet = getConnection().createDataSet();
			ITable actualTable = databaseDataSet.getTable("USERS");
			IDataSet expectedDataSet = new XmlDataSet(getClass().getResourceAsStream("/usersUpdateDataSet.xml"));
			ITable expectedTable = expectedDataSet.getTable("USERS");
			Assertion.assertEquals(expectedTable, actualTable);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
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
