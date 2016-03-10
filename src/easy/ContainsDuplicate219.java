package easy;

import java.util.HashMap;

public class ContainsDuplicate219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
            	System.out.println(map.get(nums[i]) + "," + i);
                if(i - map.get(nums[i]) <= k) {
                    return true;
                } else {
                    map.put(nums[i], i);
                }
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContainsDuplicate219 cd = new ContainsDuplicate219();
		int[] nums = {1,0,1,1};
		int k = 1;
		System.out.println(cd.containsNearbyDuplicate(nums, k));
	}

}
