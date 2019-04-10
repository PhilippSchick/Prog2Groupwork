/**
 * 
 */
package de.hsmannheim.testat1;

import java.io.IOException;
import java.util.Stack;

import uebung1a.Ei;
import uebung1a.FarmDeliveryQuantityException;
import uebung1a.Huehnerfarm;

/**
 * @author Jeremias Kunz, Daniel Reichel, Philipp Schick
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Huehnerfarm farm = new Huehnerfarm();
		Stack<Ei[][]> eierStack = new Stack<Ei[][]>();
		Ei[][] eierstapel;
		EierFileConverter converter = new EierFileConverter();

		for (int i = 0; i < 10; i++) {
			try {
				eierstapel = farm.liefereEier(100);
			} catch (FarmDeliveryQuantityException e) {
				e.printStackTrace();
				return;
			}
			eierStack.add(eierstapel);
		}
		
		//Eier counter
		int i = 1;
		while (!eierStack.isEmpty()) {
			try {
				converter.eierToFile(eierStack.pop(), "eier" + i++ + ".txt");
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
		}
		
		

	}

}
