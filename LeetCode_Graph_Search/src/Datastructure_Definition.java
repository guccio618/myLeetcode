import java.util.ArrayList;
import java.util.List;

/*****************************************************************************
 * (1). 图和搜索的常见方法为BFS, DFS, 引入辅助visited set或者visited 矩阵，
 *      或者采用memoSearch方法(如题329)降低重复计算。
 * (2). 需要注意的是visited add元素的时机有两种，1是在将neighbor加入队列之前，
 *      2是在q.poll之后
 *   
 * (3). 题型：
 * 		a. 非递归dfs： Le_332*, **341
 * 		b. string parser: Le_385*, Le_394*, Le_439
 * 			
 * 		重点题型：	109, **114, Le_126*, Le_127, Le_130(将二维矩阵压入队列的方法)，
 * 				**133, 207, Le_261*, **269, Le_286*, Le_301*, Le_305*, **310, 323, 329, Le_332*, 
 * 				**341, *364, *366, Le_385*, Le_394*
 *  	
 *****************************************************************************/

public class Datastructure_Definition {

}

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) { 
		label = x; 
		neighbors = new ArrayList<UndirectedGraphNode>(); 
	}
}

class DirectedGraphNode {
	int label;
	ArrayList<DirectedGraphNode> neighbors;
	
	DirectedGraphNode(int x) { 
		label = x; 
		neighbors = new ArrayList<DirectedGraphNode>(); 
	}
}

class NestedInteger{
	int val;
	List<NestedInteger> list;
	
	public NestedInteger(int v){
		val = v;
		list = null;
	}
	
	public NestedInteger(List<NestedInteger> l){
		list = l;
	}
	
	public boolean isInteger(){
		return list == null;
	}
	
	public int getInteger(){
		return val;
	}
	
	public List<NestedInteger> getList(){
		return list;
	}
}


