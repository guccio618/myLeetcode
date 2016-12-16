/******
 *
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a 
constant space solution?

 * 
 * */

public class Le_099_Recover_Binary_Search_Tree {
	/***********************************************
	 * 递归版的前序遍历的结构：
	 * 	travel(node.left)
	 * 		...一些列操作
	 * 	travel(node.right);
	 * 
	 ***********************************************/	
	
	private TreeNode firstElement = null;   // 给定初始值null, 用于后续判断
    private TreeNode secondElement = null;  // 给定初始值null, 用于后续判断
    private TreeNode preElement = new TreeNode(Integer.MIN_VALUE);  // preElement初始值给最小，防止[0, 1]的情况
	
	public void recoverTree(TreeNode root) {
		if(root == null) {
            return ;
        }
        
        inorder(root);
        
        if(firstElement != null && secondElement != null) {
            int temp = firstElement.val;
            firstElement.val = secondElement.val;
            secondElement.val = temp;
        }
    }
    
    public void inorder(TreeNode node){
        if(node == null){
            return;
        }
        
        inorder(node.left);
        
        if(firstElement == null && node.val < preElement.val){  // 找到第一个元素
            firstElement = preElement;
        }                                                       // 注意，这里用firstElement != null
        if(firstElement != null && node.val < preElement.val){  // 找到第二个元素, 不用else, 防止[0, 1]的情况
            secondElement = node;     // 此处不可以用return，因为不用else，因此两个if有可能在同一次递归里被调用
        }
        
        preElement = node;    // 执行完后才进行preElement的update， 等同于操作之后，进行node = node.next
        inorder(node.right);
    }
}
