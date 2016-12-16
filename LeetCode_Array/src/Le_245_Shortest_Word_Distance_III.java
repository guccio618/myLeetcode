import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Le_245_Shortest_Word_Distance_III {
	// follow up for Q243, 在word1判断的时候加入了分类讨论
	public int shortestWordDistance(String[] words, String word1, String word2) {
        if(words == null || words.length == 0){
            return 0;
        }
        
        int len = words.length;
        int pos1 = -1, pos2 = -1;
        int ans = Integer.MAX_VALUE;
        
        for(int i = 0; i < len; i++){
            if(words[i].equals(word1)){
                if(word1.equals(word2)){                  // 添加了word1等于word2的判断
                    if(pos1 > -1){
                        ans = Math.min(ans, i - pos1);
                    }
                } else {
                    if(pos2 > -1){
                        ans = Math.min(ans, i - pos2);
                    }
                }
                
                pos1 = i;
            } else if(words[i].equals(word2)){
                if(pos1 > -1){
                    ans = Math.min(ans, i - pos1);
                }
                pos2 = i;
            }
        }
        
        return ans;
    }
	
	/*********************************************************/
	// by Jackie, 分类讨论
	public int shortestWordDistance2(String[] words, String word1, String word2) {
		if (words == null || words.length == 0) {
			return 0;
		}

		if (word1.equals(word2)) {
			return sameHelper(words, word1);
		} else {
			return diffHelper(words, word1, word2);
		}
	}

	public int diffHelper(String[] words, String word1, String word2) {
		int n = words.length;
		int flag = 0;
		int position1 = 0, position2 = 0;
		int ans = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			if (words[i].equals(word1)) {
				position1 = i;
				if (flag == 2) {
					ans = Math.min(ans, position1 - position2);
				}
				flag = 1;
			}
			if (words[i].equals(word2)) {
				position2 = i;
				if (flag == 1) {
					ans = Math.min(ans, position2 - position1);
				}
				flag = 2;
			}
		}

		return ans;
	}

	public int sameHelper(String[] words, String word) {
		int n = words.length;
		int last = Integer.MAX_VALUE;
		int ans = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			if (words[i].equals(word)) {
				if (last == Integer.MAX_VALUE) {
					last = i;
				} else {
					ans = Math.min(ans, i - last);
					last = i;
				}
			}
		}

		return ans;
	}

	
	
	/*********************************************************/
	// by Jackie using hashmap, time complexity O(n^2)
	public int shortestWordDistance3(String[] words, String word1, String word2) {
		if (words == null || words.length == 0) {
			return 0;
		}

		int ans = Integer.MAX_VALUE;
		int n = words.length;
		Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();

		for (int i = 0; i < n; i++) {
			if (map.containsKey(words[i])) {
				map.get(words[i]).add(i);
			} else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(words[i], list);
			}
		}

		List<Integer> list1 = map.get(word1);
		List<Integer> list2 = map.get(word2);

		for (int i : list1) {
			for (int j : list2) {
				if (i != j) {
					ans = Math.min(ans, Math.abs(i - j));
				}
			}
		}

		return ans;
	}
}
