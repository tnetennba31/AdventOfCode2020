import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Day7 {

	public Day7(File f) {
		try {
			Scanner s = new Scanner(f);
			HashMap<String, String> rules = new HashMap<>();
			while (s.hasNextLine()) {
				String[] parts = s.nextLine().split(" bags contain ");
				rules.put(parts[0], parts[1]);
			}
			int total = 0;
			for (String bag : rules.keySet()) {
				if (canContainGold(bag, rules)) total++;
			}
			System.out.println("Day 7, Part 1: " + total);	// first part of challenge
			System.out.println("Day 7, Part 2: " + numBagsContained("shiny gold", rules));	// second part of challenge
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public boolean canContainGold(String bag, HashMap<String, String> rules) {
		boolean canContainGold = false;
		String currentContents = rules.get(bag);
		if (currentContents.contains("shiny gold")) {	// yes contains gold
			return true;
		} else if (currentContents.equals("no other bags.")) {	// no doesn't contain gold
			return false;
		} else {	// recursively look through bags it contains
			String[] newContents = currentContents.split(", ");
			for (int i = 0; i < newContents.length; i++) {
				newContents[i] = newContents[i].substring(2, newContents[i].indexOf("bag")).strip();
				if (canContainGold(newContents[i], rules)) {
					canContainGold = true;
					break;
				}
			}
		}
		return canContainGold;
	}
	
	public int numBagsContained(String bag, HashMap<String, String> rules) {
		int numBagsContained = 0;
		String currentContents = rules.get(bag);
		if (currentContents.equals("no other bags.")) {	// contains nothing else
			return numBagsContained;
		} else {	// recursively count contained bags
			String[] newContents = currentContents.split((", "));
			for (int i = 0; i < newContents.length; i++) {
				int numBags = Integer.parseInt(newContents[i].substring(0, 1));
				newContents[i] = newContents[i].substring(2, newContents[i].indexOf("bag")).strip();
				numBagsContained += numBags + (numBags * numBagsContained(newContents[i], rules));
			}
		}
		return numBagsContained;
	}
}