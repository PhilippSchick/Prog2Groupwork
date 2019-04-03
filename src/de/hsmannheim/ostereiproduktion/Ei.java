package de.hsmannheim.ostereiproduktion;

import java.util.GregorianCalendar;

/**
 * @author Jeremias Kunz, Daniel Reichel, Philipp Schick
 * @version 1.00, 27.03.2019
 *
 *          Represents a Egg
 */
public class Ei {
	/**
	 * The weight of the Egg
	 */
	protected int gewicht;

	/**
	 * The date the Egg was laid
	 */
	protected GregorianCalendar legedatum;

	/**
	 * Is true if the Egg is defect
	 */
	protected boolean defekt;

	/**
	 * Generates a new instance
	 */
	public Ei() {

	}

	/**
	 * Returns true if the Egg is defect
	 * 
	 * @return Returns true if the Egg is defect
	 */
	public boolean isDefekt() {
		return defekt;
	}

	/**
	 * Sets the Egg to defect
	 * 
	 * @param Sets the Egg defect
	 */
	public void setDefekt() {
	}

	/**
	 * Returns the weight
	 * 
	 * @return the weight
	 */
	public int getGewicht() {
		gewicht = (int) (Math.random()*(81 - 40)) + 40;
		return gewicht;
	}

	/**
	 * Returns the date the Egg was laid
	 * 
	 * @return the date the Egg was laid
	 */
	public GregorianCalendar getLegedatum() {
		legedatum = new GregorianCalendar();
		return legedatum;
	}

}
