import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2 {
	
	public Day2(File f) {
		try {
			Scanner s = new Scanner(f);
			int count = 0;
			
			while (s.hasNextLine()) {
				String line = s.nextLine();
				String[] pieces = line.split(" ");
				String[] nums = pieces[0].split("-");
				int min = Integer.parseInt(nums[0]);
				int max = Integer.parseInt(nums[1]);
				char letter = pieces[1].charAt(0);
				String pw = pieces[2];
				
				if (isValidPassword(min, max, letter, pw)) count++;
			}
			
			System.out.println(count);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isValidPassword(int min, int max, char letter, String pw) {
		char[] chars = pw.toCharArray();
		int count = 0;
		for (char x : chars) {
			if (x == letter) count++;
		}
		return count >= min && count <= max;
	}
}