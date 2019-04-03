package de.hsmannheim.ostereiproduktion;

import java.util.ArrayList;

/**
 * @author Jeremias Kunz, Daniel Reichel, Philipp Schick
 * @version 1.00, 27.03.2019
 *
 *          Converts {@link Ei} to {@link Osterei}
 */
public class Ostereifabrik {
	/**
	 * The Eggs stored in the Fabric
	 */
	private ArrayList<Ei[]> eiStorage;

	/**
	 * The Eastereggs stored in the Fabric
	 */
	private ArrayList<Osterei> oEiStorage;

	/**
	 * Receives {@link Ei}er to convert them in {@link Osterei}er, if there are
	 * already are {@link Ei}er in the Factory all new Eggs will be destroyed
	 * 
	 * @param gestapelteEierkartons The {@link Ei}er to process
	 */
	public void wareneingang(ArrayList<Ei[]> gestapelteEierkartons) {
		// TODO Auto-generated method stub
	}

	/**
	 * Cooks a Eierkarton and converts its {@link Ei}er to {@link Osterei}ern. If an
	 * {@link Ei} is already cooked or is defect, the whole Eierkarton will be
	 * destroyed
	 * 
	 * @param kartonId The id of the Eierkarton to process
	 */
	private void kocheEier(int kartonId) {
		for (Ei ei : eiStorage.get(kartonId)) {
			Osterei oEi = new Osterei(ei);
			try {
				oEi.kochen();
			} catch (EggCrackException e) {
				vernichteKarton(kartonId);
				return;
			}
			oEiStorage.add(oEi);
		}
	}

	/**
	 * Sets the color of a {@link Osterei}. If a {@link Osterei} is already colored
	 * a {@link EggColoredException} is thrown, if a {@link Osterei} is still raw
	 * (means it is just a {@link Ei}) a {@link EggNotBoiledException} will be
	 * thrown
	 * 
	 * @param kartonId The id of the Karton, has to be greater or equals 0
	 * @param farbe    The color of the {@link Osterei}ern
	 */
	private void faerbeEier(int kartonId, Farbe farbe) {
		// TODO Auto-generated method stub
	}

	/**
	 * Returns the Number of Eierkartons on the pack
	 * 
	 * @return The Number of Eierkartons
	 */
	public int getAnzahlEierkartons() {
		return oEiStorage.size();
	}

	/**
	 * Prints a representation of the Eierkarton pack with the colors of the
	 * {@link Ei}ern on the console
	 */
	public void printGestapelteEierkartons() {
		// TODO Auto-generated method stub
	}

	/**
	 * Removes a Karton from the pack, affects the Karton with {@link Ei}ern
	 * 
	 * @param kartonId The id of the Karton, has to be greater or equals 0
	 */
	public void vernichteKarton(int kartonId) {
		eiStorage.remove(kartonId);
	}

}
