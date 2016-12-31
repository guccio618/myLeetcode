import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
/*****
 * 
Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.

Note:
	Given target value is a floating point.
	You may assume k is always valid, that is: k ≤ total nodes.
	You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
	
Follow up:
	Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
 * 
 * */

public class Le_272_Closest_Binary_Search_Tree_Value_II {
	// solution 1:  using heap, time complexity O(nlogn + klogn)
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> ans = new ArrayList<Integer>();
        
        if(root == null){
            return ans;
        }
        
        Queue<Node> heap = new PriorityQueue<Node>(1, new Comparator<Node>(){
            public int compare(Node left, Node right){
                if(left.diff > right.diff){
                    return 1;
                } else if(left.diff < right.diff){
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            heap.offer(new Node(root.val, Math.abs((double) root.val - target)));
            root = root.right;
        }
        
        for(int i = 0; i < k; i++){
            ans.add(heap.poll().value);
        }
        
        return ans;
    }
    
    class Node {
        int value;
        double diff;
        
        public Node (int v, double d){
            value = v;
            diff = d;
        }
    }
	
    
    
    
	// follow up: solution 2: time complexity is O(logn)
	public List<Integer> closestKValues2(TreeNode root, double target, int k) {
        List<Integer> ans = new ArrayList<Integer>();
        
        if(root == null){
            return ans;
        }
        
        Stack<TreeNode> pred = new Stack<TreeNode>();
        Stack<TreeNode> succ = new Stack<TreeNode>();
        
        initializeSuccessorStack(root, target, succ);
        initializePredecessorStack(root, target, pred);
        
        if(!pred.isEmpty() && !succ.isEmpty() && pred.peek().val == succ.peek().val){   // 注意这一步必须有 ！！！
            getNextPredecessor(pred);
        }
        
        while(k-- > 0){
            if(succ.isEmpty()){
                ans.add(getNextPredecessor(pred));
            } else if(pred.isEmpty()){
                ans.add(getNextSuccessor(succ));
            } else {
                double succ_diff = Math.abs((double)succ.peek().val - target);
                double pred_diff = Math.abs((double)pred.peek().val - target);
                
                if(succ_diff < pred_diff) {
                    ans.add(getNextSuccessor(succ));
                } else {
                    ans.add(getNextPredecessor(pred));
                }
            }
        }
        
        return ans;
    }
    
    public void initializeSuccessorStack(TreeNode root, double target, Stack<TreeNode> succ){
        if(root == null){
            return;
        }
        
        while(root != null){
            if(root.val == target){
                succ.push(root);
                break;
            } else if(root.val > target){
                succ.push(root);
                root = root.left;
            } else {
                root = root.right;
            }
        }
    }
    
    private void initializePredecessorStack(TreeNode root, double target, Stack<TreeNode> pred) {
        if(root == null){
            return;
        }
        
        while(root != null){
            if(root.val == target){
                pred.push(root);
                break;
            } else if(root.val < target){
                pred.push(root);
                root = root.right;
            } else {
                root = root.left;
            }
        }
    }
    
    public int getNextSuccessor(Stack<TreeNode> succ) {
        TreeNode node = succ.pop();
        int ans = node.val;        
        node = node.right;
        
        while(node != null){
            succ.push(node);
            node = node.left;
        }
        
        return ans;
    }
    
    private int getNextPredecessor(Stack<TreeNode> pred) {
        TreeNode node = pred.pop();
        int ans = node.val;       
        node = node.left;
        
        while(node != null){
            pred.push(node);
            node = node.right;
        }
        
        return ans;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /******************************************************************************************************************************
     * The idea is to compare the predecessors and successors of the closest node to the target, 
     * we can use two stacks to track the predecessors and successors, then like what we do in merge sort, 
     * we compare and pick the closest one to the target and put it to the result list.
     * As we know, inorder traversal gives us sorted predecessors, whereas reverse-inorder traversal gives us sorted successors.
     * We can use iterative inorder traversal rather than recursion, but to keep the code clean, here is the recursion version.
     * 
     *******************************************************************************************************************************/
    // by other using heap, time complexity O(n + k)
    public List<Integer> closestKValues3(TreeNode root, double target, int k) {
    	  List<Integer> res = new ArrayList<>();

    	  Stack<Integer> s1 = new Stack<>(); // predecessors
    	  Stack<Integer> s2 = new Stack<>(); // successors

    	  inorder(root, target, false, s1);
    	  inorder(root, target, true, s2);
    	  
    	  while (k-- > 0) {
    	    if (s1.isEmpty())
    	      res.add(s2.pop());
    	    else if (s2.isEmpty())
    	      res.add(s1.pop());
    	    else if (Math.abs(s1.peek() - target) < Math.abs(s2.peek() - target))
    	      res.add(s1.pop());
    	    else
    	      res.add(s2.pop());
    	  }
    	  
    	  return res;
    	}

    	// inorder traversal
    	void inorder(TreeNode root, double target, boolean reverse_flag, Stack<Integer> stack) {
    	  if (root == null) return;

    	  inorder(reverse_flag ? root.right : root.left, target, reverse_flag, stack);
    	  // early terminate, no need to traverse the whole tree
    	  if ((reverse_flag && root.val <= target) || (!reverse_flag && root.val > target)) return;  // 需要注意这里有等号 root.val <= target
    	  // track the value of current node
    	  stack.push(root.val);
    	  inorder(reverse_flag ? root.left : root.right, target, reverse_flag, stack);
    	}
}
