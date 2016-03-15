package medium;

public class OneEditDistance161 {
 	public boolean isOneEditDistance(String s, String t) {
		int len = Math.min(s.length(),  t.length());
		for(int i = 0; i < len; i++) {
			if(s.charAt(i) != t.charAt(i)) {
			    if(s.length() == t.length()) {
			        return s.substring(i+1).equals(t.substring(i+1));
			    } else if(s.length() > t.length()) {
			        return s.substring(i + 1).equals(t.substring(i));
			    } else {
			        return s.substring(i).equals(t.substring(i+1));
			    }
				
			}
		}
		
		return Math.abs(s.length() - t.length()) == 1;
	}  
 	
 	public static void main(String[] args) {
 		OneEditDistance161 oed = new OneEditDistance161();

 		boolean result = oed.isOneEditDistance("a", "A");
 	}
}
