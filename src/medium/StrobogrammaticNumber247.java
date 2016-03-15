package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class StrobogrammaticNumber247 {
	public List<String> findStrobogrammatic(int n) {
		List<String> result = helper(n, n);
		return result;
	}
	
	private List<String> helper(int n, int m) {
		if(n == 0) return Arrays.asList("");
		if(n == 1) return Arrays.asList("0", "1", "8");
		
		List<String> list = helper(n-2, m);
		List<String> result = new ArrayList();
		for(String i : list) {
			if(n != m) result.add("0" + i + "0");
			result.add("1" + i + "1");
			result.add("8" + i + "8");
			result.add("9" + i + "6");
			result.add("6" + i + "9");
		}
		return result;
	}
}
