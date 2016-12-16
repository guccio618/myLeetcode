import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/******
 * 
Given a binary tree, collect a tree's nodes as if you were doing this: 
Collect and remove all leaves, repeat until the tree is empty.

Example:
Given binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Returns [4, 5, 3], [2], [1].

Explanation:
1. Removing the leaves [4, 5, 3] would result in this tree:

          1
         / 
        2          
2. Now removing the leaf [2] would result in this tree:

          1          
3. Now removing the leaf [1] would result in the empty tree:

          []         
Returns [4, 5, 3], [2], [1].
 * 
 * */

public class Q366_Find_Leaves_of_Binary_Tree {
	// solution 1: using map
	private Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        if(root == null){
            return ans;
        }
        
        int maxDepth = DFS(root);
        
        for(int i = 1; i <= maxDepth; i++){
            ans.add(new ArrayList<Integer>(map.get(i)));
        }
        
        return ans;
    }
    
    public int DFS(TreeNode node){
        if(node == null){
            return 0;
        }
        
        int leftDepth = DFS(node.left);
        int rightDepth = DFS(node.right);
        int curDepth = Math.max(leftDepth, rightDepth) + 1;
        
        if(map.containsKey(curDepth)){
            map.get(curDepth).add(node.val); 
        } else {
            List<Integer> list = new ArrayList<Integer>();
            list.add(node.val);
            map.put(curDepth, list);
        }
        
        return curDepth;
    }
    
    
    
    // solution 2: using list
    public List<List<Integer>> findLeaves2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        if (root == null) {
            return ans;
        }
        
        DFS(root, ans);
        return ans;
    }
    
    public int DFS(TreeNode node, List<List<Integer>> ans) {
        if(node == null) {
            return -1;
        }
        
        int leftDepth = DFS(node.left, ans);
        int rightDepth = DFS(node.right, ans);
        int currentDepth = Math.max(leftDepth, rightDepth) + 1;
        
        if(ans.size() - 1 < currentDepth) {
            ans.add(new ArrayList<Integer>());
        }
        
        ans.get(currentDepth).add(node.val);
        return currentDepth;
    }
}
