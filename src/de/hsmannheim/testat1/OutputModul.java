/**
 * 
 */
package de.hsmannheim.testat1;

import java.io.IOException;
import java.nio.BufferUnderflowException;

import uebung1a.Ei;

/**
 * @author Jeremias Kunz, Daniel Reichel, Philipp Schick
 * @version 1.00, 15.04.2019
 * 
 *          Takes Eggs from the {@link CheckRingBuffer} and saves them as files
 *
 */
public class OutputModul implements Runnable {

	// create an object of checkringbuffer
	public CheckRingBuffer buffer;
	public EierFileConverter converter;

	public OutputModul(CheckRingBuffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		// TODO Create Exceptions class

		int c = 1; // variable for the text document name
		int scounter = 0; // sleep counter if we wait 10 seconds
		while (true) {
			Ei[][] eierkartons = new Ei[4][25]; // array that we print into document
			if (scounter < 10) {
				//filling the eierkartons if its possible
				for (int n = 0; n < 4; n++) {
					for (int i = 0; i < 25; i++) {
						try {
							//eierkartons gets Ei from dequeue , if not we get an Exception
							eierkartons[n][i] = buffer.dequeue();
							scounter = 0;
							Thread.sleep(100);
						} catch (InterruptedException| BufferUnderflowException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							try {
								//wait 1 second , increases sleepcounter , and decrease for-loop parameters 
								Thread.sleep(1000);
								scounter++;
								n--;
								i--;

							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
				}
				//transform eierkartons into a text-document
				try {
					converter.eierToFile(eierkartons, "eier-qm" + c + ".txt");
					c++;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			// here we land if the sleepcounter == 10, we waited 10 seconds
			} else {
				//if the array is empty do nothing 
				if (eierkartons[0][0] != null) {
					try {
						converter.eierToFile(eierkartons, "eier-qm" + c + ".txt");
						c++;
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}

	}

}
