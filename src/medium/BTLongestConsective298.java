package medium;

public class BTLongestConsective298 {
	
	private int max = 0;//record the longest consective substree
	
    public int longestConsecutive(TNode root) {
        if(root == null) {
        	return 0;
        }       
        dfs(root, 0, root.val);      
        return max;
    }
    
    /**
     * dfs treenode, if root's value bigger than its parent, add this to the subtree.
     * if it doesn't, length become to 1.
     * @param root  current TNode
     * @param curr  record current consective substree length
     * @param target current root value
     * @return
     */
    public void dfs(TNode root, int curr, int target) {
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
    	TNode root = new TNode(5);
    	root.left = new TNode(7);
    	root.left.left = new TNode(9);
    	root.right = new TNode(8);
    	System.out.print(longestCon.longestConsecutive(root));
    }
}

/**
 * Definition for a binary tree node.
 *  */
class TNode {
	int val;
	TNode left;
	TNode right;
	TNode(int x) { val = x; }
}
