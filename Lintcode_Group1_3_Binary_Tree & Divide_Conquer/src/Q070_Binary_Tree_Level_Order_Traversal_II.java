import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Q070_Binary_Tree_Level_Order_Traversal_II {
	// by Jackie
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null){
        	return res;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        ArrayList<Integer> list = new ArrayList<Integer>();
        int num = 1;
        
        while(!q.isEmpty()){
        	TreeNode node = q.poll();
        	list.add(node.val);
        	if(node.left != null){
        		q.add(node.left);
        	}
        	if(node.right != null){
        		q.add(node.right);
        	}
        	if(--num == 0){
        		res.add(0, new ArrayList<Integer>(list));
        		list.clear();     		
        		num = q.size();
        	}
        }
        return res;
    }
	

	public static void main(String[] args){
		Q070_Binary_Tree_Level_Order_Traversal_II t = new Q070_Binary_Tree_Level_Order_Traversal_II();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		ArrayList<ArrayList<Integer>> res = t.levelOrderBottom(root);
		for(int i = 0; i < res.size(); ++i)
			System.out.print(res.get(i));
	}
}
