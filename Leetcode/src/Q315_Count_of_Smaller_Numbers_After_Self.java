import java.util.*;


public class Q315_Count_of_Smaller_Numbers_After_Self {
	/***************************************************************************************************************
	 * Traverse from the back to the beginning of the array, maintain an sorted array of numbers have been visited. 
	 * Use findIndex() to find the first element in the sorted array which is larger or equal to target number. 
	 * For example, [5,2,3,6,1], when we reach 2, we have a sorted array[1,3,6], findIndex() returns 1, 
	 * which is the index where 2 should be inserted and is also the number smaller than 2. 
	 * Then we insert 2 into the sorted array to form [1,2,3,6].
	 * 
	 ***************************************************************************************************************/
	// by other
	public List<Integer> countSmaller(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<Integer>();
        }
        
        List<Integer> list = new ArrayList<Integer>();
        int len = nums.length;
        Integer[] position = new Integer[len];
        
        for(int i = len - 1; i >= 0; i--){
            int pos = findPos(list, nums[i]);
            position[i] = pos;
            list.add(pos, nums[i]);
        }
        
        return Arrays.asList(position);
    }
    
    public int findPos(List<Integer> list, int target){
        if(list.size() == 0 || target <= list.get(0)){
            return 0;
        } else if(target > list.get(list.size() - 1)){
            return list.size();
        }
        
        int left = 0, right = list.size() - 1;
        
        while(left + 1 < right){
            int midIndex = left + (right - left) / 2;
            int mid = list.get(midIndex);
            
            if(mid < target){
                left = midIndex;
            } else {
                right = midIndex;
            }
        }
        
        if(list.get(left) >= target){
            return left;
        } else {
            return right;
        }
    }
	
	
	
    /**************************************************************************************************************/
    // by Jackie but time limit exceeded, O(nlogn)
	public List<Integer> countSmaller2(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0){
        	return res;
        }
        
        int len = nums.length;
        int[] dp = new int[len];
        for(int i = 0; i < len; ++i){
        	dp[i] = -1;
        }
        
        for(int i = 0; i < len - 1; ++i){
        	res.add(helper(nums, nums[i], i + 1, len - 1));
        }
        res.add(0);
        return res;
    }
	
	public int helper(int[] nums, int comparator, int start, int end){
		if(start == end){
			return (comparator > nums[start]) ? 1 : 0; 
		}
		int mid = start + (end - start) / 2;
		return helper(nums, comparator, start, mid) + helper(nums, comparator, mid + 1, end);
	}
	
	
	
	public List<Integer> countSmaller3(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        if(nums == null || nums.length == 0){
            return ans;
        }
        
        int maxRange = Integer.MIN_VALUE;
        int minRange = Integer.MAX_VALUE;
        int n = nums.length;
        for(int i = 0; i < n; ++i){
            maxRange = Math.max(maxRange, nums[i]);
            minRange = Math.min(minRange, nums[i]);
        }
        
        System.out.println(minRange + ", " + maxRange);
        
        segmentTree root = buildTree(minRange, maxRange);
        for(int i = n - 1; i >= 0; --i){
            int count = query(root, minRange, nums[i] - 1);
            ans.add(0, count);
            modify(root, nums[i], 1);
        }
        
        return ans;
    }
    
    class segmentTree{
        int start;
        int end;
        int count;
        segmentTree left;
        segmentTree right;
        
        public segmentTree(int s, int e){
            start = s;
            end = e;
            count = 0;
            left = right = null;
        }
    }
    
    public segmentTree buildTree(int start, int end){
        if(start == end){
            return new segmentTree(start, end);
        } else {
            segmentTree node = new segmentTree(start, end);
            int mid = (start + end) / 2;
            System.out.println("mid = " + mid);
            node.left = buildTree(start, mid);
            node.right = buildTree(mid + 1, end);
            return node;
        }
    }
    
    public int query(segmentTree node, int start, int end){
        if(node == null || start > end){
            return 0;
        }
        if(start <= node.start && end >= node.end){
            return node.count;
        }
        
        int leftCount = 0, rightCount = 0;
        int mid = (node.start + node.end) / 2;
        
        if(start <= mid){
            if(end > mid){
                leftCount = query(node.left, start, mid);
            } else {
                leftCount = query(node.left, start, end);
            }
        }
        if(end > mid){
            if(start <= mid){
                rightCount = query(node.right, mid + 1, end);
            } else {
                rightCount = query(node.right, start, end);
            }
        }
        
        return leftCount + rightCount;
    }
    
    public void modify(segmentTree node, int index, int value){
        if(node.start == index && node.end == index){
            node.count += value;
            return;
        }
        int mid = (node.start + node.end) / 2;
        if(node.start <= index && index <= mid){
            modify(node.left, index, value);
        }
        if(mid < index && index <= node.end){
            modify(node.right, index, value);
        }
        
       if(node.left != null){
           node.count = node.left.count;
       }
       if(node.right != null){
           node.count += node.right.count;
       }
    }
	
	
	public static void main(String[] args){
		Q315_Count_of_Smaller_Numbers_After_Self t = new Q315_Count_of_Smaller_Numbers_After_Self();
//		int[] nums = {5, 2, 6, 1};
		int[] nums = {2,0,1};
		
		List<Integer> res = t.countSmaller(nums);
		for(int i = 0; i < res.size(); ++i){
			System.out.print(res.get(i) + ", ");
		}
		
		System.out.println();
		
		List<Integer> res2 = t.countSmaller2(nums);
		for(int i = 0; i < res2.size(); ++i){
			System.out.print(res2.get(i) + ", ");
		}
	}
}
