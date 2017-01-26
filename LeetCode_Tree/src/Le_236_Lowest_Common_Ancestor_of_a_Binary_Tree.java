import java.util.ArrayList;
import java.util.List;
/***************
 * 
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as 
the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, 
since a node can be a descendant of itself according to the LCA definition.

 * 
 * */


public class Le_236_Lowest_Common_Ancestor_of_a_Binary_Tree {	
	/**********************************************************
	 * BT
	 * 	寻找公共祖先，找到时满足的条件应为：左子树也找到，右子树也找到，
	 * 	取决于左右子树的情况，因此考虑用Divide & Conquer
	 * 	分三种情况：
	 * 	(1). 在左，右子树上均找到，返回root，表示都找到，寻找结束。
	 * 	(2). 只在左子树中找到，返回找到的结点，回到上一层结点继续判断。
	 * 	(3). 只在右子树中找到，返回找到的结点，回到上一层结点继续判断。 
	 *      
	 **********************************************************/	
	
	// solution 1: using recursive
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
            return root;
		}
        
        // Divide
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // Conquer
        if (left != null && right != null)  // 同时找到p和q，返回root；在下次的迭代中，root的兄弟必为null,
            return root;                    // 如root在left, 则right必为null
        if (left != null && right == null)  // 只找到left
            return left;
        if (right != null && left == null)  // 只找到right
            return right;
        
        return null;   // left == null && right == null
	}
	
	
	
	
	// solution 2: using DFS
	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || p == null || q == null){
            return null;
        }    
        
        List<TreeNode> path1 = new ArrayList<TreeNode>();
        List<TreeNode> path2 = new ArrayList<TreeNode>();
        TreeNode ans = null;
        
        DFS(p, root, path1);
        DFS(q, root, path2);
        
        for(int i = 0; i < path1.size() && i < path2.size(); i++){
            TreeNode node1 = path1.get(i);
            TreeNode node2 = path2.get(i);
            
            if(node1 == node2){
                ans = node1;
            } else {
                break;
            }
        }
        
        return ans;
    }
    
	// 如果找到target, 则return，path不需要remove
	public boolean DFS(TreeNode current, TreeNode target, List<TreeNode> path){
        if(current == null){
            return false;
        } else if(current == target){
            path.add(current);
            return true;
        }
        
        path.add(current);
        
        if(DFS(current.left, target, path) == true){
            return true;
        }
        
        if(DFS(current.right, target, path) == true){
            return true;
        }
        
        path.remove(path.size() - 1);
        return false;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	/***************   by other using finding path (non_recursive)   *****************/
	public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q){
	    if(root==null) return null;
	    if(p==null || q==null)  return null;
	    ArrayList<TreeNode> p_path = new ArrayList<TreeNode>();
	    ArrayList<TreeNode> q_path = new ArrayList<TreeNode>();
	    findPath(root, p, p_path);
	    findPath(root, q, q_path);
	    int min_len = Math.min(p_path.size(), q_path.size());
	    int LCA = 0;
	    for(int i=0; i<min_len; i++){
	        if(p_path.get(i)==q_path.get(i))
	            LCA = i;
	    }return p_path.get(LCA);

	}
	public static boolean findPath(TreeNode root, TreeNode n1, ArrayList<TreeNode> path){
	    if(root == null)
	    	return false;
	    
	    path.add(root);	    
	    if(root == n1)
	        return true;
	    
	    if(findPath (root.left, n1, path) || findPath(root.right, n1, path))
	        return true;
	    
	    path.remove(path.size() - 1);
	    return false;
	}
}
