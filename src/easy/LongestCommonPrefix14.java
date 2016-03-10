package easy;

public class LongestCommonPrefix14 {

    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++) {
            String tmpCommon = "";
            for(int j = 0; (j < strs[i].length()) && (j < prefix.length()); j++) {
                if(strs[i].charAt(j) != prefix.charAt(j)) {
                     prefix = tmpCommon;
                     break;
                } else {
                    tmpCommon += prefix.charAt(j);
                } 
            }
        } 
        return prefix;
     }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"string", "strea", "stear"};
		System.out.println(longestCommonPrefix(strs));
		
	}

}
