package de.hsmannheim.testat1;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import uebung1a.Ei;

/**
 * @author Jeremias Kunz, Daniel Reichel, Philipp Schick
 * 
 *         Provides a Converter from {@link Ei} to a File and Reverse
 *
 */
public class EierFileConverter {
	/**
	 * Converts Eierkartonstapel to a File
	 * 
	 * @param eierkartonstapel The Eierkartonstapel
	 * @param filename         The name of the file
	 * @throws IOException eierToFile works only one time
	 */
	public void eierToFile(Ei[][] eierkartonstapel, String filename) throws IOException {
		FileOutputStream out = new FileOutputStream(filename);
		for (int i = 0; i < eierkartonstapel.length; i++) {
			for (int y = 0; y < eierkartonstapel[i].length; y++) {
				out.write((i + "|" + y + "|" + eierkartonstapel[i][y].getGewicht() + "|"
						+ eierkartonstapel[i][y].getGroesse() + "|" + eierkartonstapel[i][y].getLegedatum() + "|"
						+ eierkartonstapel[i][y].getDefekt() + "\r\n").getBytes());
			}
		}
		out.close();
	}

	/**
	 * Converts a File to a Eierkartonstapel
	 * 
	 * @param filename The name of the file
	 * @return The Eierkartonstapel
	 * @throws IOException if an I/O-Error occurs
	 */

	public Ei[][] fileToEier(String filename) throws IOException {
		// The File reader
		BufferedReader reader = new BufferedReader(new FileReader(filename));

		ArrayList<Ei> list = new ArrayList<Ei>();

		int x = 0;
		int y = 0;

		// The input String
		String input;
		// The Input after it was split in its data fields
		String[] splittedInput;

		Ei[][] eier;

		while ((input = reader.readLine()) != null) {
			splittedInput = input.split("\\|");

			// Config new a Ei
			Ei ei = new Ei();
			ei.setGewicht(Integer.parseInt(splittedInput[2]));
			ei.setLegedatum(splittedInput[4]);
			ei.setDefekt(Boolean.parseBoolean(splittedInput[5]));

			list.add(ei);
			if (x < Integer.parseInt(splittedInput[0])) {
				x = Integer.parseInt(splittedInput[0]);
			}
			if (y < Integer.parseInt(splittedInput[1])) {
				y = Integer.parseInt(splittedInput[1]);
			}

		}
		reader.close();

		y++;
		int r = list.size() % y;
		eier = new Ei[x + 1][];
		for (int i = 0; i < x; i++) {
			eier[i] = new Ei[y];
		}
		if (r != 0) {
			eier[x] = new Ei[r + 1];
		} else {
			eier[x] = new Ei[y];
		}
		for (int i = 0; i < list.size(); i++) {
			eier[i / y][i % y] = list.get(i);
		}

		return eier;
	}
}
