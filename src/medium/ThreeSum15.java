package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum15 {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		for(int i = 0; i < nums.length-2; i++) {
			if(i > 0 && nums[i - 1] == nums[i]) continue;
			int j = i + 1, k = nums.length - 1;
			while(j < k) {
				if(nums[i] + nums[j] + nums[k] == 0) {
					result.add(Arrays.asList(nums[i], nums[j], nums[k]));
					j++;
					k--;
					while(j < k && nums[j-1] == nums[j]) j++;
					while(j < k && nums[k+1] == nums[k]) k--;
				} else if(nums[i] + nums[j] + nums[k] < 0) {
					j++;
				} else {
					k--;
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeSum15 ts = new ThreeSum15();
		int[] nums = {-2, 0, 2, -2, 4, -1, 1, 2};
		List<List<Integer>> result = ts.threeSum(nums);
		for(List<Integer> list : result) {
			for(Integer i : list) {
				System.out.print(i + ",");
			}
			System.out.println("");
		}
		
	}

}
