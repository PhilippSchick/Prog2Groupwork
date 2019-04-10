package de.hsmannheim.testat1;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
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

	}

	/**
	 * Converts a File to a Eierkartonstapel
	 * 
	 * @param filename The name of the file
	 * @return The Eierkartonstapel
	 * @throws IOException 
	 */
	public Ei[][] fileToEier(String filename) throws IOException {
		BufferedReader input = new BufferedReader(new FileReader(filename));
		ArrayList<Ei> list = new ArrayList<Ei>();
		String s;
		int x = 0;
		int y = 0;
		String [] f ;
		Ei [] [] eier ;
		while ((s = input.readLine())!= null) {
			Ei ei = new Ei();
			f = input.readLine().split("\\|");
			ei.setGewicht(Integer.parseInt(f[2]));
			ei.getGroesse();
			ei.setDefekt(Boolean.parseBoolean(f[5]));
			ei.setLegedatum(f[4]);
			//eier [Integer.parseInt(f[0])][Integer.parseInt(f[1])] = new Ei();
			list.add(ei);	
			if (x<Integer.parseInt(f[0])) {
				x = Integer.parseInt(f[0]);
			}
			if (y<Integer.parseInt(f[1])) {
				y = Integer.parseInt(f[1]);
			}
			
		}
		y++;
		int r = list.size() % y;
		eier = new Ei[x+1][];
		for (int i = 0; i<x;i++) {
			eier[i] = new Ei[y];
		}
		if ( r !=0) {
			eier[x] = new Ei[r+1];
		}else {
			eier[x] = new Ei[y];
		}
		for(int i = 0;i<list.size();i++) {
			eier[i%x][i%y] = list.get(i);
		}
		
		
		
		
		
		return eier;
	}

}
