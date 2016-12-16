import java.util.ArrayList;


public class P2_Ave_Highest_Salary {
	public static multiTreeNode solve(multiTreeNode root) {
		if(root == null) {
			return root;
		}
		
		Parcel recoder = new Parcel(null, Double.MIN_VALUE);
		DFS(root, recoder);
		return recoder.largestNode;		
	}
	
	public static double[] DFS(multiTreeNode node, Parcel recorder) {
		if(node == null){
			return new double[] {0, 0};
		} else if(node.child == null || node.child.size() == 0){
			return new double[] {1, node.val};
		}
		
		double[] current = {1, node.val};
		
		for(multiTreeNode c : node.child) {
			double[] temp = DFS(c, recorder);
			current[0] += temp[0];
			current[1] += temp[1];	
		}
		
		if(current[1] / current[0] > recorder.average) {
			recorder.average = current[1] / current[0];
			recorder.largestNode = node;
		}
		
		return current;
	}

	static class Parcel{
		multiTreeNode largestNode;
		double average;
		
		public Parcel(multiTreeNode largestNode , double average) {
			this.largestNode = largestNode;
			this.average = average;
		}
	}
	
	
	
	
	
	
	/**********************************************/
	
	public static void main(String [] args){
		P2_Ave_Highest_Salary high = new P2_Ave_Highest_Salary();
		multiTreeNode E5 = new multiTreeNode(500, new ArrayList<>());
		multiTreeNode E4 = new multiTreeNode(4, new ArrayList<>());
		multiTreeNode E3 = new multiTreeNode(3, new ArrayList<>());
		ArrayList<multiTreeNode> e2 = new ArrayList<>();
		e2.add(E3);
		e2.add(E4);
		multiTreeNode E2 = new multiTreeNode(2, e2);
		ArrayList<multiTreeNode> e1 = new ArrayList<>();
		e1.add(E2);
		e1.add(E5);
		multiTreeNode E1 = new multiTreeNode(1, e1);
		
		multiTreeNode D1 = new multiTreeNode(1, new ArrayList<>());
		
		multiTreeNode C1 = new multiTreeNode(1, new ArrayList<>());
		multiTreeNode C2 = new multiTreeNode(2, new ArrayList<>());
		
		multiTreeNode B1 = new multiTreeNode(100, new ArrayList<>());
		multiTreeNode B2 = new multiTreeNode(2, new ArrayList<>());
		multiTreeNode B3 = new multiTreeNode(3, new ArrayList<>());
		
		ArrayList<multiTreeNode> ee = new ArrayList<>();
		ee.add(E1);
		
		ArrayList<multiTreeNode> dd = new ArrayList<>();
		dd.add(D1);
		
		ArrayList<multiTreeNode> cc = new ArrayList<>();
		cc.add(C1);
		cc.add(C2);
		
		ArrayList<multiTreeNode> bb = new ArrayList<>();
		bb.add(B1);
		bb.add(B2);
		bb.add(B3);
		
		multiTreeNode E = new multiTreeNode(10, ee);
		multiTreeNode D = new multiTreeNode(9, dd);
		multiTreeNode C = new multiTreeNode(8, cc);
		multiTreeNode B = new multiTreeNode(7, bb);
		
		ArrayList<multiTreeNode> aa = new ArrayList<>();
		aa.add(B);
		aa.add(C);
		aa.add(D);
		aa.add(E);
		
		multiTreeNode A = new multiTreeNode(-60, aa);
		System.out.println(high.solve(A).val);
	}
}


class multiTreeNode {
	int val;
	ArrayList<multiTreeNode> child;

	public multiTreeNode(int val, ArrayList<multiTreeNode> child) {
		this.val = val;
		this.child = new ArrayList<>(child);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.val+"";
	}
}
