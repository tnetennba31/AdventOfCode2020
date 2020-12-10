import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Day1 {
	
	public Day1(File f) {
		ArrayList<Integer> list = new ArrayList<>();
		
		
		System.out.println(sumTo2020(list));
	}
	
	public static int sumTo2020(ArrayList<Integer> nums) {
		int winner = 0;
		for (int x : nums) {
			int diff = 2020 - x;
			if (nums.contains(diff)) {
				winner = diff * x;
			}
		}
		return winner;
	}
}