import java.util.ArrayList;


public class Q000_Data_Definition {
	
}

class Interval {
	int start, end;
	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

class DirectedGraphNode {
	int label;
	ArrayList<DirectedGraphNode> neighbors;
	DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
}

class Point {
	int x;
	int y;
	Point() { x = 0; y = 0; }
	Point(int a, int b) { x = a; y = b; }
}

class UndirectedGraphNode {
	int label;
	ArrayList<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}