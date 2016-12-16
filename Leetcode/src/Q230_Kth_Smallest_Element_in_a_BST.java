
public class Q230_Kth_Smallest_Element_in_a_BST {
	int res = Integer.MAX_VALUE;
	int count = 0;
	
	public int kthSmallest(TreeNode root, int k) {
        if(root == null) {
        	return 0;      
        }
        inOrder(root, k);
        return res;
    }
    
    public void inOrder(TreeNode node, int k){
        if(node == null) {
        	return ;
        }
        
        inOrder(node.left, k); 
        count++;
        if(count == k){
        	res = node.val;
        }
        inOrder(node.right, k);
    }
    
    public static void main(String[] args){
    	Q230_Kth_Smallest_Element_in_a_BST t = new Q230_Kth_Smallest_Element_in_a_BST();
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
