import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day4 {
	
	public Day4(File f) {
		try {
			Scanner s = new Scanner(f);
			StringBuilder fileString = new StringBuilder();
			while (s.hasNextLine()) {
				String line = s.nextLine();
				if (!line.equals("")) {
					fileString.append(line).append(" "); // separate passport fields with spaces
				} else {
					fileString.append("\n"); // separate passports with newlines
				}
			}
			String[] passports = fileString.toString().split("\n"); // split file contents into single passports
			int numValid = 0;
			for (String p : passports) {
				if (isValidPassport(p)) numValid++;
			}
			System.out.println("Day 4, Part 1: " + numValid);	// first part of the challenge
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	boolean isValidPassport(String passport) {
		String[] fields = passport.split(" "); // split passport into its fields
		int numFields = 0;
		for (String f : fields) {
			String[] values = f.split(":");
			if (!values[0].equals("cid")) numFields++; // count all fields except cid because we don't care about it
		}
		return numFields == 7;
	}
}
