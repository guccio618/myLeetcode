import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;


public class Lecture9_Graph_Search_09_Word_Ladder_II {
	/*************************************************************
	 * 思路同Word_Ladder_I，但需要引入TreeNode, 用于记录parent node
	 * 
	 *************************************************************/
	// by Jackie
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> res = new ArrayList<List<String>>();
		if (dict == null || dict.size() == 0 || start.equals(end)) {
			return res;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		Set<String> set = new HashSet<String>();
		q.offer(new TreeNode(start, null));
		dict.add(end);
		set.add(start);
		boolean found = false;

		while (!q.isEmpty()) {
			if(found == true){
				return res;
			}
			
			int size = q.size();
			for (int i = 0; i < size; ++i) {
				TreeNode node = q.poll();
                String word = node.val;
                ArrayList<String> list = new ArrayList<String>();
				for (String nextWord : findWordRange(word, dict)) {
					if(nextWord.equals(end)){
	                    found = true;
	                    list.add(nextWord);
	                    while(node != null){
	                        list.add(0, node.val);
	                        node = node.parent;
	                    }
	                    res.add(list);
					} else if (set.contains(nextWord)) {
						continue;
					} else {
						q.offer(new TreeNode(nextWord, node));
						set.add(word);
					}
				}
			}
		}
		return res;
    }
    
    public ArrayList<String> findWordRange(String word, Set<String> dict) {
		ArrayList<String> wordList = new ArrayList<String>();
		char[] str = word.toCharArray();
		int len = word.length();

		for (int i = 0; i < len; ++i) {
			char tempChar = str[i];
			for (char c = 'a'; c <= 'z'; ++c) {
				if (str[i] == c) {
					continue;
				}
				str[i] = c;
				String newWord = new String(str);
				if (dict.contains(newWord)) {
					wordList.add(newWord);
				}
			}
			str[i] = tempChar;
		}
		return wordList;
	}
	
    private class TreeNode{
        protected String val;
        protected TreeNode parent;
        public TreeNode(String v, TreeNode p){
            val = v;
            parent = p;
        }
    }

	
    
    /************************************************************************************************
     * 1. 从start -> end 运用BFS计算出从所有点离起点的距离
     * 2. 从end -> start 运用DFS，根据BFS的结果，从终点出发，在保证离起点越来越近的基础上，搜索所有从终点到起点的距离
     * 
     ************************************************************************************************/
	// by ninechapter using BFS + DFS
    public List<List<String>> findLadders2(String start, String end, Set<String> dict) {
        List<List<String>> res = new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        HashMap<String, Integer> distance = new HashMap<String, Integer>();      // 每个String距离start的变换次数
        dict.add(start);
        dict.add(end);
        bfs(map, distance, start, end, dict);
        List<String> list = new ArrayList<String>();
        dfs(res, list, end, start, distance, map);
        return res;
    }

    public void bfs(HashMap<String, List<String>> map, HashMap<String, Integer> distance, String start, String end, Set<String> dict) {
        Queue<String> q = new LinkedList<String>();
        q.offer(start);
        distance.put(start, 0);
        for (String s : dict) {
            map.put(s, new ArrayList<String>());
        }
        
        while (!q.isEmpty()) {
            String crt = q.poll();
            List<String> wordList = expand(crt, dict);
            for (String next : wordList) {
                map.get(next).add(crt);
                if (!distance.containsKey(next)) {
                    distance.put(next, distance.get(crt) + 1);
                    q.offer(next);
                }
            }
        }
    }
    
    public void dfs(List<List<String>> res, List<String> list, String crt, String start, HashMap<String, Integer> distance, HashMap<String, List<String>> map) {
        list.add(crt);
        if (crt.equals(start)) {
            Collections.reverse(list);
            res.add(new ArrayList<String>(list));
            Collections.reverse(list);
        } else {
            for (String next : map.get(crt)) {
                if (distance.containsKey(next) && distance.get(crt) == distance.get(next) + 1) {  // 保证到达start的距离是比当前crt小1的next结点；此步可以保证找到的结果总是最小的
                    dfs(res, list, next, start, distance, map);
                }
            }           
        }
        list.remove(list.size() - 1);
    }

    List<String> expand(String crt, Set<String> dict) {
        List<String> expansion = new ArrayList<String>();

        for (int i = 0; i < crt.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch != crt.charAt(i)) {
                    String expanded = crt.substring(0, i) + ch
                            + crt.substring(i + 1);
                    if (dict.contains(expanded)) {
                        expansion.add(expanded);
                    }
                }
            }
        }

        return expansion;
    }
    
    	
	
	public static void main(String[] args){
		Lecture9_Graph_Search_09_Word_Ladder_II t = new Lecture9_Graph_Search_09_Word_Ladder_II();
		Set<String> set = new HashSet<String>();
		set.add("hot");
		set.add("dot");
		set.add("dog");
		set.add("lot");
		set.add("log");
		System.out.println(t.findLadders("hit", "cog", set));
		System.out.println(t.findLadders2("hit", "cog", set));
//		set.add("ab");
//		set.add("ac");
//		set.add("bc");
//		System.out.println(t.findLadders2("aa", "bb", set));
	}
}
