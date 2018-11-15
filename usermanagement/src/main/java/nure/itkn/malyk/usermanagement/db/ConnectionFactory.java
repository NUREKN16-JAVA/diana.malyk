package nure.itkn.malyk.usermanagement.db;

import java.sql.Connection;

public interface ConnectionFactory {
	/**
	 * Create connection to database
	 * @return connection to database
	 * @throws DatabaseException
	 */
	Connection createConnection() throws DatabaseException;
}
