import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q000_DataStructure_Definition {
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if(root == null){
            return res;
        }
   
       
        Stack<TreeNode> s = new Stack<TreeNode>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        while(root != null || !s.isEmpty()){
            while(root != null){
                s.push(root);
                list.add(root.val);
                root = root.left;
            }
            root = s.pop();
            if(root.left == null && root.right == null){
            	StringBuffer sb = new StringBuffer();
            	for(int i = 0; i < list.size() - 1; ++i){
            		sb.append(list.get(i)).append("->");
            	}
            	sb.append(list.get(list.size() - 1));
                res.add(sb.toString());
                list.remove(list.size() - 1);
            }
            root = root.right;
        }
        
        return res;
    }
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.right = new TreeNode(5);
		root.right = new TreeNode(3);
		Q000_DataStructure_Definition t = new Q000_DataStructure_Definition();
		List<String> res = t.binaryTreePaths(root);
		
		for(int i = 0; i < res.size(); ++i){
			System.out.println(res.get(i));
		}
	}
}

class TreeNode {
	public int val;
	public TreeNode left, right;
	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}
}

// Definition for ListNode.
class ListNode {
	int val;
	ListNode next;
	ListNode(int val) {
		this.val = val;
		this.next = null;
	}
}

//Definition for singly-linked list with a random pointer.
class RandomListNode {
	int label;
	RandomListNode next, random;
	RandomListNode(int x) { this.label = x; }
}

//Definition for Doubly-ListNode.
class DoublyListNode {
	int val;
	DoublyListNode next, prev;
	DoublyListNode(int val) {
		this.val = val;
		this.next = this.prev = null;
	}
}
