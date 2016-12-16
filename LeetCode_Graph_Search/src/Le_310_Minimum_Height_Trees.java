import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class Le_310_Minimum_Height_Trees {
	/*******************************************************************
	 * 此题运用了类似拓扑排序的方法, 将叶子结点一层一层剥除，最后剩下1，2个结点，
	 * 即为所要求的答案。
	 * 两个list轮流倒换，相当于层序遍历
	 * 
	 *******************************************************************/
	
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<Integer>();
        if (n <= 1) {
			ans.add(0);
			return ans;
		}
        
        HashSet<Integer>[] graph = new HashSet[n];
        for(int i = 0; i < n; ++i){
            graph[i] = new HashSet<Integer>();
        }
        
        for(int row = 0; row < edges.length; ++row){
            graph[edges[row][0]].add(edges[row][1]);
            graph[edges[row][1]].add(edges[row][0]);
        }
        
        for(int i = 0; i < n; ++i){
            if(graph[i].size() == 1){
                ans.add(i);
            }
        }
        
        while(n > 2){
        	ArrayList<Integer> newlist = new ArrayList<Integer>();  // 此处可以用队列层序遍历，由于最后答案为list，因此用ArrayList, 这里的这种用法比较nice ！！！
            for(int next : ans){                                    
                for(int nb : graph[next]){
                	graph[nb].remove(next);
                	graph[next].remove(nb);
                	n--;
                	if(graph[nb].size() == 1){
                        newlist.add(nb);
                    }
                }  
            }
            ans = newlist;
        }

        return ans;
    }
}
