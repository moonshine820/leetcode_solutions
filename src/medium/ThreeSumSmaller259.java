package medium;

import java.util.Arrays;

public class ThreeSumSmaller259 {
	public int threeSumSmaller(int[] nums, int target) {
		int triplets = 0;
		Arrays.sort(nums);
		for(int i = 0; i < nums.length - 2; i++) {
			int j = i + 1, k = nums.length - 1;
			while(j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if(sum >= target) {
					k--;
				} else{
					triplets = triplets + (k-j);
					j++;
				}
			}
		}
		return triplets;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeSumSmaller259 tss = new ThreeSumSmaller259();
		int[] nums = {3, 1, 0, -2};
		System.out.print(tss.threeSumSmaller(nums, 4));
	}

}
