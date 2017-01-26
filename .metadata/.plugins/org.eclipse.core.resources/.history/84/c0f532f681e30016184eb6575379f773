import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q334_Increasing_Triplet_Subsequence {
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
