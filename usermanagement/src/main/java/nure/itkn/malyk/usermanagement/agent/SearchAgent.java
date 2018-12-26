package nure.itkn.malyk.usermanagement.agent;

import jade.core.Agent;

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

}
