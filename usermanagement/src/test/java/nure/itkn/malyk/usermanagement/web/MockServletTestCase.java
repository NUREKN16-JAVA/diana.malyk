package nure.itkn.malyk.usermanagement.web;

import java.util.Properties;

import com.mockobjects.dynamic.Mock;
import com.mockrunner.servlet.BasicServletTestCaseAdapter;

import nure.itkn.malyk.usermanagement.db.DaoFactory;
import nure.itkn.malyk.usermanagement.db.MockDaoFactory;

public abstract class MockServletTestCase extends BasicServletTestCaseAdapter {
	
	private Mock mockUserDao;
	
	/**
	 * @return the mockUserDao
	 */
	public Mock getMockUserDao() {
		return mockUserDao;
	}

	/**
	 * @param mockUserDao the mockUserDao to set
	 */
	public void setMockUserDao(Mock mockUDao) {
		this.mockUserDao = mockUDao;
	}

	protected void setUp() throws Exception {
		super.setUp();
		Properties properties = new Properties();
		properties.setProperty("dao.factory", MockDaoFactory.class.getName());
		try {
			DaoFactory.init(properties);
		} catch (Exception e) {
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		setMockUserDao(((MockDaoFactory) DaoFactory.getInstance()).getMockUserDao());
	}

	protected void tearDown() throws Exception {
		getMockUserDao().verify();
		super.tearDown();
	}

}
