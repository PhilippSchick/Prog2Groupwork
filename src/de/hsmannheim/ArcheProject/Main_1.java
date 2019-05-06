package de.hsmannheim.ArcheProject;

/**
 * @author Jeremias Kunz, Daniel Reichel, Philipp Schick
 * 
 *         The Main Program for the first assignment
 *
 */
public class Main_1 {

	public static void main(String[] args) {

		AnimalQueue queue = new AnimalQueue(10);
		queue.printWarteschlange();

		// Storm
		queue.sturm();
		queue.printWarteschlange();

		// the big feast
		queue.grossesFressen();
		queue.printWarteschlange();
		
		// Sort by species
		queue.sort(new AnimalSpeciesComperator());
		queue.printWarteschlange();
		
		// Sort by sex
		queue.sort(new AnimalSexComperator());
		queue.printWarteschlange();
	}

}
