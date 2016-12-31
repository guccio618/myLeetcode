import java.util.ArrayList;


public class Lecture3_BinaryTree_DivideConquer_05_Binary_Tree_Level_Order_Traversal {
	// DFS 实现层序遍历
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
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
    
    private void dfs(TreeNode root, ArrayList<Integer> level, int curtLevel, int maxLevel) {
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
