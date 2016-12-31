/*******
 *    	Arithmetic Sequence*,  LRU Cache Count Miss*,  Insert Into Cycle Linked List*,  Day change cell growth*,   BST Minimum sum path*,  
 *    	Round Robin*,  Shorted Job First*
 * 	  	
 * 		Sliding Window Maximum,  Reverse Second Half List,  GCD,  Four Integer,  Right Rotation,  
 * 		Loop in linked list,  Maze, Rotate Matrix
 * 
 * */



public class A_Data_Structure {

}

class RandomListNode {
	int label;
	RandomListNode next, random;
	RandomListNode(int x) { this.label = x; }
};

class TreeNode {
	int value;
	TreeNode left, right;
	
	public TreeNode (int value) {
		this.value = value;
		left = right = null;
	}
}

class Point {
	int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Connection{
	String city1;
	String city2;
	int cost;
	
	public Connection(String c1, String c2, int c){
		city1 = c1;
		city2 = c2;
		cost = c;
	}
	
	@Override
	public String toString() {
		return city1 + " " + city2 + " " + cost;
	}
}

class ListNode {
	int value;
	ListNode next;
	
	public ListNode(int value) {
		this.value = value;
		this.next = null;
	}
}