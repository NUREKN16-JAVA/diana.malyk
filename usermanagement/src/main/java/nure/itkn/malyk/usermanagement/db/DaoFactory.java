package nure.itkn.malyk.usermanagement.db;

import java.io.IOException;
import java.util.Properties;

public abstract class DaoFactory {
	
	protected static final String USER_DAO = "dao.nure.itkn.malyk.usermanagement.db.UserDao";
	private static final String DAO_FACTORY = "dao.factory";
	protected static Properties properties;
	
	
	private static DaoFactory instance;
	
	static {
		properties = new Properties();
		try {
			properties.load(DaoFactory.class.getClassLoader().getResourceAsStream("settings.properties"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * Create exactly one DaoFactory
	 * @return instance of DaoFactory
	 */
	public static synchronized DaoFactory getInstance() {
		if (instance == null) {
			Class factoryClass;
			try {
				factoryClass = Class.forName(properties
						.getProperty(DAO_FACTORY));
				instance = (DaoFactory) factoryClass.newInstance();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return instance;
	}
	
	protected DaoFactory() {}
	/**
	 * Initisliaze properties of object from param java.util.Properties
	 * @param properties
	 */
	public static void init(Properties prop) {
		properties = prop;
		instance = null;
	}
	protected ConnectionFactory getConnectionFactory() {
		return new ConnectionFactoryImpl(properties);
	}
	/**
	 * 
	 * @return UserDao 
	 */
	public abstract UserDao getUserDao();
}
