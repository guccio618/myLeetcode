import java.util.*;


public class BinarySearchTree {
	// add a node to BST
	public BST_TreeNode addNode(BST_TreeNode root, int value) {
		if(root == null) {
			return new BST_TreeNode(value);
		}
		
		BST_TreeNode node = root;
		
		while(node != null) {
			if(node.val > value) {
				if(node.left == null) {
					node.left = new BST_TreeNode(value);
					break;
				} else {
					node = node.left;
				}
			} else if(node.val < value) {
				if(node.right == null) {
					node.right = new BST_TreeNode(value);
					break;
				} else {
					node = node.right;
				}
			} else {
				break;
			}
		}
		
		return root;
	}
	
	// remove a node from BST
	public BST_TreeNode removeNode(BST_TreeNode root, int value) {
		if(root == null) {
			return root;
		}
		
		BST_TreeNode dummy = new BST_TreeNode(0);
		dummy.left = root;
		BST_TreeNode parent = findNode(dummy, root, value);
		BST_TreeNode deleteNode = null;
		
		if(parent.left != null && parent.left.val == value) {
			deleteNode = parent.left;
		} else if(parent.right != null && parent.right.val == value) {
			deleteNode = parent.right;
		} else {
			return dummy.left;
		}
		
		deleteNode(parent, deleteNode);
		return dummy.left;
	}
	
	public BST_TreeNode findNode(BST_TreeNode parent, BST_TreeNode node, int value) {
		while(node != null && node.val != value) {
			if(node.val > value) {
				parent = node;
				node = node.left;
			} else {
				parent = node;
				node = node.right;
			}
		}
		
		return parent;
	}
	
	public void deleteNode(BST_TreeNode parent, BST_TreeNode node) {
		if(node.right == null) {
			if(parent.left == node) {
				parent.left = node.left;
			} else {
				parent.right = node.left;
			}
		} else {
			BST_TreeNode tempNode = node.right;
			BST_TreeNode father = node;
			
			while(tempNode.left != null) {
				father = tempNode;
				tempNode = tempNode.left;
			}
			
			if(father.left == tempNode) {
				father.left = tempNode.right;
			} else {
				father.right = tempNode.right;
			}
			
			if(parent.left == node) {
				parent.left = tempNode;
			} else {
				parent.right = tempNode;
			}
			
			tempNode.left = node.left;
			tempNode.right = node.right;
		}
	}
	
	
	
	public void print(BST_TreeNode root) {
		Queue<BST_TreeNode> queue = new LinkedList<BST_TreeNode>();
		queue.offer(root);
		int size = 1;
		
		while(!queue.isEmpty()) {
			BST_TreeNode node = queue.poll();
			System.out.print(node.val + ", ");
			
			if(node.left != null) {
				queue.offer(node.left);
			}
			
			if(node.right != null) {
				queue.offer(node.right);
			}
			
			if(--size == 0) {
				size = queue.size();
				System.out.println();
			}
		}
		
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		BinarySearchTree t = new BinarySearchTree();
		
		BST_TreeNode root = new BST_TreeNode(5);
		root.left = new BST_TreeNode(3);
		root.left.left = new BST_TreeNode(2);
		root.left.right = new BST_TreeNode(4);
		root.right = new BST_TreeNode(7);
		root.right.left = new BST_TreeNode(6);
		root.right.right = new BST_TreeNode(9);
		
		t.print(root);
		t.removeNode(root, 9);
		t.print(root);
		t.addNode(root, 8);
		t.print(root);
		t.addNode(root, 9);
		t.print(root);
		
		
		
	}
}

class BST_TreeNode {
	int val;
	BST_TreeNode left, right;
	
	public BST_TreeNode(int val) {
		this.val = val;
		left = right = null;
	}
}
