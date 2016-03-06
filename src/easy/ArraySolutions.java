package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class ArraySolutions {
	
	/**
	 * 2016/02/22
	 */
    private HashMap<String, List<String>> map = new HashMap<String, List<String>>();
    public void ValidWordAbbr(String[] dictionary) {
        for(int i=0; i < dictionary.length; i++) {
        	String temp = dictionary[i];
        	String abb;
        	int nums = temp.length() - 2;
 
            if(nums > 0) {
            	Character first = temp.charAt(0);
            	Character last = temp.charAt(dictionary[i].length() - 1);
                abb = first.toString() + nums + last;
            } else {
            	abb = dictionary[i];
            }
	        if(map.containsKey(abb)) {
	            map.get(abb).add(temp);
	        } else {
	            map.put(abb, new ArrayList<String>());
	            map.get(abb).add(temp);
	        }
        }
    }

    public boolean isUnique(String word) {
    	if(map.isEmpty() || word.equals("")) {
    		return true;
    	}
    	int len = word.length() - 2;
    	String temp;
    	if(len > 0) {
            Character first = word.charAt(0);
            temp = first.toString() + len + word.charAt(word.length() - 1);   		
    	} else {
    		temp = word;
    	}
    	if(map.containsKey(temp)) {
    		for(String i : map.get(temp)) {
    			if(!i.equals(word)) {
    				return false;
    			}
    		}
    	}
        return true; 
    }
   
	/**
	 * 2016/02/22
	 * 325. Maximum Size Subarray Sum Equals k
	 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. 
	 * If there isn't one, return 0 instead.
	 * @param nums
	 * @param k
	 * @return
	 */
	
	public int maxSubArrayLen(int[] nums, int k) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = 0;
		int result = 0;
		map.put(sum, -1); // handle the case that first two numbers sums 0.
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if(map.containsKey(sum - k)) {
				result = Math.max(i - map.get(sum - k), result);
			}
			if(!map.containsKey(sum)) {
				map.put(sum, i);
			}
		}
		
		return result;
	}
	
	/**
	 * 02／23
	 * Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
	 * For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
	 * Return:
	 * [
	 *    ["abc","bcd","xyz"],
	 *	  ["az","ba"],
	 *	  ["acef"],
	 *	  ["a","z"]
	 * ]
	 * tips: 要找准规则
	 * @param strings
	 * @return
	 */
	public List<List<String>> groupString(String[] strings) {
		if(strings == null || strings.length == 0) {
			return null;
		}
		List<List<String>> result = new ArrayList<List<String>>();
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		for(String str : strings) {
			int offset = str.charAt(0) - 'a';
			String key = "";
			for(int i = 0; i < str.length(); i++) {
				char c = (char)(str.charAt(i) - offset);
				if(c < 'a') {
					c += 26;
				}
				key += c;
			}
				
			if(!map.containsKey(key)) {
				List<String> list = new ArrayList<String>();
				map.put(key, list);
			}
			map.get(key).add(str);
		}
		
		for(String key : map.keySet()) {
			List<String> list = map.get(key);
			Collections.sort(list);
			result.add(list);
		}
		return result;
	}
	
	/**
	 * 276 Paint Fence 
	 * There is a fence with n posts, each post can be painted with one of the k colors.
	 * You have to paint all the posts such that no more than two adjacent fence posts have the same color.
	 * Return the total number of ways you can paint the fence.
	 */	
	public int numWays(int n, int k) {
		if(n == 0 || k == 0) {
			return 0;
		}
		
		int a = 0, b = k;
		
		for(int i = 2; i <= n; i++) {
			int tmp = a;
			a = b;
			b = (k-1) * (tmp + b);
		}
		return a + b;
	}
	
	 public int numWays2(int n, int k) {
		    if (n == 0 || k == 0) return 0;
		    if (n == 1) return k;
		    // same[i] means the ith post has the same color with the (i-1)th post.
		    int[] same = new int[n];
		    // diff[i] means the ith post has a different color with the (i-1)th post.
		    int[] diff = new int[n];
		    same[0] = same[1] = k;
		    diff[0] = k;
		    diff[1] = k * (k - 1);
		    for (int i = 2; i < n; ++i) {
		        same[i] = diff[i-1];
		        diff[i] = (k - 1) * same[i-1] + (k - 1) * diff[i-1];
		    }
		    return same[n-1] + diff[n-1];
		}
	 
	 public int numWays3(int n, int k) {
		 if(n == 0 || k == 0) return 0;
		 if(n == 1) return k;
		 
		 int diffCounts = k * (k-1);
		 int sameCounts = k;
		 
		 for(int i = 2; i < n; i++) {
			 int temp = diffCounts;
			 diffCounts = (diffCounts + sameCounts) * (k - 1);
			 sameCounts = temp;
		 }
		 return diffCounts + sameCounts;
	 }

	 /**
	  * 170. Two Sum III - Data structure design
	  * Design and implement a TwoSum class. It should support the following operations: add and find.
	  * add - Add the number to an internal data structure.
	  * find - Find if there exists any pair of numbers which sum is equal to the value.
	  * tip: 需要优化
	  */
	    HashMap<Integer, Integer> map170 = new HashMap<Integer, Integer>();                  
	    // Add the number to an internal data structure.
		public void add(int number) {
		    if(map170.containsKey(number)) {
		        map170.put(number, map170.get(number) + 1);
		    } else {
		        map170.put(number, 1);
		    }
		    Stack<String> s = new Stack<String>();
		}
		
	    // Find if there exists any pair of numbers which sum is equal to the value.
		public boolean find(int value) {
		    for(int num : map170.keySet()) {
		        if(map170.containsKey(value - num)) {
		            if(num == (value - num) && map170.get(num) < 2) {
		                return false;
		            } else {
		                return true;
		            }
		        }
		    }
		    return false;
		}	 
		
	    private List<List<Integer>> result = new ArrayList<List<Integer>>();
	    public List<List<Integer>> levelOrder(TreeNode root) {
	        if(root == null) {
	            return result;
	        }
	        Queue<TreeNode> queue = new LinkedList<TreeNode>();
	        queue.offer(root);
	        while(!queue.isEmpty()) {
	            int size = queue.size();
	            List<Integer> list = new ArrayList<Integer>();
	            for(int i = 0; i < size; i++) {
	                TreeNode peek = queue.poll();
	                list.add(peek.val);
	                if(peek.left != null) {
	                    queue.offer(peek.left);
	                }
	                if(peek.right != null) {
	                    queue.offer(peek.right);
	                }
	            }
	            result.add(list);
	        }
	        return result;
	    }

		/**
		 * 66. Plus One
		 */
		public int[] plusOne(int[] digits) {
			for(int i = digits.length - 1; i >= 0; i--) {
				if(digits[i] != 9) {
					digits[i]++;
					break;
				} else {
					digits[i] = 0;
				}
			}
			if(digits[0] == 0) {
				int[] res = new int[digits.length + 1]; //elements of new array are all 0.
				res[0] = 1;
				return res;
			}
			return digits;
		}
		
		public boolean isValidSudoku(char[][] board) {
			for(int i = 0; i<9; i++) {
				HashSet<Character> rows = new HashSet<Character>();
				HashSet<Character> columns = new HashSet<Character>();
				HashSet<Character> cube = new HashSet<Character>();
				for(int j = 0; j < 9; j++) {
					if(board[i][j] != '.' && rows.add(board[i][j]) == false) {
						return false;
					}
					if(board[j][i] != '.' && columns.add(board[j][i]) == false) {
						return false;
					}
					int RowIndex = 3 * (i / 3);
					int ColIndex = 3 * (i % 3);

					if(board[RowIndex + j/3][ColIndex + j%3] != '.' && cube.add(board[RowIndex + j/3][ColIndex + j%3]) == false) {
						return false;
					}
				}
			}
			return true;
		}
		
	    public static void main(String[] args) {
	    	
	    	ArraySolutions solutions = new ArraySolutions();
	    	
			/**
			 * 66. Plus One
			 */
			char[] r1 = {'4','6','3','7','2','8','9','5','1'};
			char[] r2 = {'2','5','9','4','6','1','7','3','8'};
			char[] r3 = {'7','8','1','3','5','9','6','4','2'};
			char[] r4 = {'5','3','2','1','9','7','4','8','6'};
			char[] r5 = {'9','1','4','6','8','2','5','7','3'};
			char[] r6 = {'6','7','8','5','4','3','1','2','9'};
			char[] r7 = {'8','2','6','9','7','5','3','1','4'};
			char[] r8 = {'1','4','7','2','3','6','8','9','5'};
			char[] r9 = {'3','9','5','8','1','4','2','6','7'};
			char[][] board = {r1,r2,r3,r4,r5,r6,r7,r8,r9};
			
			System.out.print(solutions.isValidSudoku(board));
			
	    	/**
	    	ListNode headA = new ListNode(3);
	    	ListNode headA1 = new ListNode(4);
	    	ListNode headA2 = new ListNode(2);
	    	ListNode headA3 = new ListNode(5);
	    	headA.next = headA1;
	    	headA1.next = headA2;
	    	headA2.next = headA3;
	    	
	    	ListNode headB = new ListNode(5);
	    	ListNode headB1 = new ListNode(6);
	    	ListNode headB2 = new ListNode(3);
	    	headB.next = headB1;
	    	headB1.next = headA2;
	    	System.out.println(solutions.getIntersectionNode(headA, headB));
	    	*/
	    	/**
	    	 * 170. Two Sum III - Data structure design
	    	 *
	    	eq.add(2);
	    	eq.add(3);
	    	eq.add(2);
	    	eq.add(4);
	    	System.out.println(solutions.find(8));
	    	*/
	    	
	    	/**
			TreeNode root = new TreeNode(3);
			root.left = new TreeNode(2);
			TreeNode right = new TreeNode(3);
			root.right = right;
			right.right = new TreeNode(1);  
			
	    	solutions.levelOrder2(root);
	    	*/
	    	/**
	    	 * 276 Paint Fence 
	    	 */
	    	//System.out.println(solutions.numWays2(4, 2));
	    	
	    	/**
	    	 * 249 group shifted strings
	    	String[] strings = {};
	    	List<List<String>> result = solutions.groupString(strings);
	    	for(List<String> list : result) {
	    		for(String str : list) {
	    			System.out.print(str + ", ");
	    		}
	    		System.out.println("");
	    	}
	    	*/
	    	
	    	/**325
	    	int[] nums = {-1, 1, -2, -5, 4, -1, 1};
	    	System.out.println(solutions.maxSubArrayLen(nums, -1));
	    	System.out.println(solutions.maxSubArrayLen(nums, 10));
	    	int[] nums1 = {1};
	    	System.out.println(solutions.maxSubArrayLen(nums1, 0));
	    	int[] nums2 = {};
	    	System.out.print(solutions.maxSubArrayLen(nums2, 0));
	    	*/
	    	
	    	/**
	    	String[] dic = {"dog"};
	    	eq.ValidWordAbbr(dic);    	
	    	System.out.println(solutions.isUnique("dug"));
	    	System.out.println(solutions.isUnique("dag"));
	    	System.out.println(solutions.isUnique("dog"));
	    	System.out.println(solutions.isUnique("djg"));
	    	*/
	    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int value) {
		this.val = value;
	}
}
