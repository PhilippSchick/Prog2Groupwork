/**
 * 
 */
package de.hsmannheim.ostereiproduktion;

/**
 * @author Jeremias Kunz, Daniel Reichel, Philipp Schick
 * @version 1.00, 03.04.2019
 *
 *          Thrown if a Egg is cracked
 */
public class EggCrackException extends RuntimeException {

	public EggCrackException(String message) {
		super(message);
	}
}
