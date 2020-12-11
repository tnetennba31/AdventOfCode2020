import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day5 {
	
	public Day5(File f) {
		try {
			Scanner s = new Scanner(f);
			ArrayList<String> passes = new ArrayList<>();
			while (s.hasNextLine()) {
				passes.add(s.nextLine());
			}
			System.out.println("Day 5, Part 1: " + getHighestID(passes));	// first part of the challenege
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public int getHighestID(ArrayList<String> passes) {
		int highest = 0;
		for (String p : passes) {
			highest = Math.max(highest, calculateID(p));
		}
		return highest;
	}
	
	public int calculateID(String p) {
		int highRow = 127;
		int lowRow = 0;
		int highCol = 7;
		int lowCol = 0;
		for (char c : p.toCharArray()) {
			int rowOptions = (highRow - lowRow + 1) / 2;	// how many options we have left for the row
			int colOptions = (highCol - lowCol + 1) / 2;	// how many options we have left for the column
			switch (c) {
				case 'F' -> highRow = lowRow + rowOptions - 1;	// choose lower half of rows
				case 'B' -> lowRow = highRow - rowOptions + 1;	// choose upper half of rows
				case 'R' -> highCol = lowCol + colOptions - 1;	// choose lower half of columns
				case 'L' -> lowCol = highCol - colOptions + 1;	// choose upper half of columns
			}
		}
		return highRow * 8 + highCol;
	}
}