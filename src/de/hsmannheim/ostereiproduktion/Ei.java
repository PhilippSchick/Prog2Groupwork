package de.hsmannheim.ostereiproduktion;

import java.util.GregorianCalendar;

/**
 * @author Jeremias Kunz, Daniel Reichel, Philipp Schick
 * @version 1.00, 27.03.2019
 *
 */
public class Ei {
	/**
	 * min. 40, max. 80; Gewicht wird Zufällig ermittelt
	 */
	private int gewicht;
	private GregorianCalendar legedatum;
	private boolean defekt;

	public Ei() {

	}

	/**
	 * @return the defekt
	 */
	public boolean isDefekt() {
		return defekt;
	}

	/**
	 * @param defekt the defekt to set
	 */
	public void setDefekt(boolean defekt) {
		this.defekt = defekt;
	}

	/**
	 * @return the gewicht
	 */
	public int getGewicht() {
		return gewicht;
	}

	/**
	 * @return the legedatum
	 */
	public GregorianCalendar getLegedatum() {
		return legedatum;
	}

}
