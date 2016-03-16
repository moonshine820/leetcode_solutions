package easy;
/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * @author miao
 * @date 03/15/2016
 *
 */
public class CountAndSay38 {
	public String countAndSay(int n) {
	    if (n <= 0) {
	    	return "";
	    }
	    String res = "1";
	    
	    //notice it's beginning from 1
	    for (int i = 1; i < n; i++) {
	        String pre = res;
	        res = "";
	        char temp = pre.charAt(0);
	        int count = 1;
	        for (int j = 1; j < pre.length(); j++) {
	            if (pre.charAt(j) != temp) {
	                res = res + count + temp;
	                temp = pre.charAt(j);
	                count = 1;
	            } else {
	                count++;
	            }
	        }
	        //add the last char
	        res = res + count + temp;
	    }
	    return res;
	}
	public static void main(String[] args) {
		CountAndSay38 cas = new CountAndSay38();
		System.out.println(cas.countAndSay(3));
		System.out.println(cas.countAndSay(1));
		System.out.println(cas.countAndSay(-1));
	}

}
