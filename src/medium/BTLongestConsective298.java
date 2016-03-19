package medium;

public class BTLongestConsective298 {
	
	private int max = 0;//record the longest consective substree
	
    public int longestConsecutive(TreeNode root) {
        if(root == null) {
        	return 0;
        }       
        dfs(root, 0, root.val);      
        return max;
    }
    
    /**
     * dfs treenode, if root's value bigger than its parent, add this to the subtree.
     * if it doesn't, length become to 1.
     * @param root  current treenode
     * @param curr  record current consective substree length
     * @param target current root value
     * @return
     */
    public void dfs(TreeNode root, int curr, int target) {
    	if(root == null) {
    		return;
    	}
    	if(root.val == target) {
    		curr++;
    	} else {
    		curr = 1;
    	}
    	max = Math.max(max, curr);
    	dfs(root.left, curr, root.val + 1);
    	dfs(root.right, curr, root.val + 1);   	
    }
    
    public static void main(String[] args) {
    	BTLongestConsective298 longestCon = new BTLongestConsective298();
    	TreeNode root = new TreeNode(5);
    	root.left = new TreeNode(7);
    	root.left.left = new TreeNode(9);
    	root.right = new TreeNode(8);
    	System.out.print(longestCon.longestConsecutive(root));
    }
}

/**
 * Definition for a binary tree node.
 *  */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
