package de.hsmannheim.ostereiproduktion;

import java.util.ArrayList;

/**
 * @author Jeremias Kunz, Daniel Reichel, Philipp Schick
 * @version 1.00, 27.03.2019
 *
 *          Generates instances of {@link Ei}
 */
public class Huehnerfarm {
	/**
	 * Minimal number of {@link Ei} returned
	 */
	private int minBest;
	/**
	 * Maximal number of {@link Ei} returned
	 */
	private int maxBest;

	/**
	 * Generates a new instance of {@link Huehnerfarm} and sets the minimal and the
	 * maximal number of {@link Ei} returned
	 * 
	 * @param minBest Minimal number of {@link Ei} returned
	 * @param maxBest Maximal number of {@link Ei} returned
	 */
	public Huehnerfarm(int minBest, int maxBest) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Generates a new instance of {@link Huehnerfarm} and sets the minimal number
	 * of {@link Ei} returned to 25 and the maximal to 5000
	 */
	public Huehnerfarm() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Returns a pack of Eierkartons, a Eierkarton is represented by a Array of
	 * {@link Ei} with size 25
	 * 
	 * @param anzEier The number of Eiern contain in the pack
	 * @return ArrayList<Ei[]> The Eierkarton pack
	 */
	private ArrayList<Ei[]> erstelleEierkartonstapel(int anzEier) {
		return null;
		// TODO Auto-generated method stub
	}

	/**
	 * Returns a pack of Eierkartons, a Eierkarton is represented by a Array of
	 * {@link Ei} with size 25
	 * 
	 * @param menge     The number of {@link Ei} returned, has to be between
	 *                  <code>minBest</code> and <code>maxBest</code>
	 * @param ausschuss The percentage of {@link Ei} where <code>isDefekt()</code>
	 *                  equals <code>true</code>, has to be less or equal 100 and
	 *                  bigger than 0
	 * @return ArrayList<Ei[]> The Eierkarton pack
	 */
	public ArrayList<Ei[]> liefereEier(int menge, int ausschuss) {
		return null;
		// TODO Auto-generated method stub
	}

	/**
	 * Returns a pack of Eierkartons, a Eierkarton is represented by a Array of
	 * {@link Ei} with size 25.
	 * 
	 * @param menge The number of {@link Ei} returned, has to be between
	 *              <code>minBest</code> and <code>maxBest</code>
	 * @return ArrayList<Ei[]> The Eierkarton pack
	 */
	public ArrayList<Ei[]> liefereEier(int menge) {
		return null;
		// TODO Auto-generated method stub
	}

}
