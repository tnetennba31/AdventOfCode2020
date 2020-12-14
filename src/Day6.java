import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day6 {

	public Day6(File f) {
		try {
			Scanner s = new Scanner(f);
			StringBuilder sb = new StringBuilder();
			
			ArrayList<Integer> groupMembers = new ArrayList<>();	// list of how many members are in each group
			groupMembers.add(0);
			int currentGroup = 0;	// which group we're currently scanning in answers from
			
			while (s.hasNextLine()) {
				String line = s.nextLine();
				if (!line.equals("")) {	// still in same group so update their member count
					sb.append(line);
					groupMembers.add(currentGroup, groupMembers.get(currentGroup) + 1);
					groupMembers.remove(currentGroup + 1);
				} else {	// end of last group so increment which group we're scanning in answers from
					sb.append('\n');
					currentGroup++;
					groupMembers.add(0);
				}
			}
			String[] groups = sb.toString().split("\n");	// separate groups input into strings
			
			int sum = 0;
			int sumAll = 0;
			for (int i = 0; i < groups.length; i++) {
				sum += numYes(groups[i]);
				sumAll += numAllYes(groups[i], groupMembers.get(i));
			}
			
			System.out.println("Day 6, Part 1: " + sum);	// first part of the challenge
			System.out.println("Day 6, Part 2: " + sumAll);	// second part of the challenge
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
	
	public int numAllYes(String g, int members) {
		char[] chars = g.toCharArray();
		int groupYes = 0;
		for (char i = 'a'; i <= 'z'; i++) {
			int thisCharSum = 0;
			for (char y : chars) {
				if (i == y) thisCharSum++;
			}
			if (thisCharSum == members) groupYes++;	// increment sum if all members had a yes for that char
		}
		return groupYes;
	}
}