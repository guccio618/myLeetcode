import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Q069_Binary_Tree_Level_Order_Traversal {
	// by Jackie
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null){
            return res;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int num = 1;
        
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            list.add(node.val);
            if(node.left != null)
                q.add(node.left);
            if(node.right != null)
                q.add(node.right);
            if(--num == 0){
                res.add(new ArrayList<Integer>(list));
                list.clear();
                num = q.size();
            }
        }
        return res;
    }
	
	
	/********************************************************************/
	// by ninechapter using DFS, 节省空间
	public ArrayList<ArrayList<Integer>> levelOrder2(TreeNode root) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        
        if (root == null) {
            return results;
        }
        
        int maxLevel = 0;
        while (true) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            dfs(root, level, 0, maxLevel);
            if (level.size() == 0) {
                break;
            }
            
            results.add(level);
            maxLevel++;
        }
        
        return results;
    }
    
    private void dfs(TreeNode root,
                     ArrayList<Integer> level,
                     int curtLevel,
                     int maxLevel) {   // 迭代搜索，设置maxLevel，可以退出
        if (root == null || curtLevel > maxLevel) {
            return;
        }
        
        if (curtLevel == maxLevel) {
            level.add(root.val);
            return;
        }
        
        dfs(root.left, level, curtLevel + 1, maxLevel);
        dfs(root.right, level, curtLevel + 1, maxLevel);
    }
}
