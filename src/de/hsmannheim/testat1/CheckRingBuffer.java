/**
 * 
 */
package de.hsmannheim.testat1;

import java.nio.BufferUnderflowException;

import uebung1a.Ei;

/**
 * @author Jeremias Kunz, Daniel Reichel, Philipp Schick
 * @version 1.00, 15.04.2019
 *
 *          A Ring Buffer for Eggs, it's possible to sorts out defect Eggs. All
 *          Methods should be Thread save
 */
public class CheckRingBuffer {
	/**
	 * Keeps the Eggs
	 */
	private Ei[] buffer = new Ei[50];

	/**
	 * The Output-Position of the Buffer
	 */
	private int outPointer;

	/**
	 * The Input-Position of the Buffer
	 */
	private int inPointer;

	/**
	 * The current Check Position
	 */
	private int checkPosition;

	/**
	 * Adds a new Egg to the Buffer
	 * 
	 * @param input The Egg to put in the Buffer
	 */
	public void enqueue(Ei input) {
		// TODO Auto-generated method stub
	}

	/**
	 * Returns a Egg from the Buffer
	 * @throws BufferUnderflowException if there is no Egg to return
	 * 
	 * @return A Egg
	 */
	public Ei dequeue() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Checks the Egg on the Check-Position, if it's defect it will return false and
	 * deletes the Egg
	 * 
	 * @throws BufferUnderflowException if there isn't a Egg to Check
	 * 
	 * @return true if the Egg isn't defect
	 */
	public boolean checkEgg() {
		// TODO Auto-generated method stub
		return false;
	}

}
