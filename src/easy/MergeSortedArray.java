package easy;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int curr1 = m - 1, curr2 = n - 1, start = m + n - 1;
        while(curr1 >= 0 && curr2 >= 0) {
            if(nums1[curr1] < nums2[curr2]) {
                nums1[start--] = nums2[curr2--];
            } else {
                nums1[start--] = nums1[curr1--];
            }
        }
        if(curr1 <= 0) {
            while(curr2 >= 0) nums1[start--] = nums2[curr2--];
        }    
    }
	public static void main(String[] args) {
		MergeSortedArray mergeSortedArray = new MergeSortedArray();
		int[] nums1 = {4,5,6,0,0,0};
		
		int[] nums2 = {1,2,3};
		mergeSortedArray.merge(nums1, 3, nums2, 3);
		for(int i : nums1) {
			System.out.print(i + ",");
		}
	}

}
