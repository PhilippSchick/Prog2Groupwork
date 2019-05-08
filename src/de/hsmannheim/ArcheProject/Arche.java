package de.hsmannheim.ArcheProject;

import java.util.Collection;

/**
 * @author Jeremias Kunz, Daniel Reichel, Philipp Schick
 *
 *         Keeps {@link Tier} of every Subtype in there own {@link Stall}
 */
public class Arche {
	private Stall<Vogel> birds = new Stall<Vogel>();
	private Stall<Saeuger> mammals = new Stall<Saeuger>();
	private Stall<Reptil> reptile = new Stall<Reptil>();
	private AnimalQueue raubtier = new AnimalQueue();
	private AnimalQueue harmlos = new AnimalQueue();

	/**
	 * Adds a new {@link Tier} to the {@link Arche}
	 * 
	 * @param animal The {@link Tier} to add
	 * @return Returns false if there is already a {@link Tier} of the same species
	 *         and sex in the {@link Arche}
	 */
	public boolean add(Tier animal) {
		if (animal instanceof Vogel) {
			birds.add((Vogel) animal);
		}
		if (animal instanceof Saeuger) {
			mammals.add((Saeuger) animal);
		}
		if (animal instanceof Reptil) {
			reptile.add((Reptil) animal);
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
		System.out.println();
	}

	/**
	 * Generates two {@link AnimalQueue}s, on for predators and one for herbivore
	 */
	public void erstelleFuetterungsWarteschlangen() {
		birds.raubtiertrennung((Collection) harmlos, false);
		mammals.raubtiertrennung((Collection) harmlos, false);
		reptile.raubtiertrennung((Collection) harmlos, false);
		birds.raubtiertrennung((Collection) raubtier, true);
		mammals.raubtiertrennung((Collection) raubtier, true);
		reptile.raubtiertrennung((Collection) raubtier, true);

		harmlos.printWarteschlange();
		raubtier.printWarteschlange();

	}

}
