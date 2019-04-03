package de.hsmannheim.ostereiproduktion;

/**
 * @author Jeremias Kunz, Daniel Reichel, Philipp Schick
 * @version 1.00, 27.03.2019
 *
 *          Represents a Easteregg
 */
public class Osterei extends Ei {

	/**
	 * The color of the Egg
	 */
	private Farbe farbe;

	/**
	 * True if the Egg is cooked
	 */
	private boolean gekocht;

	/**
	 * Generates a new {@link Osterei} out of a {@link Ei}
	 * 
	 * @param ei The {@link Ei}
	 */
	public Osterei(Ei ei) {
		this.defekt = ei.defekt;
		this.legedatum = ei.legedatum;
		this.gewicht = ei.gewicht;
	}

	/**
	 * Sets <code>gekocht</code> to <code>true</code>
	 */
	public void kochen() {
		if (defekt) {
			throw new EggCrackException("Egg is defect!");
		}
		if (gekocht) {
			throw new EggCrackException("Egg already cooked!");
		}
		gekocht = true;
	}

	/**
	 * Sets the color of the Egg
	 * 
	 * @param farbe The color of the Egg
	 */
	public void faerben(Farbe farbe) {
		if (this.farbe != null) {
			this.farbe = Farbe.ugly;
		} else {
			this.farbe = farbe;
		}
	}

}
