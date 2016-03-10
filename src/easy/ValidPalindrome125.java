package easy;

public class ValidPalindrome125 {
	public boolean isPalindrome(String s) {
		int i = 0, j = s.length() - 1;
		while(i < j) {
			if(!Character.isLetterOrDigit(s.charAt(i))) {
				i++;
			} else if(!Character.isLetterOrDigit(s.charAt(j))){
				j--;
			} else {
				if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
					return false;
				} 
				i++;
				j--;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		ValidPalindrome125 vp = new ValidPalindrome125();
		String s = "0P";
		System.out.println(vp.isPalindrome(s));
	}

}
