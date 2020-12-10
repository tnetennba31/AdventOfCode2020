import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3 {
	
	public Day3(File f) {
		try {
			Scanner s = new Scanner(f);
			ArrayList<String> map = new ArrayList<>();
			while (s.hasNextLine()) {
				map.add(s.nextLine());
			}
			System.out.println("Day 3, Part 1: " + treeCount(map)); // first part of the challenge
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public int treeCount(ArrayList<String> map) {
		int x = 3, y = 1;
		int trees = 0;
		for (int i = 0; i < map.size() - 1; i++) {
			String s = map.get(y);
			if (x >= s.length()) x = x % s.length(); // map repeats, so loop back if need more columns
			char symbol = s.charAt(x);
			if (symbol == '#') trees++;
			x += 3;
			y += 1;
		}
		return trees;
	}
}