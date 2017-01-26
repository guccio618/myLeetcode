import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;




public class Other_Build_Tree_From_String {
	public GraphNode buildTree(String str) {
		if(str == null || str.length() == 0) {
			return null;
		} else if(isValid(str) == false) {
			return null;
		}
		
		str = str.substring(1, str.length() - 1);
		int index = 1;
		
		while(index < str.length() && Character.isDigit(str.charAt(index))) {
			index++;
		}
		
		GraphNode root = new GraphNode(Integer.parseInt(str.substring(0, index)));
		
		while(index < str.length()) {
			int closePos = findPos(str, index);
			root.list.add(buildTree(str.substring(index, closePos + 1)));
			index = closePos + 1;
		}
		
		return root;
	}
	
	public int findPos(String str, int start) {
		int count = 0;
		
		for(int i = start; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if(c == '[') {
				count++;
			} else if(c == ']') {
				count--;
			}
			
			if(count == 0) {
				return i;
			}
		}
		
		return -1;
	}
	
	public boolean isValid(String str) {
		int count = 0;
		
		for(char c : str.toCharArray()) {
			if(c == '[') {
				count++;
			} else if(c == ']') {
				count--;
			}
			
			if(count < 0) {
				return false;
			}
		}
		
		return count == 0;
	}
	
	
	public void print(GraphNode root) {
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		queue.offer(root);
		int size = 1;
		
		while(!queue.isEmpty()) {
			GraphNode node = queue.poll();
			System.out.print(node.val + ", ");
			
			for(GraphNode n : node.list) {
				queue.offer(n);
			}
			
			if(--size == 0) {
				size = queue.size();
				System.out.println();
			}
		}		
	}
	
	
	public static void main(String[] args) {
		Other_Build_Tree_From_String t = new Other_Build_Tree_From_String();
		String str = "[1[2[3][4]][5][6]]";
		GraphNode root = t.buildTree(str);
		t.print(root);
	}
}

class GraphNode{
	int val;
	List<GraphNode> list;
	
	public GraphNode(int val) {
		this.val = val;
		list = new ArrayList<GraphNode>();
	}
}