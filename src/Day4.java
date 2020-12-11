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
			int numDataValid = 0;
			for (String p : passports) {
				String[] fields = p.split(" "); // split passport into its fields
				if (isValidPassport(fields)) {
					numValid++;
					if (hasValidData(fields)) numDataValid++;
				}
			}
			System.out.println("Day 4, Part 1: " + numValid);  // first part of the challenge
			System.out.println("Day 4, Part 2: " + numDataValid);	// second part of the challenge
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	boolean isValidPassport(String[] fields) {
		int numFields = 0;
		for (String f : fields) {
			String[] values = f.split(":");
			if (!values[0].equals("cid")) {
				numFields++; // count fields we care about
			}
		}
		return numFields == 7;
	}
	
	boolean hasValidData(String[] fields) {
		for (String f : fields) {
			String[] values = f.split(":");
			if (!isValidField(values)) return false;
		}
		return true;
	}
	
	boolean isValidField(String[] values) {
		boolean valid = false;
		String data = values[1];
		
		try {
			switch (values[0]) {
				case "byr" -> valid = Integer.parseInt(data) >= 1920 && Integer.parseInt(data) <= 2002;
				case "iyr" -> valid = Integer.parseInt(data) >= 2010 && Integer.parseInt(data) <= 2020;
				case "eyr" -> valid = Integer.parseInt(data) >= 2020 && Integer.parseInt(data) <= 2030;
				case "hgt" -> {
					char t = data.charAt(data.length() - 2);
					if (t == 'i') {
						int num = Integer.parseInt(data.split("in")[0]);
						valid = num >= 59 && num <= 76;
					} else if (t == 'c') {
						int num = Integer.parseInt(data.split("cm")[0]);
						valid = num >= 150 && num <= 193;
					}
				}
				case "hcl" -> {
					if (data.charAt(0) != '#') break;
					for (int i = 1; i < data.length(); i++) {
						char c = data.charAt(i);
						if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f')) {
							valid = true;
						} else {
							valid = false;
							break;
						}
					}
				}
				case "ecl" -> valid = data.equals("amb") || data.equals("blu") || data.equals("brn") || data.equals("gry") || data.equals("grn") || data.equals("hzl") || data.equals("oth");
				case "pid" -> valid = data.length() == 9;
				case "cid" -> valid = true;
			}
		} catch (Exception e) {
			valid = false;
		}
		
		return valid;
	}
}
