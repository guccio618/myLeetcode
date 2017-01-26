/**********
 * 
Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.

 * 
 * */

public class Q404_Sum_of_Left_Leaves {
	private int sum = 0;
    
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        DFS(root, false);
        return sum;
    }
    
    public void DFS(TreeNode node, boolean leftFlag) {
        if (node == null) {
            return ;
        }
        
        if (leftFlag == true && node.left == null && node.right == null) {
            sum += node.val;
        }
        
        DFS(node.left, true);
        DFS(node.right, false);
    } 
}
