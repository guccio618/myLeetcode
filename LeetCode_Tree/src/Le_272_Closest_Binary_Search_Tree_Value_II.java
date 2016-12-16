import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;


public class Le_272_Closest_Binary_Search_Tree_Value_II {
	// by other, time complexity is O(logn)
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> ans = new ArrayList<Integer>();
        
        if(root == null){
            return ans;
        }
        
        Stack<TreeNode> pred = new Stack<TreeNode>();
        Stack<TreeNode> succ = new Stack<TreeNode>();
        
        initializeSuccessorStack(root, target, succ);
        initializePredecessorStack(root, target, pred);
        
        if(!pred.isEmpty() && !succ.isEmpty() && pred.peek().val == succ.peek().val){
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
    
    
    // by Jackie using heap, time complexity O(n)
    public List<Integer> closestKValues2(TreeNode root, double target, int k) {
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
}
