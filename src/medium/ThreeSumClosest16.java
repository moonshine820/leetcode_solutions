package medium;

import java.util.Arrays;

public class ThreeSumClosest16 {
	
	public int threeSumClosest(int[] nums, int target) {
		int leastDiff = Integer.MAX_VALUE;
		int closest = 0;
		Arrays.sort(nums);	
		for(int i = 0; i < nums.length - 2; i++) {
			if(i > 0 && nums[i-1] == nums[i]) continue;
			int j = i+1;
			int k = nums.length - 1;
			while(j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if(sum == target) {
					return sum;
				} 
				int diff = Math.abs(sum - target);
				if(diff < leastDiff) {
					leastDiff = diff;
					closest = sum;
				}
				if(sum > target) {
					k--;
				} else {
					j++;
				}
			}
		}
		return closest;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeSumClosest16 tc = new ThreeSumClosest16();
		int[] nums = {-1, 2, 1, -4};
		System.out.print(tc.threeSumClosest(nums, 1));
	}

}
