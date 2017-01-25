
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