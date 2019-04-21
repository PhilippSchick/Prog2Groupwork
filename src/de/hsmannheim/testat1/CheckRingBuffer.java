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
	private int outPointer = 1;

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
	 * @throws BufferOverflowException if no space is left in the Buffer
	 * @param input The Egg to put in the Buffer
	 */
	public void enqueue(Ei input) throws BufferOverflowException {
		if (inPointer == outPointer) {
			throw new BufferOverflowException();
		}
		buffer[inPointer] = input;
		inPointer = this.decStep(inPointer);
		System.out.println("Egg add to Buffer");
	}

	/**
	 * Returns a Egg from the Buffer
	 * 
	 * @throws BufferUnderflowException if there is no Egg to return
	 * @return A Egg
	 */
	public synchronized Ei dequeue() throws BufferUnderflowException {
		Ei ret;

		do {
			ret = buffer[outPointer];

			// do a step if the next Position isn't the checkPosition
			int nextPos = decStep(outPointer);
			if (nextPos == checkPosition) {
				// if you can't step to the next position and the current is null throw a
				// Exception
				if (ret == null) {
					throw new BufferUnderflowException();
				}
			} else {
				outPointer = nextPos;
			}
		} while (ret == null);

		// Delete the returned Egg
		buffer[(outPointer + 1) % buffer.length] = null;
		System.out.println("Egg dequeued");
		return ret;
	}

	/**
	 * Checks the Egg on the Check-Position, if it's defect it will return false and
	 * deletes the Egg
	 * 
	 * @throws BufferUnderflowException if there isn't a Egg to Check
	 * @return true if the Egg isn't defect
	 */
	public synchronized boolean checkEgg() throws BufferUnderflowException {

		if (checkPosition == inPointer) {
			// No item to Check
			throw new BufferUnderflowException();
		}

		if (buffer[checkPosition].getDefekt()) {

			// Delete Egg
			buffer[checkPosition] = null;
			checkPosition = this.decStep(checkPosition);

			System.out.println("Egg Checked: Deleted Egg");

			return false;
		} else {
			System.out.println("Egg Checked");
			return true;
		}
	}

	/**
	 * Does a decrementing step on the Buffer
	 * 
	 * @param pos The current Position
	 * @return The next Position
	 */
	private int decStep(int pos) {
		return (--pos) < 0 ? buffer.length - 1 : pos;
	}

}
