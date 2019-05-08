package de.hsmannheim.ArcheProject;

/**
 * @author Jeremias Kunz, Daniel Reichel, Philipp Schick
 *
 *         Keeps {@link Tier} of every Subtype in there own {@link Stall}
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
		if (animal instanceof Saeuger) {
			birds.add(animal);
		}
		if (animal instanceof Vogel) {
			mammals.add(animal);
		}
		if (animal instanceof Reptil) {
			reptile.add(animal);
		}
		return false;
	}

	/**
	 * Prints a representation of the {@link Arche} on the Console
	 */
	public void printStallbelegung() {
		System.out.println("Vogel-Stall");
		System.out.println(birds.toString() + "\n");
		System.out.println("-----------------------------------------------------------------");

		System.out.println("Säuger-Stall");
		System.out.println(mammals.toString() + "\n");
		System.out.println("-----------------------------------------------------------------");

		System.out.println("Reptilien-Stall");
		System.out.println(reptile.toString());
	}

	/**
	 * TODO Genauere beschreibung notwendig
	 */
	public void erstelleFuetterungsWarteschlangen() {
		// TODO Auto-generated method stub
	}

}
