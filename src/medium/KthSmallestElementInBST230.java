package medium;

public class KthSmallestElementInBST230 {
	
	int num = 0;
	int count = 0;
	public int kthSmallest(TreeNode root, int k) {
		count = k;
		dfs(root);
		return num;
	}
	
	public void dfs(TreeNode n) {
		if(n.left != null) dfs(n.left);
		count--;
		if(count == 0) {
			num = n.val;
			return;
		}
		if(n.right != null)  dfs(n.right);
	}
	
	public static void main(String[] args) {
		KthSmallestElementInBST230 kse = new KthSmallestElementInBST230();
		TreeNode n = new TreeNode(5);
		kse.kthSmallest(n, 1);
	}
}
