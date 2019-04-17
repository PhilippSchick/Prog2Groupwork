/**
 * 
 */
package de.hsmannheim.testat1;

/**
 * @author Jeremias Kunz, Daniel Reichel, Philipp Schick
 * @version 1.00, 15.04.2019
 * 
 *          Checks if there are defect Eggs on the {@link CheckRingBuffer}
 *
 */
public class TestModul implements Runnable {
	//Creating a constructor with an object as a paramater
	private CheckRingBuffer buffer;
	public TestModul(CheckRingBuffer buffer ) {
		this.buffer = buffer ;
	}

	@Override
	public void run() {
		// TODO Exceptionhandling with BufferUnderFLowException ( checkEgg() ) 
		try {
			buffer.checkEgg();
			Thread.sleep(50);
		} catch (InterruptedException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
