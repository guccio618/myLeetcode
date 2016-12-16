
public class Li_087_Remove_Node_in_Binary_Search_Tree {
	/*********************************************************************
	 * BST中删除一个结点的步骤：
	 *  (1). 设立一个dummy结点，防止所要删除的结点为root结点
	 * 	(2). 先找到这个结点，以及这个结点的parent
	 * 	(3). 确定要删除的结点是其parent的左或右子树
	 *  (4). 删除结点的时候，类似红黑树的操作 
	 *      
	 *********************************************************************/
	
	public TreeNode removeNode(TreeNode root, int value) {
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        
        TreeNode parent = findNode(dummy, root, value);
        TreeNode node;
        
        // 要删除的结点是parent的左子树
        if (parent.left != null && parent.left.val == value) {            
            node = parent.left;
        } 
        // 要删除的结点是parent的右子树
        else if (parent.right != null && parent.right.val == value) {   
            node = parent.right;
        } 
        // 没找到
        else {
            return dummy.left;                                            
        }
        
        deleteNode(parent, node);
        
        return dummy.left;
    }
    
	// 寻找所要删除的结点的parent
    private TreeNode findNode(TreeNode parent, TreeNode node, int value) {
        if (node == null) {
            return parent;
        } else if (node.val == value) {
            return parent;
        }
        
        if (value < node.val) {    // 此结点在左子树中
            return findNode(node, node.left, value);
        } else {                   // 此结点在右子树中
            return findNode(node, node.right, value);
        }
    }
    
    private void deleteNode(TreeNode parent, TreeNode node) {
    	// 所要删除的node无右子树时
        if (node.right == null) {         
            if (parent.left == node) {
                parent.left = node.left;
            } else {
                parent.right = node.left;
            }
        } 
        // 所要删除的node有右子树时
        else {                          
            TreeNode temp = node.right;
            TreeNode father = node;
            
            // 寻找右子树中的最左边叶子结点，即最小值
            while (temp.left != null) {   
                father = temp;
                temp = temp.left;
            }
            
            if (father.left == temp) {
                father.left = temp.right;
            } else {
                father.right = temp.right;
            }
            
            if (parent.left == node) {
                parent.left = temp;
            } else {
                parent.right = temp;
            }
            
            temp.left = node.left;
            temp.right = node.right;
        }
    }
}
