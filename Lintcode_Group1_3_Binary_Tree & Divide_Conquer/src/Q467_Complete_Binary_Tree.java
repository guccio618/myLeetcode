import java.util.LinkedList;
import java.util.Queue;


public class Q467_Complete_Binary_Tree {
	/******************************************************
	 * 关于二叉树需要记录顺序的，可以用两个队列或堆栈，一个记录正常的顺序，
	 * 包括null, 另一个记录不含null的，最后将结点逐一进行比较，如果期间
	 * 有不同的，则返回false
	 ******************************************************/ 
	// by Jackie
	public boolean isComplete(TreeNode root) {
        // Write your code here
        if(root == null){
            return true;
        }
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();
        q1.add(root);
        q2.add(root);
        
        while(!q1.isEmpty()){
            TreeNode node1 = q1.poll();
            TreeNode node2 = q2.poll();
            if(node1 != node2){
            	return false;
            }
            if(node1.left != null)
            	q1.add(node1.left);
            if(node1.right != null)
            	q1.add(node1.right);
            q2.add(node2.left);
            q2.add(node2.right);
        }
        return true;
    }
	
	
	public static void main(String[] args){
		Q467_Complete_Binary_Tree t = new Q467_Complete_Binary_Tree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		System.out.println(t.isComplete(root));
	}
}
