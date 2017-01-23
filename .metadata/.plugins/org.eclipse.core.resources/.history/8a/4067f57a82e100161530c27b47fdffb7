import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*********
 * 
 * Given a non-empty array of integers, return the k most frequent elements.
 * 
 * For example, Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * 
 * Note: You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is
 * the array's size.
 * 
 * 
 */

public class Q347_Top_K_Frequent_Elements {
	// solution 1: using heap, time complexity is O(n + nlogk)
	public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ans = new ArrayList<Integer>();
        
        if (nums == null || nums.length == 0) {
            return ans;
        }
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        // O(n)
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        Queue<Pair> minHeap = new PriorityQueue<Pair>(k + 1, new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2) {
                return p1.count - p2.count;
            }    
        });
        
        // O(nlogk)
        for (int key : map.keySet()) {
            minHeap.offer(new Pair(key, map.get(key)));
            
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        while (!minHeap.isEmpty()) {
            ans.add(minHeap.poll().value);
        }
        
        return ans;
    }
    
    class Pair {
        int value;
        int count;
        
        public Pair(int v, int c) {
            value = v;
            count = c;
        }
    }

	
	
	
	
	// solution 2: using bucket sort, time complexity is O(n)
	public List<Integer> topKFrequent2(int[] nums, int k) {
		List<Integer> ans = new ArrayList<Integer>();
		if (nums == null || nums.length == 0) {
			return ans;
		}

		int n = nums.length;
		List<Integer>[] bucket = new List[n + 1];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int frequency = entry.getValue();
			if (bucket[frequency] == null) {
				bucket[frequency] = new ArrayList<Integer>();
			}
			bucket[frequency].add(entry.getKey());
		}

		int index = n;

		while (k > 0) {
			if (index >= 0 && bucket[index] != null) {
				for (int num : bucket[index]) {
					ans.add(num);
					k--;

					if (k == 0) {
						return ans;
					}
				}
			}

			index--;
		}

		return ans;
	}
}
