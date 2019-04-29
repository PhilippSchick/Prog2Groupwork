package de.hsmannheim.ArcheProject;

import java.util.LinkedList;

/**
 * @author Jeremias Kunz, Daniel Reichel, Philipp Schick
 *
 *         A Queue for instances of {@link Tier}
 */
public class AnimalQueue extends LinkedList<Tier> {

	public AnimalQueue() {

	}

	/**
	 * All {@link Vogel} will be removed from the Queue
	 * 
	 * @return the number of {@link Vogel} flown away
	 */
	public int sturm() {
		return -1;
		// TODO Auto-generated method stub
	}

	/**
	 * Every {@link Tier} with the characteristic raubtier will eat (remove) the
	 * {@link Tier} on the next position in the queue, except the next {@link Tier}
	 * has the characteristics raubtier or giftig
	 * 
	 * @return the number of Animals eaten
	 */
	public int grossesFressen() {
		return -1;
		// TODO Auto-generated method stub
	}

	/**
	 * Prints a representation of the queue on the Console
	 */
	public void printWarteschlange() {
		// TODO Auto-generated method stub
	}

}
