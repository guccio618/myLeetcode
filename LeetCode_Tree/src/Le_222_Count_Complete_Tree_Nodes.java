
public class Le_222_Count_Complete_Tree_Nodes {
	/*****************************************************
	 * 	利用二叉树的层数和结点数的关系
	 * 	 (1). 二分法
	 *      
	 *****************************************************/
	
	public int countNodes(TreeNode root) {		
        if(root == null){
            return 0;
        }
        
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        int count = 1;                             // 这里的count初始值为1, 因为最后一个叶子节点，left = right ＝ 0，
        										   // 不会在循环while被计算，因此需要在count里赋 1  ！！！      
        while(leftHeight > 0 || rightHeight > 0){
            if(leftHeight > rightHeight){
                count += 1 << (rightHeight);
                root = root.left;
            } else {
                count += 1 << (leftHeight);
                root = root.right;
            }
            
            leftHeight = getHeight(root.left);
            rightHeight = getHeight(root.right);
        }
        
        return count;
    }
    
    public int getHeight(TreeNode node){
        if(node == null){
            return 0;
        }
        return getHeight(node.left) + 1;    // 完全二叉树树高取决于左子树高，因此不需要再计算右子树高，重复计算 ！！！
    }
	
	
    
    /*************************************************/
    // by other, fast
	public int countNodes2(TreeNode root) {
        int h = getHeight(root);
        int count = 0;
        
        while(root != null){
            if(getHeight(root.right) == h - 1){
                count += (1 << h);
                root = root.right;
            } else{
                count += (1 << h - 1);
                root = root.left;
            }
            h--;
        }
        
        return count;
    }
    
    public int getHeight2(TreeNode node){
        if(node == null){
            return -1;
        }
        return getHeight(node.left) + 1;
    }
	
	
	
    
}
