/********
 * 
The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:
     3
    / \
   2   3
    \   \ 
     3   1
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:
     3
    / \
   4   5
  / \   \ 
 1   3   1
Maximum amount of money the thief can rob = 4 + 5 = 9.

 * 
 * */

public class Le_337_House_Robber_III {
	public int rob(TreeNode root) {
        int[] num = dfs(root);
        return Math.max(num[0], num[1]);
    }
	
	public int[] dfs(TreeNode node){
		if(node == null){
            return new int[]{0, 0};
        }
        
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int[] current = new int[2];
        
        current[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);   // current[0]表示当前房子不偷， 对于前一个房子有2中选择，注意选择最大值 ！！！
        current[1] = left[0] + right[0] + node.val;                               // current[1]表示当前房子偷
        return current;
	}
}
