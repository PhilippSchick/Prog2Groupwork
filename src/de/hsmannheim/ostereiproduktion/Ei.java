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
	private int gewicht;

	/**
	 * The date the Egg was laid
	 */
	private GregorianCalendar legedatum;

	/**
	 * Is true if the Egg is defect
	 */
	private boolean defekt;

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
	/**
	 * Return the size from the egg
	 * @return
	 */
	public int getGroesse(){
		
	return 0;
		
	}

	/**
	 * set the weight
	 * @param gewicht the gewicht to set
	 */
	protected void setGewicht(int gewicht) {
		this.gewicht = gewicht;
	}

	/**
	 * set the date the Egg was laid
	 * @param legedatum the legedatum to set
	 */
	protected void setLegedatum(GregorianCalendar legedatum) {
		this.legedatum = legedatum;
	}

	/**
	 * Set the defekt of the egg
	 * 
	 * @param defekt the defekt to set
	 */
	public void setDefekt(boolean defekt) {
		this.defekt = defekt;
	}

	
}
