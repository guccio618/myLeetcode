/*******
 * 
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
	You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
	What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? 
	How would you optimize the kthSmallest routine?
	
 * 
 * */

public class Le_230_Kth_Smallest_Element_in_a_BST {
	// solution 1: using inorder travel, time is O(n)
	int ans = Integer.MAX_VALUE;
	int count = 0;
	
	public int kthSmallest(TreeNode root, int k) {
        if(root == null) {
        	return 0;      
        }
        
        inOrder(root, k);
        return ans;
    }
    
    public void inOrder(TreeNode node, int k){
        if(node == null) {
        	return ;
        }
        
        inOrder(node.left, k); 
        count++;
        
        if(count == k){
        	ans = node.val;
        	return;
        }
        
        inOrder(node.right, k);
    }
    
    
       
    // solution 2: using binary search, time is O(logn + n);
    public int kthSmallest2(TreeNode root, int k) {
        if (root == null || k <= 0) {
            return -1;
        }
        
        int count = getCount(root.left);
        
        if(k <= count) {
            return kthSmallest(root.left, k);
        } else if(k > count + 1) {
        	return kthSmallest(root.right, k - (count + 1));
        } else {
            return root.val;
        }
    }
    
    public int getCount(TreeNode node) {
        if(node == null) {
            return 0;
        }
        
        return 1 + getCount(node.left) + getCount(node.right);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /************************* main function **********************************/
    
    public static void main(String[] args){
    	Le_230_Kth_Smallest_Element_in_a_BST t = new Le_230_Kth_Smallest_Element_in_a_BST();
    	TreeNode root = new TreeNode(4);
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(5);
    	root.left.left = new TreeNode(1);
    	root.left.right = new TreeNode(3);
    	root.right.left = new TreeNode(6);
    	root.right.right = new TreeNode(7);
    	
    	System.out.println(t.kthSmallest(root, 1));    	
    }
}
