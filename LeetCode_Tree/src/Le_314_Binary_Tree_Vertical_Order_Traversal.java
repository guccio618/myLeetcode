import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


public class Le_314_Binary_Tree_Vertical_Order_Traversal {
	public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root == null){
            return ans;
        }
        
        Queue<Node> q = new LinkedList<Node>();
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        int leftBound = 0, rightBound = 0;
        q.offer(new Node(root, 0));
        
        while(!q.isEmpty()){
            Node temp = q.poll();
            
            leftBound = Math.min(leftBound, temp.col);
            rightBound = Math.max(rightBound, temp.col);
            
            if(map.containsKey(temp.col)){
                map.get(temp.col).add(temp.node.val);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(temp.node.val);
                map.put(temp.col, list);
            }
            
            if(temp.node.left != null){
                q.offer(new Node(temp.node.left, temp.col - 1));
            }
            
            if(temp.node.right != null){
                q.offer(new Node(temp.node.right, temp.col + 1));
            }
        }
        
        for(int i = leftBound; i <= rightBound; i++){
            ans.add(map.get(i));
        }
        
        return ans;
    }
    
    class Node{
        TreeNode node;
        int col;
        
        public Node(TreeNode n, int c){
            node = n;
            col = c;
        }
    }
}
