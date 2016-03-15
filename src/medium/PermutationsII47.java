package medium;
import java.util.*;

public class PermutationsII47 {
	
	public List<List<Integer>> permuteUnique(int[] nums) {
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(nums == null || nums.length == 0) {
			return result;
		}
		List<Integer> list = new ArrayList<Integer>();
		Arrays.sort(nums);
		boolean[] used = new boolean[nums.length];
		backTrace(list, used, nums, result);
		
		return result;
	}
	
	public void backTrace(List<Integer> list, boolean[] used, int[] nums, List<List<Integer>> result) {

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PermutationsII47 per = new PermutationsII47();
		int[] nums = {2, 2, 1, 1};
		for(List<Integer> l: per.permuteUnique(nums)) {
			for(int i : l) {
				System.out.print(i + ",");
			}
			System.out.println("");
		}		
	}

}
