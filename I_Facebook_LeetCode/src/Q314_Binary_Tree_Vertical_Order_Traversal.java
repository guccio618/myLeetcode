import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
/*******
 * 
Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples:

Given binary tree [3,9,20,null,null,15,7],
   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7
return its vertical order traversal as:
[
  [9],
  [3,15],
  [20],
  [7]
]
Given binary tree [3,9,8,4,0,1,7],
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
return its vertical order traversal as:
[
  [4],
  [9],
  [3,0,1],
  [8],
  [7]
]
Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
    /\
   /  \
   5   2
return its vertical order traversal as:
[
  [4],
  [9,5],
  [3,0,1],
  [8,2],
  [7]
]

 * 
 * */

public class Q314_Binary_Tree_Vertical_Order_Traversal {
	// using BFS
	public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root == null){
            return ans;
        }
        
        Queue<Pair> q = new LinkedList<Pair>();
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        int leftBound = 0, rightBound = 0;
        q.offer(new Pair(root, 0));
        
        while(!q.isEmpty()){
            Pair temp = q.poll();
            
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
                q.offer(new Pair(temp.node.left, temp.col - 1));
            }
            
            if(temp.node.right != null){
                q.offer(new Pair(temp.node.right, temp.col + 1));
            }
        }
        
        for(int i = leftBound; i <= rightBound; i++){
            ans.add(map.get(i));
        }
        
        return ans;
    }
    
    class Pair{
        TreeNode node;
        int col;
        
        public Pair(TreeNode n, int c){
            node = n;
            col = c;
        }
    }
    
    
    
    
    
    
    
    
    
    /****************************** main function **************************************/
    
    public static void main(String[] args){
    	Q314_Binary_Tree_Vertical_Order_Traversal t = new Q314_Binary_Tree_Vertical_Order_Traversal();
    	TreeNode root = new TreeNode(3);
    	root.left = new TreeNode(9);
    	root.right = new TreeNode(20);
    	root.right.left = new TreeNode(15);
    	root.right.right = new TreeNode(7);  	
    	List<List<Integer>> ans = t.verticalOrder(root);
    	
    	for(int i = 0; i < ans.size(); i++){
    		for(int j = 0; j < ans.get(i).size(); j++){
    			System.out.print(ans.get(i).get(j) + ", ");
    		}
    		System.out.println();
    	}
    }
}
