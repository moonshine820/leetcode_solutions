package medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;



public class MediumQuestions {
	
	
	public boolean validTree(int n, int[][] edges) {
		int[] nums = new int[n];
		Arrays.fill(nums, -1);
		
		for(int i = 0; i < edges.length; i++) {
			int x = findEdge(nums, edges[i][0]);
			int y = findEdge(nums, edges[i][1]);
			
			if(x == y) {
				return false;
			}
			
			nums[x] = y;
		}
		
		return edges.length == n - 1;
	}
	
	public int findEdge(int nums[], int i) {
		if(nums[i] == -1) {
			return i;
		}
		return findEdge(nums, nums[i]);
	}
	
	
	public int countComponents(int n, int[][] edges) {
	    int[] roots = new int[n];
	    for(int i = 0; i < n; i++) roots[i] = i; 

	    for(int[] e : edges) {
	        int root1 = find(roots, e[0]);
	        int root2 = find(roots, e[1]);
	        if(root1 != root2) {      
	            roots[root1] = root2;  // union
	            n--;
	        }
	    }
	    return n;
	}

	public int find(int[] roots, int id) {
	    while(roots[id] != id) {
	        roots[id] = roots[roots[id]];  // optional: path compression
	        id = roots[id];
	    }
	    return id;
	}

	public void solve(char[][] board) {
		if(board == null || board.length <= 1 || board[0].length <= 1) {
			return;
		}
		
		int rows = board.length;
		int cols =  board[0].length;
		
		for(int i=0; i<rows; i++) {
			if(board[i][0] == '0') {
				helper(board, i, 0);
			}
			if(board[i][cols-1] == '0') {
				helper(board, i, cols - 1);
			}
		}
		
		for(int i=0; i < rows; i++) {
			for(int j=0; j<cols; j++) {
				if(board[i][j] == 'I') {
					board[i][j] = '0';
				} else if(board[i][j] == '0') {
					board[i][j] = 'X';
				}
			}
		}
		
		for(int i = 0; i < rows; i++) {
			for(int j=0; j < cols; j++) {
				System.out.print(board[i][j] + ", ");
			}
		}
	}
	
	public void helper(char[][] board, int r, int c) {
		board[r][c] = 'I';
		if(r-1 > 0 && board[r-1][c] == '0') {
			helper(board, r-1, c);
		}
		if(r+1<board.length-1 && board[r+1][c] == '0') {
			helper(board, r+1, c);
		}
		if(c+1 < board[0].length - 1 && board[r][c+1] == '0') {
			helper(board, r, c+1);
		}
		if(c-1>0 && board[r][c-1] == '0') {
			helper(board, r, c-1);
		}
	}
	
	/**
	 * 2016/02/24
	 * 113. Path Sum 2
	 */
	private List<List<Integer>> result = new ArrayList<List<Integer>>();
	
	public List<List<Integer>> findPath(TreeNode root, int sum) {
		if(root == null) {
			return result;
		}
		Stack<Integer> stack = new Stack<Integer>();
		findAllPath(root, sum, stack);
		return result;
	}
	
	public void findAllPath(TreeNode root, int sum, Stack<Integer> stack) {
		sum = sum - root.val;
		stack.push(root.val);
		if(sum == 0 && root.left == null && root.right == null) {
			result.add(new ArrayList<Integer>(stack));
		}
		if(root.left != null) {
			findAllPath(root.left, sum, stack);
		}
		if(root.right != null) {
			findAllPath(root.right, sum, stack);
		}
		stack.pop();
	}

	/**
	 * 199. Binary Tree Right Side View
	 * @param root
	 * @return
	 */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null) {
            return list;
        }
        rightView(root, 0, list);
        
        return list;
    }
    
    public void rightView(TreeNode root, int level, List<Integer> list) {
        if(root == null) {
            return;
        }
        if(level == list.size()) {
            list.add(root.val);
        }
        rightView(root.right, level+1, list);
        rightView(root.left, level+1, list); //why do this???
    }
    
    private int[] father;
	public int countComponents2(int n, int[][] edges) {
	
	    Set<Integer> set = new HashSet<Integer>();
	    father = new int[n];
	    for (int i = 0; i < n; i++) {
	        father[i] = i;
	    }
	    for (int i = 0; i < edges.length; i++) {
	         union(edges[i][0], edges[i][1]);
	    }
	
	    for (int i = 0; i < n; i++){ 
	        set.add(find(i));
	    }
	    return set.size();
	}
	
	int find(int node) {
	    if (father[node] == node) {
	        return node;
	    }
	    father[node] = find(father[node]);
	    return father[node];
	}
	
	void union(int node1, int node2) {
	    father[find(node1)] = find(node2);
	} 
	
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length == 0) {
            return numbers;
        }
        int[] result = new int[2];       
        
        for(int i = 0; i < numbers.length; i++) {
        	int left = i;
        	int right = numbers.length - 1;
            int tmp = target - numbers[left];
            while(left <= right) {
                int mid = (left + right) /2;
                if(tmp == numbers[mid]) {
                    result[0] = i + 1;
                    result[1] = mid + 1;
                    return result;
                } else if(tmp > numbers[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return result;
    }	
    /**
     * 78. Subsets
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
    	
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) {
            return list;
        }
        
        Arrays.sort(nums);
        list.add(new ArrayList<Integer>());
        for(int i = 0; i < nums.length; i++) {
            int size = list.size();
            int j = 0;
            while(j < size) {
                List<Integer> arr = new ArrayList<Integer>();
                arr.addAll(list.get(j));
                arr.add(nums[i]);
                list.add(arr);
                j++;
            }
        }
        return list;
    }
    
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		MediumQuestions mq = new MediumQuestions();
		
		int[] nums = {2,3,4,5};
		//mq.twoSum(nums, 6);
		List<List<Integer>> lists = mq.subsets(nums);
		for(List<Integer> list : lists) {
			for(int i : list) {
				System.out.print(i + ",");
			}
			System.out.println("");
		}
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
		TreeNode right = new TreeNode(4);
		root.right = right;
		right.right = new TreeNode(1);
		mq.rightSideView(root);
		int[][] arr = {{0,1},{1,2},{2,3},{3,4}};
		mq.countComponents(5, arr);
		//mq.findPath(root, 5);
		//int[][] edges = {{1,2},{3,4},{0,1},{2,4},{2,3}, {0,4}};
		//int n = 5;
		//System.out.println(mq.countComponents(n, edges));
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
