package nure.itkn.malyk.usermanagement.db;
import java.util.Collection;

import nure.itkn.malyk.usermanagement.User;

public interface UserDao {
	/**
	 * Add new user to database
	 * @param user with null id
	 * @return user with generated id 
	 * @throws DatabaseException
	 */
	User create(final User user) throws DatabaseException;
	/**
	 * Update record in database where id = param:user.id, 
	 * @param user with updated values
	 * @throws DatabaseException
	 */
	void update(User user) throws DatabaseException;
	/**
	 * Delete user from database
	 * @param user for deleting
	 * @throws DatabaseException
	 */
	void delete(User user) throws DatabaseException;
	/**
	 * Find user in database
	 * @param id 
	 * @return User
	 * @throws DatabaseException
	 */
	User find(Long id) throws DatabaseException;
	Collection findAll() throws DatabaseException;
	
	void setConnectionFactory(ConnectionFactory connectionFactory) throws DatabaseException;
}
