import java.util.*;
/*****
 *
Given a binary tree, return the level order traversal of its nodes' values. 
(ie, from left to right, level by level).

For example:
	Given binary tree [3,9,20,null,null,15,7],

 * 
 * */

public class Q102_Binary_Tree_Level_Order_Traversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if(root == null) {
            return ans;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size = queue.size();
        List<Integer> list = new ArrayList<>();
        
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            
            if(node.left != null) {
                queue.offer(node.left);
            } 
            
            if(node.right != null) {
                queue.offer(node.right);
            }
            
            if(--size == 0) {
                size = queue.size();
                ans.add(new ArrayList<Integer>(list));
                list.clear();
            }
        }
        
        return ans;
     }
	
	
	
	
	
	
	
	
	
	
	
	/********************* main function **************************/	
	public static void main(String[] args){
		Q102_Binary_Tree_Level_Order_Traversal bt = new Q102_Binary_Tree_Level_Order_Traversal();
		TreeNode root = new TreeNode(1);
		List<List<Integer>> res = bt.levelOrder(root);
		for(int i = 0; i < res.size(); i++){
			for(int j = 0; j < res.get(i).size(); j++)
				System.out.print(res.get(i).get(j) + ", ");
			System.out.println();
		}
	}
}

