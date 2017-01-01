
public class Q298_Binary_Tree_Longest_Consecutive_Sequence {
private int ans = 1;
    
    public int longestConsecutive(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        helper(root);
        return ans;
    }
    
    public int helper(TreeNode node){
        if(node == null){
            return 0;
        } else if(node.left == null && node.right == null){
            return 1;
        }
        
        int left = helper(node.left);
        int right = helper(node.right);
        int len = 1;
        
        if(node.left != null && node.val + 1 == node.left.val){
            len = Math.max(len, left + 1);
        }
        if(node.right != null && node.val + 1 == node.right.val){
            len = Math.max(len, right + 1);
        }
        
        ans = Math.max(ans, len);
        return len;
    }
}
