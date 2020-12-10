import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2 {
	File f;
	
	public Day2(File f) {
		this.f = f;
		System.out.println("Day 2, Part 1: " + findPasswords(0)); // first part of challenge
		System.out.println("Day 2, Part 2: " + findPasswords(1)); // second part of challenge
	}
	
	public int findPasswords(int version) {
		int count = 0;
		
		try {
			Scanner s = new Scanner(f);
			
			while (s.hasNextLine()) {
				String line = s.nextLine();
				String[] pieces = line.split(" ");
				String[] nums = pieces[0].split("-");
				int min = Integer.parseInt(nums[0]);
				int max = Integer.parseInt(nums[1]);
				char letter = pieces[1].charAt(0);
				String pw = pieces[2];
				
				if (version == 0 && isValidPassword(min, max, letter, pw)) count++;
				else if (version == 1 && isValidPasswordOfficial(min, max, letter, pw)) count++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	public boolean isValidPassword(int min, int max, char letter, String pw) {
		char[] chars = pw.toCharArray();
		int count = 0;
		for (char x : chars) {
			if (x == letter) count++;
		}
		return count >= min && count <= max; // if within bounds of instance counts return true
	}
	
	public boolean isValidPasswordOfficial(int lower, int upper, char letter, String pw) {
		lower -= 1; // account for array starting at 0
		upper -= 1;
		
		return pw.charAt(lower) == letter ^ pw.charAt(upper) == letter; // XOR booleans char at lower and char at upper
	}
}