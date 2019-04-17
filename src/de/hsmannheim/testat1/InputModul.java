/**
 * 
 */
package de.hsmannheim.testat1;

/**
 * @author Jeremias Kunz, Daniel Reichel, Philipp Schick
 * @version 1.00, 15.04.2019
 * 
 *          Reads Eggs from Files and puts them on the {@link CheckRingBuffer}
 */
public class InputModul implements Runnable {
	//creating an object from CheckRingBuffer and giving the constructor the object 
	private CheckRingBuffer buffer;
	public InputModul(CheckRingBuffer buffer) {
		this.buffer = buffer;
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
