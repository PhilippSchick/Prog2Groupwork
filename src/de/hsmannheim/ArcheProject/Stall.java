package de.hsmannheim.ArcheProject;

import java.util.Collection;
import java.util.LinkedList;

/**
 * @author Jeremias Kunz, Daniel Reichel, Philipp Schick
 * 
 *         A {@link Stall} can keep a female and a male {@link Tier} of every
 *         species, two {@link Tier} of the same species will always kept in two
 *         Fields next to each other
 *
 */
public class Stall<T extends Tier> extends LinkedList<T> {

	/**
	 * Adds a {@link Tier} to the {@link Stall}
	 * 
	 * @param e The {@link Tier}
	 * @return Returns false if there is already a {@link Tier} of the same species
	 *         and sex in the {@link Stall}
	 */
	@Override
	public boolean add(T e) {
		boolean exist = true;
		// for loop checks if there already is the same species with the same sex,
		// if it is the case the animal that should be added gets skipped
		for (int i = 0; i < size(); i++) {
			if (get(i).getTierart().equals(e.getTierart()) && get(i).getGeschlecht() == e.getGeschlecht()) {
				exist = false;
			}

		}
		// adding the animal
		if (exist) {
			super.add(e);
			sort(new AnimalSpeciesComperator());
			return true;
		}

		return false;

	}

	/**
	 * Fills the given {@link Collection} with {@link Tier}
	 * 
	 * @param queue    The {@link Collection} to fill
	 * @param raubtier If <code>true</code> only predetors will be filled into the
	 *                 queue, if <code>false</code> only herbivores will filled into
	 *                 the {@link Collection}
	 */
	public void raubtiertrennung(Collection<T> queue, boolean raubtier) {
		for (T animal : this) {
			if (animal.getRaubtier() == raubtier) {
				queue.add(animal);
			}
		}
	}

	@Override
	public String toString() {
		String ret = "";

		for (int i = 0; i < size(); i++) {
			ret += (get(i).getTierart() + "(" + get(i).getGeschlecht() + ")" + "|");
		}
		return ret;
	}

}
