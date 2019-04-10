/**
 * 
 */
package de.hsmannheim.testat1;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Stack;

import uebung1a.Ei;
import uebung1a.FarmDeliveryQuantityException;
import uebung1a.Huehnerfarm;
import uebung1a.Ostereifabrik;

/**
 * @author Jeremias Kunz, Daniel Reichel, Philipp Schick
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// The number of Ei files generated
		int eiNum = 10;

		Huehnerfarm farm = new Huehnerfarm();
		Stack<Ei[][]> eierStack = new Stack<Ei[][]>();
		Ei[][] eierstapel;
		EierFileConverter converter = new EierFileConverter();

		for (int i = 0; i < eiNum; i++) {
			try {
				eierstapel = farm.liefereEier(100);
			} catch (FarmDeliveryQuantityException e) {
				e.printStackTrace();
				return;
			}
			eierStack.add(eierstapel);
		}

		// Eier counter
		int n = 1;
		while (!eierStack.isEmpty()) {
			try {
				converter.eierToFile(eierStack.pop(), "eier" + n++ + ".txt");
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
		}

		LinkedList<Ei[][]> eierstapelList = new LinkedList<Ei[][]>();
		
		for (int i = 0; i < eiNum; i++) {
			try {
				eierstapelList.add(converter.fileToEier("eier" + (i + 1) + ".txt"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Ostereifabrik fabrik = new Ostereifabrik();
		
		for (Ei[][] eiS : eierstapelList) {
			fabrik.wareneingang(eiS);
		}
		
	}

}
