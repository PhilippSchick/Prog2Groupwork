package de.hsmannheim.ArcheProject;

/**
 * @author Jeremias Kunz, Daniel Reichel, Philipp Schick
 *
 * Keeps {@link Tier} of every Subtype in there own {@link Stall}
 */
public class Arche {
	private Stall<Vogel> birds = new Stall<Vogel>();
	private Stall<Saeuger> mammals = new Stall<Saeuger>();
	private Stall<Reptil> reptile = new Stall<Reptil>();

	/**
	 * Adds a new {@link Tier} to the {@link Arche}
	 * 
	 * @param animal The {@link Tier} to add
	 * @return Returns false if there is already a {@link Tier} of the same species
	 *         and sex in the {@link Arche}
	 */
	public boolean add(Tier animal) {
		return false;
		// TODO Auto-generated method stub
	}

	/**
	 * Prints a representation of the {@link Arche} on the Console
	 */
	public void printStallbelegung() {
		// TODO Auto-generated method stub
	}

	/**
	 * TODO Genauere beschreibung notwendig
	 */
	public void erstelleFuetterungsWarteschlangen() {
		// TODO Auto-generated method stub
	}

}
