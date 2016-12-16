import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;


public class Q347_Top_K_Frequent_Elements {
	// by other using bucket sort, time complexity is O(n)
	public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ans = new ArrayList<Integer>();
        if(nums == null || nums.length == 0){
            return ans;
        } 
        
        int n = nums.length;
        List<Integer>[] bucket = new List[n + 1];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int frequency = entry.getValue();
            if(bucket[frequency] == null){
                bucket[frequency] = new ArrayList<Integer>();
            }
            bucket[frequency].add(entry.getKey());
        }
        
        int index = n;
        
        while(k > 0){
            if(index >= 0 && bucket[index] != null){
                for(int num : bucket[index]){
                    ans.add(num);
                    k--;
                    
                    if(k == 0){
                        return ans;
                    }
                }
            }
            
            index--;
        }
        
        return ans;
    }
	
	
	
	// by other, time complexity is O(nlogn)
	public List<Integer> topKFrequent2(int[] nums, int k) {
        List<Integer> ans = new ArrayList<Integer>();
        if(nums == null || nums.length == 0){
            return ans;
        }
        
        Queue<Node> heap = new PriorityQueue<Node>(1, new Comparator<Node>(){
            public int compare(Node left, Node right){
                if(left.count != right.count){
                    return right.count - left.count;
                } else{
                    return left.val - right.val;
                }
            }
        }); 
        
        Arrays.sort(nums);
        int n = nums.length;
        int front = 0, back = 0;
        
        while(front < n){
            while(front < n && nums[front] == nums[back]){
                front++;
            }
            heap.offer(new Node(nums[back], front - back));
            back = front;
        }
        
        for(int i = 0; i < k; i++){
            ans.add(heap.poll().val);
        }
        
        return ans;
    }
    
    class Node{
        int val;
        int count;
        
        public Node(int v, int c){
            val = v;
            count = c;
        }
    }
}
