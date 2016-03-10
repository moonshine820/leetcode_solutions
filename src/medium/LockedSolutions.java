package medium;

public class LockedSolutions {
	/**
	 * 280 wiggle-sort
	 * @param nums
	 */
    public void wiggleSort(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if(i%2 == 1) {
                if(nums[i - 1] > nums[i]) {
                    swap(nums, i - 1, i);
                }
            }
            if(i != 0 && (i%2 == 0)) {
                if(nums[i - 1] < nums[i]) {
                    swap(nums, i - 1, i);
                }
            }
        }
    }
    
    private void swap(int[] nums, int m, int n) {
        int tmp = nums[m];
        nums[m] = nums[n];
        nums[n] = tmp;
    }
    
    
}
