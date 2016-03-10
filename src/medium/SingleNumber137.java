package medium;

public class SingleNumber137 {
	
	public static int singleNumber(int[] A) {
	    int ones = 0, twos = 0;
	    for(int i = 0; i < A.length; i++){
	        ones = (ones ^ A[i]) & ~twos;
	        twos = (twos ^ A[i]) & ~ones;
	    }
	    return ones;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {9,8,7,9,7,7,9};
		System.out.print(singleNumber(A));
	}

}
