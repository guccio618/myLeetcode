import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
/*********
 * 
Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
Formally the function should:
Return true if there exists i, j, k 
such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
Your algorithm should run in O(n) time complexity and O(1) space complexity.

Examples:
	Given [1, 2, 3, 4, 5],
	return true.

	Given [5, 4, 3, 2, 1],
	return false.
	
 * 
 * */

public class Q334_Increasing_Triplet_Subsequence {
	// solution 1:
	public boolean increasingTriplet(int[] nums) {
		if (nums == null || nums.length < 3) {
			return false;
		}
		
		int max1 = nums[0];
		int max2 = Integer.MIN_VALUE;

		for (int i = 1; i < nums.length; ++i) {
			if (nums[i] > max1) {
				if (max2 != Integer.MIN_VALUE && nums[i] > max2) {
					return true;
				} else {
					max2 = nums[i];
				}
			} else {
				max1 = nums[i];
			}
		}
		
		String str = "";
		StringBuffer sb = new StringBuffer(str);

		return false;
	}

	
	
	// solution 2:
	public boolean increasingTriplet2(int[] nums) {
		if (nums == null || nums.length < 3) {
			return false;
		}

		Queue<Integer> heap1 = new PriorityQueue<Integer>(10,
				new Comparator<Integer>() {
					public int compare(Integer left, Integer right) {
						return left - right;
					}
				});

		Queue<Integer> heap2 = new PriorityQueue<Integer>(10,
				new Comparator<Integer>() {
					public int compare(Integer left, Integer right) {
						return left - right;
					}
				});

		heap1.add(nums[0]);

		for (int i = 1; i < nums.length; ++i) {
			if (nums[i] > heap1.peek()) {
				if (!heap2.isEmpty() && nums[i] > heap2.peek()) {
					return true;
				} else {
					heap2.add(nums[i]);
				}
			} else {
				heap1.add(nums[i]);
			}
		}

		return false;
	}

	
	
	
	
	
	
	
	
	
	/************************** main function ***********************************/
	
	public static void main(String[] args) {
		Q334_Increasing_Triplet_Subsequence t = new Q334_Increasing_Triplet_Subsequence();
		int[] nums = { 2,3,1,4};
		System.out.println(t.increasingTriplet2(nums));
//		int[] nums2 = { 5, 4, 3, 2, 1 };
//		System.out.println(t.increasingTriplet2(nums2));
//		int[] nums3 = { 8, 7, 1, 3, 2, 5, 3, 2 };
//		System.out.println(t.increasingTriplet2(nums3));
	}
}
