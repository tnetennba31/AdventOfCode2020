import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day8 {
	
	public Day8(File f) {
		try {
			Scanner s = new Scanner(f);
			ArrayList<String> instrs = new ArrayList<>();
			while (s.hasNextLine()) {
				instrs.add(s.nextLine());
			}
			System.out.println("Day 8, Part 1: " + runCode(instrs));	// first part of challenge
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public int runCode(ArrayList<String> instrs) {
		int acc = 0;
		int currentInstr = 0;
		ArrayList<Integer> instrsRan = new ArrayList<>();
		
		while(!instrsRan.contains(currentInstr)) {
			instrsRan.add(currentInstr);
			String cur = instrs.get(currentInstr);
			int val = Integer.parseInt(cur.substring(4).strip());
			if (cur.startsWith("acc")) {	// accumulator
				acc += val;
				currentInstr++;
			} else if (cur.startsWith("jmp")) {	// jump
				currentInstr += val;
			} else {	// no operation
				currentInstr++;
			}
		}
		
		return acc;
	}
}