package de.hsmannheim.testat1;

import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;
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

		// Generate eiNum * 100 Eier
		for (int i = 0; i < eiNum; i++) {
			try {
				eierstapel = farm.liefereEier(100);
			} catch (FarmDeliveryQuantityException e) {
				// Fatal Error!
				e.printStackTrace();
				return;
			}
			eierStack.add(eierstapel);
		}

		// Eier counter
		int n = 1;

		// Write all Eggs into files
		while (!eierStack.isEmpty()) {
			try {
				converter.eierToFile(eierStack.pop(), "eier" + n++ + ".txt");
			} catch (IOException e) {
				// Fatal Error!
				e.printStackTrace();
				return;
			}
		}

		// List of Eierstapel
		LinkedList<Ei[][]> eierstapelList = new LinkedList<>();

		// Read all Eggs back in
		for (int i = 0; i < eiNum; i++) {
			try {
				eierstapelList.add(converter.fileToEier("eier" + (i + 1) + ".txt"));
			} catch (IOException e) {
				// Fatal Error!
				e.printStackTrace();
				return;
			}
		}

		Ostereifabrik fabrik = new Ostereifabrik();

		// Convert All Eggs to Ostereiern	
		ListIterator<Ei[][]> iterator = eierstapelList.listIterator();
		while (iterator.hasNext()) {
			fabrik.wareneingang(iterator.next());
		}

		/*
		 * ########## Assignment 2 ##########
		 */

		CheckRingBuffer buffer = new CheckRingBuffer();

		// Generate the Modules
		InputModul in0 = new InputModul(buffer, 1, 5);
		InputModul in1 = new InputModul(buffer, 6, 10);
		OutputModul out = new OutputModul(buffer);
		TestModul test = new TestModul(buffer);

		// Generate the threads
		Thread testThread = new Thread(test);
		Thread outThread = new Thread(out);
		Thread inThread0 = new Thread(in0);
		Thread inTHread1 = new Thread(in1);

		// start Threads
		inThread0.start();
		inTHread1.start();
		testThread.start();
		outThread.start();
		
	}

}
