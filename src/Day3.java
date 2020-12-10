import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3 {
	
	ArrayList<String> map;
	
	public Day3(File f) {
		try {
			Scanner s = new Scanner(f);
			ArrayList<String> map = new ArrayList<>();
			while (s.hasNextLine()) {
				map.add(s.nextLine());
			}
			this.map = map;
			
			System.out.println("Day 3, Part 1: " + treeCountBySlope(3, 1)); // first part of the challenge
			System.out.println("Day 3, Part 2: " + treeCount()); // second part of the challenge
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public int treeCount() {
		int a, b, c, d, e;
		a = treeCountBySlope( 1, 1);
		b = treeCountBySlope( 3, 1);
		c = treeCountBySlope( 5, 1);
		d = treeCountBySlope(7, 1);
		e = treeCountBySlope(1, 2);
		return a * b * c * d * e;
	}
	
	public int treeCountBySlope(int right, int down) {
		int x = right;
		int trees = 0;
		for (int y = down; y < map.size(); y+=down) {
			String s = map.get(y);
			if (x >= s.length()) x = x % s.length(); // map repeats, so loop back if need more columns
			char symbol = s.charAt(x);
			if (symbol == '#') trees++;
			x += right;
		}
		return trees;
	}
}