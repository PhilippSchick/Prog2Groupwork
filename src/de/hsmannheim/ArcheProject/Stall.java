package de.hsmannheim.ArcheProject;

import java.util.ArrayList;

/**
 * @author Jeremias Kunz, Daniel Reichel, Philipp Schick
 * 
 *         A {@link Stall} can keep a female and a male {@link Tier} of every
 *         species, two {@link Tier} of the same species will always kept in two
 *         Fields next to each other
 *
 */
public class Stall<T extends Tier> extends ArrayList<Tier> {

	/**
	 * Adds a {@link Tier} to the {@link Stall}
	 * 
	 * @param e The {@link Tier}
	 * @return Returns false if there is already a {@link Tier} of the same species
	 *         and sex in the {@link Stall}
	 */
	public boolean add(T e) {
		return false;
		// TODO Auto-generated method stub
	}

	@Override
	public String toString() {
		String ret = "";
		
		for (int i = 0; i < size(); i++) {
			ret = (get(i).getTierart() + "(" + get(i).getGeschlecht() + ")" + "|");
		}
		return ret;
	}

}
