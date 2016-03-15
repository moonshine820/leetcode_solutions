package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations46 {

	List<List<Integer>> list;
	public List<List<Integer>> permute(int[] nums) {
		list = new ArrayList<>();
		ArrayList<Integer> perm = new ArrayList<Integer>();
		backTrack(perm, 0, nums);
		return list;
	}
	
	public void backTrack(ArrayList<Integer> perm, int i, int[] nums) {
		if(i == nums.length) {
			list.add(new ArrayList(perm));
			return;
		}

		for(int j = 0; j <= i; j++) {
			perm.add(j, nums[i]);
			backTrack(perm, i + 1, nums);
			perm.remove(j);
		}
	}
	
	public static void main(String[] args) {
		// test case 
		Permutations46 per = new Permutations46();
		int[] nums = {2, 4, 6};
		for(List<Integer> l: per.permute(nums)) {
			for(int i : l) {
				System.out.print(i + ",");
			}
			System.out.println("");
		}
	}

}
