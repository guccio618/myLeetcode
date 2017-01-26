import java.util.*;


public class TreeNode {
	private int value;
	private TreeNode left;
	private TreeNode right;

	public TreeNode(int v, int n) {
		if (v >= n) {
			return;
		}
		
		value = v;
		
		if ((2 * v + 1) < n) {
			left = new TreeNode(2 * v + 1, n);
		}
		
		if ((2 * v + 2) < n) {
			right = new TreeNode(2 * v + 2, n);
		}
	}

	public static void recursivePreOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		
		System.out.print(root.value + ", ");
		recursivePreOrder(root.left);
		recursivePreOrder(root.right);
	}

	public static void recursiveInOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		
		recursiveInOrder(root.left);
		System.out.print(root.value + ", ");
		recursiveInOrder(root.right);
	}

	public static void recursivePostOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		
		recursivePostOrder(root.left);
		recursivePostOrder(root.right);
		System.out.print(root.value + ", ");
	}

	// 先序遍历
	public static void preOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		
		Stack s = new Stack<TreeNode>();

		while (root != null || !s.isEmpty()) {
			while (root != null) {
				System.out.print(root.value + ", ");
				s.push(root);          // 先访问，再入栈
				root = root.left;
			}
			
			root = (TreeNode) s.pop(); // 如果是null，出栈并处理右子树
			root = root.right;
		}
	}

	// 中序遍历
	public static void inOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		
		Stack s = new Stack<Integer>();

		while (root != null || !s.isEmpty()) {
			while (root != null) {
				s.push(root); // 先入栈，后访问
				root = root.left;
			}
			
			root = (TreeNode) s.pop();
			System.out.print(root.value + ", ");
			root = root.right; // 如果是null，出栈并处理右子树
		}
	}

	// 后序遍历：
	// 是要先处理完左右子树，然后再处理根(回溯)，
	// 所以需要一个记录哪些节点已经被访问的结构(可以在树结构里面加一个标记)，
	// 这里可以用map实现
	public static void postOrder(TreeNode root) {
		if (root == null){
			return;
		}
		
		Stack s = new Stack<Integer>();
		HashSet visited = new HashSet<Integer>();
		s.push(root);

		while (!s.isEmpty()) {
			TreeNode node = (TreeNode) s.peek();
			
			if (node.left != null && !visited.contains(node.left)) {
				node = node.left;
				
				while (node != null && !visited.contains(node)) {
					s.push(node);
					node = node.left;
				}
				
				continue;
			}
			
			if (node.right != null && !visited.contains(node.right)) {
				s.push(node.right);
				continue;
			}
			
			TreeNode t = (TreeNode) s.pop();
			visited.add(t);
			System.out.print(t.value + ", ");
		}
	}

	// 双栈实现的后序遍历
	public static void postOrder2(TreeNode root) {
		if (root == null){
			return;
		}
		
		Stack s1 = new Stack<TreeNode>();
		Stack s2 = new Stack<TreeNode>();
		s1.push(root);

		while (!s1.isEmpty()) {
			TreeNode temp = (TreeNode) s1.pop();
			s2.push(temp); // 而s2先放入最后遍历的根节点，之后再按右，然后左的顺序存入节点; 这里可以控制s2打印的先后顺序
			if (temp.left != null) { // s1中按先左后右的顺序存入
				s1.push(temp.left);
			}
			
			if (temp.right != null){
				s1.push(temp.right);
			}
		}

		while (!s2.isEmpty()) {
			System.out.print(((TreeNode) s2.pop()).value + ", ");
		}
	}

	// 层序遍历
	public static void levelOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		
		Queue q = new LinkedList<TreeNode>();
		q.add(root);

		while (!q.isEmpty()) {
			TreeNode temp = (TreeNode) q.poll();
			System.out.print(temp.value + ", ");
			
			if (temp.left != null) {
				q.add(temp.left);
			}
			
			if (temp.right != null) {
				q.add(temp.right);
			}
		}
	}

	// 双栈实现螺旋遍历
	public static void spiralOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		
		Stack s1 = new Stack<TreeNode>();
		Stack s2 = new Stack<TreeNode>();
		s1.push(root);

		while (!s1.isEmpty() || !s2.isEmpty()) {
			TreeNode temp;
			
			if(!s1.isEmpty()){
				while (!s1.isEmpty()) {
					temp = (TreeNode) s1.pop();
					System.out.print(temp.value + ", ");
					
					if (temp.right != null) {
						s2.push(temp.right);
					}
					
					if (temp.left != null) {
						s2.push(temp.left);
					}
				}
			} else {
				while (!s2.isEmpty()) {
					temp = (TreeNode) s2.pop();
					System.out.print(temp.value + ", ");
					
					if (temp.left != null) {
						s1.push(temp.left);
					}
					
					if (temp.right != null) {
						s1.push(temp.right);
					}
				}
			}
		}
	}
	
	//单栈实现螺旋遍历
	public static void spiralOrder2(TreeNode root) {
		int depth = get_depth(root);
		
        for(int i = 0; i < depth; ++i){
        	if(i%2 != 0) {
        		preOrder2Right(root, i);
            } else {   
            	preOrder2Left(root, i);
            }
        }
	}
	
	public static void preOrder2Left(TreeNode root, int height){
	    Stack s = new Stack<TreeNode>();	
	    
	    while(root != null || !s.empty()){
	        while(root != null) {
	          if(get_depth(root) == height)
	        	System.out.print(root.value + ", ");
	            s.push(root);
	            root = root.left;
	        }
	        
	        if(!s.empty()){
	            root = (TreeNode) s.pop();
	            root = root.right;
	        }
	    }
	}
	
	public static void preOrder2Right(TreeNode root, int height){
	    Stack s = new Stack<TreeNode>();
	    
	    while(root != null || !s.empty()){
	        while(root != null) {
	          if(get_depth(root) == height)
	        	System.out.print(root.value + ", ");
	            s.push(root);
	            root = root.right;
	        }
	        
	        if(!s.empty()){
	            root = (TreeNode) s.pop();
	            root = root.left;
	        }
	    }
	}
	
	public static int get_depth(TreeNode root){  
	    int depth = 0; 
	    
	    if(root != null){  
	        int left_depth = get_depth(root.left);  
	        int right_depth = get_depth(root.right);  
	        depth = (left_depth > right_depth) ? left_depth : right_depth;  
	        depth++;  
	    }  
	    
	    return depth;  
	}  


	public static void main(String[] args) {
		TreeNode t = new TreeNode(0,10);
		
		System.out.print("recursivePreOrder:  ");
		recursivePreOrder(t);
		System.out.println();
		
		System.out.print("preOrder:           ");
		preOrder(t);
		System.out.println();

		System.out.print("recursiveInOrder:   ");
		recursiveInOrder(t);
		System.out.println();
		
		System.out.print("inOrder:            ");
		inOrder(t);
		System.out.println();
		
		System.out.print("recursivePostOrder: ");
		recursivePostOrder(t);
		System.out.println();
				
		System.out.print("postOrder:          ");
		postOrder(t);
		System.out.println();
		System.out.print("postOrder2:         ");
		postOrder2(t);
		System.out.println();
		
		System.out.print("levelOrder:         ");
		levelOrder(t);
		System.out.println();
		
		System.out.print("spiralOrder:        ");
		spiralOrder(t);
		System.out.println();
		
		System.out.print("spiralOrder2:       ");
		spiralOrder2(t);
		System.out.println();
	}
}
