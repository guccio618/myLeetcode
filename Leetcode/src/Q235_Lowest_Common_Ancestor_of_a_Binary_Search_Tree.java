/******
 * 
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as 
the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, 
since a node can be a descendant of itself according to the LCA definition.

 * 
 **/

public class Q235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return root; 
        } else if(p == null){
            return q;
        } else if(q == null){
            return p;
        }
        
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        } else if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
	

	
	
	
	
	
	/*********************************************************************/
	// 从root向下遍历，如果node.val值在p和q的值之间，则此node即为最低的公共父节点
	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;    
        if(p == null) return q;
        if(q == null) return p;
        
        TreeNode pos = root;
        int large = Math.max(p.val, q.val);
        int small = Math.min(p.val, q.val);
        while((pos != null && pos.val < small) || (pos != null && pos.val > large)){
            if(pos.val < small)
                pos = pos.right;
            else
                pos = pos.left;
        }
        return pos;
    }
	
	public static void main(String[] args){
		Q235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree t = new Q235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree();  
		TreeNode root = new TreeNode(4);
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(5);
    	root.left.left = new TreeNode(1);
    	root.left.right = new TreeNode(3);
    	root.right.left = new TreeNode(6);
    	root.right.right = new TreeNode(7);
    	
    	TreeNode res = t.lowestCommonAncestor(root, root.left.left, root.left.left);
    	System.out.println(res.val);
	}
}
