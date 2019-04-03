package de.hsmannheim.ostereiproduktion;

/**
 * @author Jeremias Kunz, Daniel Reichel, Philipp Schick
 * @version 1.00, 02.04.2019
 *
 *          Represents the Size of a {@link Ei}
 */
public enum Size {
	S, M, L, XL;

	/**
	 * Returns the matching Size for a given Integer
	 * 
	 * @param size The size as an Integer
	 * @return The Size
	 */
	public static Size getSize(int size) {
		if (size < 53) {
			return S;
		} else if (size < 63) {
			return M;
		} else if (size < 74) {
			return L;
		} else {
			return XL;
		}
	}
}
