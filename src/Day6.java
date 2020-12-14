import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day6 {
	
	public Day6(File f) {
		try {
			Scanner s = new Scanner(f);
			int sum = 0;
			StringBuilder sb = new StringBuilder();
			while (s.hasNextLine()) {
				String line = s.nextLine();
				if (!line.equals("")) {
					sb.append(line);
				} else {
					sb.append('\n');
				}
			}
			String[] groups = sb.toString().split("\n");	// separate groups input into strings
			for (String g : groups) {
				sum += numYes(g);
			}
			System.out.println("Day 6, Part 1: " + sum);	// first part of the challenge
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public int numYes(String g) {
		int groupYes = 0;
		for (char i = 'a'; i <= 'z'; i++) {
			if (g.indexOf(i) != -1) groupYes++;
		}
		return groupYes;
	}
}