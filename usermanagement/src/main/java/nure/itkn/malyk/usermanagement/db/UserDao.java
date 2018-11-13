package nure.itkn.malyk.usermanagement.db;
import java.util.Collection;

import nure.itkn.malyk.usermanagement.User;

public interface UserDao {
	User create(User user) throws DatabaseException;
	void update(User user) throws DatabaseException;
	void delete(User user) throws DatabaseException;
	User find(User user) throws DatabaseException;
	Collection findAll() throws DatabaseException;
	
	void setConnectionFactory(ConnectionFactory connectionFactory) throws DatabaseException;
}
