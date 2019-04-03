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
		if (minBest > maxBest) {
			throw new FarmDeliveryQuantityException("minMenge ist groesser als maxmMenge");
		}

	}

	/**
	 * Generates a new instance of {@link Huehnerfarm} and sets the minimal number
	 * of {@link Ei} returned to 25 and the maximal to 5000
	 */
	public Huehnerfarm() {
		// TODO Auto-generated constructor stub
		this.minBest = 25;
		this.maxBest = 5000;
	}

	/**
	 * Returns a pack of Eierkartons, a Eierkarton is represented by a Array of
	 * {@link Ei} with size 25
	 * 
	 * @param anzEier The number of Eiern contain in the pack
	 * @return ArrayList<Ei[]> The Eierkarton pack
	 */
	private ArrayList<Ei[]> erstelleEierkartonstapel(int anzEier) {
		ArrayList<Ei[]> obj = new ArrayList<>();
		for (int i = anzEier; i > 0; i -= 25) {
			if (anzEier < 25) {
				Ei[] ei = new Ei[anzEier];
				for (int y = 0; y < anzEier; y++) {
					ei[y] = new Ei();
				}
				obj.add(ei);
				i = 0;

			} else {
				Ei[] ei = new Ei[25];
				for (int y = 0; y < 25; y++) {
					ei[y] = new Ei();
				}
				obj.add(ei);

			}

		}
		return obj;
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
		if (ausschuss < 0 || ausschuss > 100) {
			double as = (double) (5 / 100);
			menge = menge - (int) (as * menge);
			return (erstelleEierkartonstapel(menge));

		} else {
			double as = (double) (ausschuss / 100);
			menge = menge - (int) (as * menge);
			return (erstelleEierkartonstapel(menge));

		}

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
		if (menge > maxBest || menge < minBest) {
			throw new FarmDeliveryQuantityException("die mindestens Bestellung liegt bei " + minBest
					+ "und die maximale Bestellung bei" + maxBest + "Ihre Bestellung lautet :" + menge);
		}
		return liefereEier(menge, 5);
		// TODO Auto-generated method stub
	}

}
