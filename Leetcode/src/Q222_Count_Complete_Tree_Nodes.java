public class Q222_Count_Complete_Tree_Nodes {
	/*********************************
	 * 按左右子树进行划分，斜着拆分 
	 * 
	 *********************************/
	// by other, simple.
	
	public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        int count = 0;
        int treeHeight = getHeight(root);
        
        while(root != null){
            int rightHeight = getHeight(root.right);
            
            if(rightHeight == treeHeight - 1){       // Left is full and height of left is h - 1 and has h levels. Add left plus root, 2^h - 1 + 1.
                count += (1 << treeHeight - 1);      // 2^(h) - 1 + 1
                root = root.right;
            } else {                                 // Right is full and height of right is h - 2 and has h - 1 levels. Add right plus root 2^(h-1) - 1 + 1.
                count += (1 << rightHeight);
                root = root.left;
            }
            treeHeight--;                            // 需要注意每次循环里h要--
        }
        
        return count;
    }
	
	public int getHeight(TreeNode node){
        if(node == null){
            return 0;
        }
        
        return getHeight(node.left) + 1;             // 树的高度一定等于左子树的高度 ！！！
    }
	

	/****************************************
	 * 先算level 1到 last-1，再算last level *
	 ****************************************/
	// by other, fast
	public int countNodes2(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null)
			return 1;
		int height = 0;
		int nodesSum = 0;
		TreeNode curr = root;
		while (curr.left != null) {
			nodesSum += (1 << height);
			height++;
			curr = curr.left;
		}
		return nodesSum + countLastLevel(root, height);
	}

	private int countLastLevel(TreeNode root, int height) {
		if (height == 1) {
			if (root.right != null)
				return 2;
			else if (root.left != null)
				return 1;
			else
				return 0;
		}

		TreeNode midNode = root.left;
		int currHeight = 1;
		while (currHeight < height) {
			currHeight++;
			midNode = midNode.right;
		}
		if (midNode == null)
			return countLastLevel(root.left, height - 1);
		else
			return (1 << (height - 1)) + countLastLevel(root.right, height - 1);
	}
	

	/********************************
	 * 非二叉搜索 *
	 ********************************/
	// by Jackie, but exceed time limited
	public int countNodes3(TreeNode root) {
		if (root == null)
			return 0;
		int count = 1;
		if (root.left != null)
			count += countNodes3(root.left);
		if (root.right != null)
			count += countNodes3(root.right);
		return count;
	}
	
	
	
	public static void main(String[] args){
		Q222_Count_Complete_Tree_Nodes t = new Q222_Count_Complete_Tree_Nodes();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(1);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(1);
		System.out.println(t.countNodes(root));
		
	}
}
