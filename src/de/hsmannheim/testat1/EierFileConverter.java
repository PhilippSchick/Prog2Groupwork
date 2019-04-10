package de.hsmannheim.testat1;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

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
	 * @throws IOException 
	 */
	public void eierToFile(Ei[][] eierkartonstapel, String filename) throws IOException {
		FileOutputStream out = new FileOutputStream(filename);
		for(int i = 0;i<eierkartonstapel.length;i++) {
			for(int y = 0;y<eierkartonstapel[i].length;y++) {
				out.write((i +"|"+ y + "|"+ eierkartonstapel[i][y].getGewicht() + "|"+ eierkartonstapel[i][y].getGroesse()+"|"+ eierkartonstapel[i][y].getLegedatum()+"|"+ eierkartonstapel[i][y].getDefekt()+ "\r\n").getBytes());
			}
		}
		

	}

	/**
	 * Converts a File to a Eierkartonstapel
	 * 
	 * @param filename The name of the file
	 * @return The Eierkartonstapel
	 */
	public Ei[][] fileToEier(String filename) {
		return null;
	}

	/**
	 * Converts a {@link Ei} to a String
	 * 
	 * @param ei The {@link Ei}
	 * @return The String representing the {@link Ei}
	 */
	private String eiToString(Ei ei) {
		return null;
	}

	/**
	 * Converts a String back to a {@link Ei}
	 * 
	 * @param s The String
	 * @return a {@link Ei}
	 */
	private Ei stringToEi(String s) {
		return null;
	}

}
