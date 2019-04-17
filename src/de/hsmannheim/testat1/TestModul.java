package de.hsmannheim.testat1;

import java.nio.BufferUnderflowException;

/**
 * @author Jeremias Kunz, Daniel Reichel, Philipp Schick
 * @version 1.00, 15.04.2019
 * 
 *          Checks if there are defect Eggs on the {@link CheckRingBuffer}
 *
 */
public class TestModul implements Runnable {

	/**
	 * The buffer to work on
	 */
	private CheckRingBuffer buffer;

	/**
	 * Generates a new instance of TestModul and sets the buffer to work on
	 * 
	 * @param buffer The buffer to work on
	 */
	public TestModul(CheckRingBuffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		while (true) {
			try {
				buffer.checkEgg();
				Thread.sleep(50);
			} catch (InterruptedException | BufferUnderflowException e) {
				// Print StackTrace and continue
				e.printStackTrace();
			}
		}

	}

}
