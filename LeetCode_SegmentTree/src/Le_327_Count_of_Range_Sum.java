import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/*******
 * 
Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.

Note:
	A naive algorithm of O(n2) is trivial. You MUST do better than that.

Example:
	Given nums = [-2, 5, -1], lower = -2, upper = 2,
	Return 3.
	The three ranges are : [0, 0], [2, 2], [0, 2] and their respective sums are: -2, -1, 2.
	
 * 
 * 
 * */

public class Le_327_Count_of_Range_Sum {
	// using segment tree
	public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0 || lower > upper) {
            return 0;
        }
        
        int ans = 0;
        Set<Long> set = new HashSet<>();     // 用于去除重复的sum值
        long sum = 0;
        
        for(int i = 0; i < nums.length; i++) {
            sum += (long) nums[i];
            set.add(sum);
        }
        
        long[] array = new long[set.size()];
        int index = 0;
        
        for (long num : set) {
            array[index++] = num;
        }
        
        Arrays.sort(array);
        SegmentTreeNode root = buildTree(array, 0, array.length - 1);

        for(int i = nums.length - 1; i >= 0; i--) {
            modify(root, sum);
            sum -= (long) nums[i];
            ans += query(root, (long)lower + sum, (long)upper + sum);
        }
        
        return ans;
    }
    
    
    public SegmentTreeNode buildTree(long[] nums, int start, int end) {
        if (start > end) {
            return null;
        } else if (start == end) {
            return new SegmentTreeNode(nums[start], nums[end]);
        }
        
        int mid = start + (end - start) / 2;
        SegmentTreeNode root = new SegmentTreeNode(nums[start], nums[end]);
        root.left = buildTree(nums, start, mid);
        root.right = buildTree(nums, mid + 1, end);
        return root;
    }
    
    public int query(SegmentTreeNode node, long min, long max) {
        if (node == null) {
            return 0;
        } else if (min > node.max || max < node.min) {
            return 0;
        } else if (min <= node.min && node.max <= max) {
            return node.count;
        } else {
            return query(node.left, min, max) + query(node.right, min, max);
        }
    }
    
    public void modify(SegmentTreeNode node, long value) {
        if (node == null) {
            return ;
        } else if (node.min <= value && value <= node.max) {
            node.count++;
            modify(node.left, value);
            modify(node.right, value);
        }
    }
    
    class SegmentTreeNode {
        int count;
        long max, min;
        SegmentTreeNode left, right;
        
        public SegmentTreeNode(long min, long max) {
            this.max = max;
            this.min = min;
            count = 0;
            left = right = null;
        }
    }
	
	
	/*******************************************************/
	// by other using divide and conquer， O(nlogn)
	public int countRangeSum1(int[] nums, int lower, int upper) {
	    int n = nums.length;
	    long[] sums = new long[n + 1];
	    for (int i = 0; i < n; ++i)
	        sums[i + 1] = sums[i] + nums[i];
	    int res = countWhileMergeSort(sums, 0, n + 1, lower, upper);
	    for (int i = 0; i < n; ++i)
	        System.out.print(sums[i] + ", ");
	    System.out.println();
	    return res;
	}

	private int countWhileMergeSort(long[] sums, int start, int end, int lower, int upper) {
	    if (end - start <= 1) return 0;
	    int mid = (start + end) / 2;
	    int count = countWhileMergeSort(sums, start, mid, lower, upper) 
	    		+ countWhileMergeSort(sums, mid, end, lower, upper);
	    int j = mid, k = mid, t = mid;
	    long[] cache = new long[end - start];
	    for (int i = start, r = 0; i < mid; ++i, ++r) {
	        while (k < end && sums[k] - sums[i] < lower) k++;  // 先计算，再排序，保证在混合前，
	        while (j < end && sums[j] - sums[i] <= upper) j++; // left part的一定在原sums[]中right part的左边
	        while (t < end && sums[t] < sums[i]) cache[r++] = sums[t++];
	        cache[r] = sums[i];
	        count += j - k;
	    }
	    System.arraycopy(cache, 0, sums, start, t - start);
	    return count;
	}
	    
	
	/*******************************************************/
	// by Jackie using DP, O(n^2) but Time Limit Exceeded
	public int countRangeSum2(int[] nums, int lower, int upper) {
        if(nums == null || nums.length == 0 || lower > upper){
            return 0;    
        } 
        int result = 0;
        long[] sum = new long[nums.length+1];
        for(int i = 0; i < nums.length; ++i){
            sum[i+1] = sum[i] + nums[i];
        }
        for(int i = 0; i < nums.length; ++i){
            for(int j = i+1; j <= nums.length; ++j){
                if(sum[j]-sum[i] >= lower && sum[j]-sum[i] <= upper){
                    result++;
                }
            }
        }
        return result;
	}
	
	
	public static void main(String[] args){
		Le_327_Count_of_Range_Sum t = new Le_327_Count_of_Range_Sum();
		int[] nums = {-2, 5, -1, 5, -7, 9, 10, 11, -8};
		System.out.println(t.countRangeSum(nums, 1, 4));
		System.out.println(t.countRangeSum2(nums, 1, 4));
	}
}
