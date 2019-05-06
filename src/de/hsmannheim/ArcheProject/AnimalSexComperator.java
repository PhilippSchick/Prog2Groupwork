package de.hsmannheim.ArcheProject;

import java.util.Comparator;

/**
 * @author Jeremias Kunz, Daniel Reichel, Philipp Schick
 *
 * Compares {@link Tier} based on there geschlecht
 */
public class AnimalSexComperator extends Tier implements Comparator<Tier> {

	@Override
	public int compare(Tier arg0, Tier arg1) {
		return String.valueOf(arg0.getGeschlecht()).compareTo(String.valueOf(arg1.getGeschlecht()));
	}

}

