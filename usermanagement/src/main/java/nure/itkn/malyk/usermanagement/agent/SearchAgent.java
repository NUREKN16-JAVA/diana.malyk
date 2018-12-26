package nure.itkn.malyk.usermanagement.agent;

import java.util.Collection;

import jade.core.Agent;
import nure.itkn.malyk.usermanagement.db.DaoFactory;
import nure.itkn.malyk.usermanagement.db.DatabaseException;

public class SearchAgent extends Agent {

	/* (non-Javadoc)
	 * @see jade.core.Agent#setup()
	 */
	@Override
	protected void setup() {
		super.setup();
		System.out.println(getAID().getName() + " started");
	}

	/* (non-Javadoc)
	 * @see jade.core.Agent#takeDown()
	 */
	@Override
	protected void takeDown() {
		System.out.println(getAID().getName() + " terminate");
		super.takeDown();
	}

	public void search(String firstName, String lastName) throws SearchException {
		try {
			Collection users = DaoFactory.getInstance().getUserDao().find(firstName, lastName);
			if(users.size() > 0) {
				showUsers(users);
			} else {
				
			}
			
		} catch (DatabaseException e) {
			throw new SearchException(e);
		}
	}
	
	public void showUsers(Collection users) {
		
	}
}
