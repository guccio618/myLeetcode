import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Li_114_Flatten_Binary_Tree_to_Linked_List {
	/**************************************************************************
	 * (1). 此题根据题目要求，需要将树展开为一个类似链表的结构，因此考虑到用链表或者队列来实现；
	 * (2). 根据题目要求，实现的遍历顺序应该为先序遍历，因此考虑用stack
	 * 
	 **************************************************************************/
	public void flatten(TreeNode root) {
        if(root == null) {
        	return;
        }
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
    
        while(root != null || !s.isEmpty()){
            while(root != null){
                s.push(root);
                q.offer(root);
                root = root.left;
            }
            root = s.pop();
            root = root.right;
        }
        
        root = q.poll();
        while(!q.isEmpty()){
            root.left = null;
            root.right = q.poll();
            root = root.right;
        }
    }
}
