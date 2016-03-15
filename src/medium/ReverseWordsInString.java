package medium;

import java.util.Stack;

public class ReverseWordsInString {
		
	/**
	 * stack, run time is too big
	 * @param s
	 * @return
	 */
	/*
	   public String reverseWords(String s) {
			Stack<String> stack = new Stack<String>();
			String tmp = "";
			int start = 0;
			while(start < s.length() && s.charAt(start) == ' ') {
			    start++;
			}
			for(int i = start ; i < s.length(); i++) {
				if(s.charAt(i) != ' ') {
					tmp += s.charAt(i);
				} else {
				    if(!tmp.equals("")) {
					    stack.push(tmp);
					    tmp = "";
				    }
				}
			}
			if(!tmp.equals("")) stack.push(tmp);
			String result = "";
			while(!stack.isEmpty()) {
				result += stack.pop();
				if(!stack.isEmpty()) {
				    result += " ";
				}
			}
			return result;        
	    }
	    */
	public String reverseWords(String s) {
		String[] arr = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for(int i = arr.length - 1; i >= 0; i--) {
			if(!arr[i].isEmpty()) {
				sb.append(arr[i]);
				if(i != 0) {
					sb.append(" ");
				}
			} 
		}
		return sb.toString(); 
		
	}
	
	public void reverseWords(char[] s) {
		if(s == null || s.length == 0) {
			return;
		}
		int begin = 0;
		int end = -1;
		//reverse every word
		for(int i = 0; i < s.length; i++) {
			if(s[i] == ' ' || i == s.length - 1) {
				end = (s[i] == ' ') ? i - 1 : i;
				reverse(s, begin, end);
				begin = i + 1;
			}
		}
		reverse(s, 0, s.length - 1);
	}
	
	private void reverse(char[] s, int start, int end) {
		while(start < end) {
			char tmp = s[start];
			s[start] = s[end];
			s[end] = tmp;
			start++;
			end--;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseWordsInString re = new ReverseWordsInString();
		String str = "is sky";
		char[] chars = str.toCharArray();
		re.reverseWords(chars);
		System.out.print(chars.toString());
	}

}
