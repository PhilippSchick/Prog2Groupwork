/**
 * 
 */
package de.hsmannheim.testat1;

import java.io.IOException;
import java.nio.BufferOverflowException;
import uebung1a.Ei;

/**
 * @author Jeremias Kunz, Daniel Reichel, Philipp Schick
 * @version 1.00, 15.04.2019
 * 
 *          Reads Eggs from Files and puts them on the {@link CheckRingBuffer}
 */
public class InputModul implements Runnable {
	// creating an object from CheckRingBuffer and giving the constructor the object
	private CheckRingBuffer buffer;
	private EierFileConverter converter = new EierFileConverter();
	private int min;
	private int max;

	/*****
	 * 
	 * 
	 * @param buffer
	 * @param min
	 * @param max
	 */
	public InputModul(CheckRingBuffer buffer, int min, int max) {
		this.buffer = buffer;
		this.min = min;
		this.max = max;

	}

	@Override
	public void run() {
		// keeps the Eggs from files
		Ei[][] eierkarton;

		while (true) {
			for (int i = min; i <= max; i++) {
				try {
					// convert files into a twodimensional-array
					eierkarton = converter.fileToEier("eier" + i + ".txt");

				} catch (IOException e) {
					e.printStackTrace();
					return;
				}
				
				// pushes every element of the array into the CheckRingBuffer
				for (int n = 0; n < eierkarton.length; n++) {
					for (int m = 0; m < eierkarton[n].length; m++) {

						try {
							buffer.enqueue(eierkarton[n][m]);

							// after every element sleeps for 100
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
							return;
							// if the CheckRingBuffer is full, the thread yield and for loop gets reseted
						} catch (BufferOverflowException e) {
							m--;
							try {
								Thread.sleep(50);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
				}
			}
		}

	}

}
