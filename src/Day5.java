import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day5 {
	
	public Day5(File f) {
		try {
			Scanner s = new Scanner(f);
			ArrayList<Integer> passes = new ArrayList<>();
			// this loop came from reddit because i never would have thought to do it this way
			while (s.hasNextLine()) {
				String binary = s.nextLine().replaceAll("[FL]", "0").replaceAll("[BR]", "1");
				passes.add(Integer.parseInt(binary, 2));
			}
			passes.sort(null);
			System.out.println("Day 5, Part 1: " + passes.get(passes.size() - 1));  // first part of the challenege
			System.out.println("Day 5, Part 2: " + findMySeat(passes));  // second part of the challenge
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public int findMySeat(ArrayList<Integer> IDs) {
		for (int i : IDs) {
			if (!IDs.contains(i+1) && IDs.contains(i+2)) return i+1;
		}
		return 0;
	}
}