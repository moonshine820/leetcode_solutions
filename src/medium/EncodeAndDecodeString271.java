package medium;
import java.util.*;

/**
 * Design an algorithm to encode a list of strings to a string. 
 * The encoded string is then sent over the network and is decoded back to the original list of strings.
 * Note:
 * The string may contain any possible characters out of 256 valid ascii characters. 
 * Your algorithm should be generalized enough to work on any possible characters.
 * Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
 * Do not rely on any library method such as eval or serialize methods. You should implement your own encode/decode algorithm.
 * @author miao
 *
 */
public class EncodeAndDecodeString271 {
	
	/**
	 * result string format: str length + "#" + str
	 * if str is null, it will be "-1#"
	 * @param strs
	 * @return
	 */
	public String encode(List<String> strs) {
		StringBuilder res = new StringBuilder();
		for(String str : strs) {
			//no need to handle the null case separately.
			res.append(str.length() + "#" + str);
		}
		return res.toString();
	}
	
	/**
	 * Decode process: iterator the string by char. Find the first '#'.
	 * Then get the whole substring, so no need to care what the string include, even space or another '#'
	 * Every time jump to the len char position, and then j++ to find the '#'.
	 * And so on. 
	 * @param str
	 * @return
	 */
	public List<String> decode(String str) {
		List<String> list = new ArrayList<String>();
		if(str == null) {
			return list;
		}
		for(int i = 0, j = 0; j < str.length();) {
			if(str.charAt(j) == '#') {
				int len = Integer.parseInt(str.substring(i, j));
				list.add(str.substring(j + 1, j + len + 1));
				i = j + len + 1;
				j = i;
			} else {
				j++; 
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		EncodeAndDecodeString271 ead = new EncodeAndDecodeString271();
		List<String> list = new ArrayList<String>();
		list.add("");
		list.add("ab #");
		list.add("5#");
		String result = ead.encode(list);
		
		System.out.println("The encode result is :" + result);
		
		List<String> resultList = ead.decode(result);
		System.out.print("The decode result is :");
		for(String str : resultList) {
			System.out.print(str + ",");
		}
	}
}
