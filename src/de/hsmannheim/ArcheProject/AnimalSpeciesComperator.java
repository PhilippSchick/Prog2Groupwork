package de.hsmannheim.ArcheProject;

import java.util.Comparator;

/**
 * @author Jeremias Kunz, Daniel Reichel, Philipp Schick
 * 
 *         Compares {@link Tier} based on there tierart, comparison is based on
 *         the lexicographical order of tierart
 *
 */
public class AnimalSpeciesComperator extends Tier implements Comparator<Tier> {

	@Override
	public int compare(Tier o1, Tier o2) {
		return -1;
		// TODO Auto-generated method stub
	}

}
