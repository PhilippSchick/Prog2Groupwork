package de.hsmannheim.ArcheProject;

import java.util.LinkedList;

/**
 * @author Jeremias Kunz, Daniel Reichel, Philipp Schick
 *
 *         A Queue for instances of {@link Tier}
 */
public class AnimalQueue extends LinkedList<Tier> {

	public AnimalQueue(int numberofAnimals) {
		while (numberofAnimals > 0) {
			addFirst(Tiergenerator.getTier());
			numberofAnimals--;
		}
	}

	/**
	 * All {@link Vogel} will be removed from the Queue
	 * if the object is from Vogel , its getting removed 
	 * @return the number of {@link Vogel} flown away
	 */
	public int sturm() {
		int counter =0;
		for (int i = 0; i < size(); i++) {
			if (get(i) instanceof Vogel) {
				remove(i);
				i--;
				counter++;
			}

		}
		return counter;
	}

	/**
	 * Every {@link Tier} with the characteristic raubtier will eat (remove) the
	 * {@link Tier} on the next position in the queue, except the next {@link Tier}
	 * has the characteristics raubtier or giftig
	 * 
	 * @return the number of Animals eaten
	 */
	public int grossesFressen() {
		int counter = 0 ;
		for (int i =0; i <size(); i++) {
			if (get(i).getRaubtier() && (i + 1  != size())) {
				if (get(i + 1).getRaubtier() != true /*|| get(i + 1).getTierart().equals("giftReptil")*/) {
					remove(i + 1);
					counter++;
				}
			}

		}
		return counter;
	}

	/**
	 * Prints a representation of the queue on the Console
	 */
	public void printWarteschlange() {
		for (int i = 0; i < size(); i++) {
			System.out.print(get(i).getTierart() + "(" + get(i).getGeschlecht() + ")" + "|");
		}
		System.out.println();
	}
}
