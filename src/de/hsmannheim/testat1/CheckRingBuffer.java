/**
 * 
 */
package de.hsmannheim.testat1;

import java.nio.BufferOverflowException;
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
	 * The Output-Position of the Buffer, points on the next Egg to return
	 */
	private int outPointer = 0;

	/**
	 * The Input-Position of the Buffer, points on the next free position
	 */
	private int inPointer = 0;

	/**
	 * The current Check Position
	 */
	private int checkPosition = 0;

	/**
	 * Adds a new Egg to the Buffer
	 * 
	 * @param input The Egg to put in the Buffer
	 */
	public void enqueue(Ei input) {
		if (inPointer == outPointer) {
			throw new BufferOverflowException();
		}
		buffer[inPointer] = input;
		stepInPointer();
	}

	/**
	 * Returns a Egg from the Buffer
	 * 
	 * @throws BufferUnderflowException if there is no Egg to return
	 * 
	 * @return A Egg
	 */
	public synchronized Ei dequeue() {
		Ei ret;

		do {
			if (outPointer == checkPosition) {
				throw new BufferUnderflowException();
			}
			ret = buffer[outPointer];
			outPointer = (--outPointer) < 0 ? buffer.length - 1 : outPointer;

		} while (ret == null);
		//Delete the returned Egg
		buffer[outPointer + 1] = null;
		return ret;
	}

	/**
	 * Checks the Egg on the Check-Position, if it's defect it will return false and
	 * deletes the Egg
	 * 
	 * @throws BufferUnderflowException if there isn't a Egg to Check
	 * 
	 * @return true if the Egg isn't defect
	 */
	public synchronized boolean checkEgg() {

		if (checkPosition == inPointer) {
			// No item to Check
			throw new BufferUnderflowException();
		}

		if (buffer[checkPosition].getDefekt()) {

			// Delete Egg
			buffer[checkPosition] = null;
			this.stepChecker();

			return false;
		} else {
			return true;
		}
	}

	/**
	 * The Checker makes a step on the buffer
	 */
	private synchronized void stepChecker() {
		checkPosition = ((--checkPosition) < 0 ? buffer.length - 1 : checkPosition);
	}
	
	/**
	 * The inPointer makes a step on the buffer
	 */
	private synchronized void stepInPointer() {
		inPointer = ((--inPointer) < 0 ? buffer.length - 1 : inPointer);
	}

}
