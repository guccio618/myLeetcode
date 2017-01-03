import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.Queue;
/*******
 * 
For a undirected graph with tree characteristics, we can choose any node as the root. 
The result graph is then a rooted tree. Among all possible rooted trees, those with 
minimum height are called minimum height trees (MHTs). Given such a graph, write a
function to find all the MHTs and return a list of their root labels.

Format
The graph contains n nodes which are labeled from 0 to n - 1. You will be given the 
number n and a list of undirected edges (each edge is a pair of labels).

You can assume that no duplicate edges will appear in edges. Since all edges are undirected,
[0, 1] is the same as [1, 0] and thus will not appear together in edges.

Example 1:

Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]

        0
        |
        1
       / \
      2   3
return [1]

Example 2:

Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

     0  1  2
      \ | /
        3
        |
        4
        |
        5
return [3, 4]

 * 
 * */


public class Le_310_Minimum_Height_Trees {
	public ArrayList<Integer> findMinHeightTrees(int n, int[][] edges) {
		ArrayList<Integer> leaves = new ArrayList<Integer>();
		
		if(n <= 1){
		    if(n == 1){
		        leaves.add(0);
		    }
		    
		    return leaves;
		}

		// Construct adjencent graph
		Set<Integer>[] graph = new HashSet[n];
		
		for (int i = 0; i < n; ++i) {
			graph[i] = new HashSet<Integer>();
		}

		for (int[] e : edges) {
			graph[e[0]].add(e[1]);
			graph[e[1]].add(e[0]);
		}

		// Add leaves which have one leaf
		for (int i = 0; i < n; i++) {
			if (graph[i].size() == 1){
				leaves.add(i);
			}
		}

		// Remove leaves level by level
		while (n > 2) {
			ArrayList<Integer> newLeaves = new ArrayList<Integer>();  // 这里的这种用法比较nice ！！！
			
			for (int leaf : leaves) {
				for (int nextleaf : graph[leaf]) {					
					graph[nextleaf].remove(leaf);     // Remove connection
					n--;                        // 注意 n--在这里，表示删除掉leaf这个节点 ！！！
					
					if (graph[nextleaf].size() == 1) {
						newLeaves.add(nextleaf);
					}
				}
			}
			
			leaves = newLeaves;
		}
		
		return leaves;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    
    
	/****************************************************************************/
	// by other, very fast
	public ArrayList<Integer> findMinHeightTrees3(int n, int[][] edges) {
		ArrayList<ArrayList<Integer>> myGraph = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> res = new ArrayList<Integer>();
        if (n==1) {
            res.add(0);
            return res;
        }
        int[] degree = new int[n];
        for(int i=0; i<n; i++) {
            myGraph.add(new ArrayList<Integer>());
        }
        for(int i=0; i<edges.length; i++) {
            myGraph.get(edges[i][0]).add(edges[i][1]);
            myGraph.get(edges[i][1]).add(edges[i][0]);
            degree[edges[i][0]]++;
            degree[edges[i][1]]++;
        }
        Queue<Integer> myQueue = new ArrayDeque<Integer>();

        for(int i=0; i<n; i++) {
            if (degree[i]==0) 
                return res;
            else if (degree[i]==1) {
                myQueue.offer(i);
            }
        }

        while (!myQueue.isEmpty()) {
            res = new ArrayList<Integer>();
            int count = myQueue.size();

            for(int i=0; i<count; i++){
                int curr = myQueue.poll();
                res.add(curr);
                degree[curr]--;
                for(int k=0; k<myGraph.get(curr).size(); k++) {
                    int next = myGraph.get(curr).get(k);
                    if (degree[next]==0) continue;
                    if (degree[next]==2) {
                        myQueue.offer(next);
                    }
                    degree[next]--;
                }
            }       
        }
        return res;		
	}
	
	
	
	
	/************************ main function ****************************/
	
	public static void main(String[] args){
		Le_310_Minimum_Height_Trees t = new Le_310_Minimum_Height_Trees();	
		int[][] edges = {{1,0},{1,2},{1,3}};
		List<Integer> l = t.findMinHeightTrees(4, edges);
		for(int i = 0; i < l.size(); ++i)
			System.out.print(l.get(i) + ", ");
		System.out.println();
	}
}
