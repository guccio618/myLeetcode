import java.util.ArrayList;
import java.util.List;


public class Q376_Binary_Tree_Path_Sum {
	// by Jackie
	private List<List<Integer>> res = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        if(root == null){
            return res;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(list, root, target);
        return res;
    }
    
    public void helper(ArrayList<Integer> list, TreeNode node, int sum){
        if(node == null){
            return;
        }
        list.add(node.val);
        if(sum == node.val){
            res.add(new ArrayList<Integer>(list));
        }
        else{
            helper(list, node.left, sum - node.val);
            helper(list, node.right, sum - node.val);
        }
        list.remove(list.size()-1);
    }
}
