import java.util.LinkedList;
import java.util.Queue;
/******
 * 
Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
    
 * 
 * */

public class Le_116_Populating_Next_Right_Pointers_in_Each_Node {
	/*********************************************************************
	 * 此题前提必须是完全二叉树；
	 * 一个指针纪录当前的层parent结点位置，另一个指针纪录下一个层nextParent位置
	 *      
	 *********************************************************************/
	
	// 直接在树本身的结构上实现， space O(1)
	public void connect(TreeLinkNode root) {
        if(root == null){
            return;
        }
        
        root.next = null;
        TreeLinkNode nextHead = root.left;
        
        while(nextHead != null){
            while(root != null){
                root.left.next = root.right;
                
                if(root.next != null){
                    root.right.next = root.next.left;
                }
                
                root = root.next;
            }
            
            root = nextHead;
            nextHead = root.left;
        }
	}
	
	
	
	
	
	
	
	/*********************************************************/
	// by other using iterator
	public void connect2(TreeLinkNode root) {
		if(root == null){
            return;
        }
        
        TreeLinkNode current = root;
        TreeLinkNode left = root;    // 记录上一层的最左边结点
        
        while(left != null && left.left != null){
            current = left;
            while(current != null){
                current.left.next = current.right;
                current.right.next = (current.next == null) ? null : current.next.left;
                current = current.next;
            }
            left = left.left;
		}
	}
	
	
	/*********************************************************/
	// by other
	public void connect3(TreeLinkNode root) {
		if (root == null)
			return;
		root.next = null;
		TreeLinkNode current = root;
		connectNodes(current);
	}

	public void connectNodes(TreeLinkNode current) {
		if (current == null || (current.left == null && current.right == null))
			return;
		current.left.next = current.right;
		if (current.next != null)
			current.right.next = current.next.left;
		else
			current.right.next = null;
		connectNodes(current.left);
		connectNodes(current.right);
	}
    
    
	/*********************************************************/
	// by Jackie
	public void connect4(TreeLinkNode root) {
        if(root == null) return;
        int levelNum = 1;
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        q.add(root);
        
        while(!q.isEmpty()){
            TreeLinkNode tempNode = q.poll();
            TreeLinkNode nextNode = q.peek();
            if(tempNode.left != null)
                q.add(tempNode.left);
            if(tempNode.right != null)
                q.add(tempNode.right);
            if(--levelNum == 0){
                levelNum = q.size();
                tempNode.next = null;
            }
            else
                tempNode.next = nextNode;
        }
    }
	
	
	public static void main(String[] args){
		Le_116_Populating_Next_Right_Pointers_in_Each_Node t = new Le_116_Populating_Next_Right_Pointers_in_Each_Node();
		TreeLinkNode root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		root.left.left = new TreeLinkNode(4);
		root.left.right = new TreeLinkNode(5);
		root.right = new TreeLinkNode(3);
		root.right.left = new TreeLinkNode(6);
		root.right.right = new TreeLinkNode(7);
		t.connect(root);
		System.out.println(root.left.left.next.val);
	}

}
