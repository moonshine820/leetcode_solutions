package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FourSum18 {
	
	public List<List<Integer>> fourSum(int[] nums, int target) {
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(nums == null || nums.length < 4) {
			return result;
		}
		Arrays.sort(nums);
		
		for(int i = 0, L = nums.length; i < L - 3; i++) {
			if(i > 0 && nums[i-1] == nums[i]) continue;
			for(int j = i + 1; j < L - 2; j++) {
				if(j > i + 1 && nums[j-1] == nums[j]) continue;
				int low = j + 1;
				int high = L - 1;
				while(low < high) {
					int sum = nums[low] + nums[high] + nums[i] + nums[j];
					if( sum == target) {
						while(low < high && nums[low + 1] == nums[low]) low++;
						while(low < high && nums[high - 1] == nums[high]) high--;						
						result.add(Arrays.asList(nums[i], nums[j], nums[low],nums[high]));
						System.out.println(i + "," + j + "," + low + "," + high);
						low++;
						high--;

					} else if(sum > target){
						high--;
					} else {
					    low++;    
					}
				}
			}
		}
		return result;	
		/**
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		Arrays.sort(nums);
		for(int i = 0; i< nums.length; i++) {
		    if(map.containsKey(nums[i])) {
		        map.get(nums[i]).add(i);
		    } else {
		        List<Integer> list = new ArrayList<Integer>();
		        list.add(i);
		        map.put(nums[i], list);
		    }
		}
		for(int i = 0; i < nums.length - 2; i++) {
			int j = i + 1, k = nums.length - 1;
			while(j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if(map.containsKey(target - sum)) {
					for(int m : map.get(target-sum)) {
						if(m > j && m < k) {
							result.add(Arrays.asList(nums[i], nums[j], target-sum, nums[k]));
						}
					}
				}
				//can't handle the pointer move foward or backword; it's wrong.
				if(sum >= target) {
					k--;
				} else {
					j++;
				}
	 		return result;
		*/
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FourSum18 ts = new FourSum18();
		int[] nums = {-5, -4, -2, -2, -2, -1, 0, 0, 1};
		List<List<Integer>> result = ts.fourSum(nums, -9);
		for(List<Integer> list : result) {
			for(Integer i : list) {
				System.out.print(i + ",");
			}
			System.out.println("");
		}
	}

}
