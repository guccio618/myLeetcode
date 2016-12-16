/*****
 * 
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.

Show Tags
Show Similar Problems

 * 
 * */

public class Le_129_Sum_Root_to_Leaf_Numbers {
private int totalSum = 0;
    
    public int sumNumbers(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        DFS(root, 0);
        return totalSum;
    }
    
    public void DFS(TreeNode node, int sum) {
        if(node == null) {
            return;
        } 
        
        sum = sum * 10 + node.val;
        
        if(node.left == null && node.right == null) {
            totalSum += sum;
            return;
        } else {
            DFS(node.left, sum);
            DFS(node.right, sum);
        }
    }
    
    
    
    
    
    /******************* main function ************************/   
    
    public static void main(String[] args){
    	Le_129_Sum_Root_to_Leaf_Numbers t = new Le_129_Sum_Root_to_Leaf_Numbers();
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(3);
    	root.left.left = new TreeNode(4);
    	root.left.right = new TreeNode(5);
    	root.right.left = new TreeNode(6);
    	root.right.right = new TreeNode(7);
    	System.out.println(t.sumNumbers(root));
    }
}
