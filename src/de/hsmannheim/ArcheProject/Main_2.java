package de.hsmannheim.ArcheProject;

/**
 * @author Jeremias Kunz, Daniel Reichel, Philipp Schick
 * 
 *         The Main Program for the second assignment
 *
 */
public class Main_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AnimalQueue queue = new AnimalQueue(20);
		queue.printWarteschlange();

		Arche arch = new Arche();
		for (Tier animal : queue) {
			arch.add(animal);
		}
		arch.printStallbelegung();
		arch.erstelleFuetterungsWarteschlangen();
		

	}

}
