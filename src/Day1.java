import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {
	
	public Day1(File f) {
		ArrayList<Integer> list = new ArrayList<>();
		try {
			Scanner s = new Scanner(f);
			while (s.hasNext()) {
				list.add(s.nextInt());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(sumTo2020(list));
		System.out.println(sumTo2020Again(list));
	}
	
	public int sumTo2020(ArrayList<Integer> nums) {
		int winner = 0;
		for (int x : nums) {
			int diff = 2020 - x;
			if (nums.contains(diff)) {
				winner = diff * x;
			}
		}
		return winner;
	}
	
	public int sumTo2020Again(ArrayList<Integer> nums) {
		int winner = 0;
		for (int x : nums) {
			for (int y : nums) {
				int diff = 2020 - x - y;
				if ((y != x) && (nums.contains(diff))) {
					winner = x * y * diff;
				}
			}
		}
		return winner;
	}
}