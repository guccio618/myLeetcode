import java.util.*;

/*******
 * 
 * Given n points on a 2D plane, find if there is such a line parallel to y-axis
 * that reflect the given points.
 * 
 * Example 1: Given points = [[1,1],[-1,1]], return true.
 * 
 * Example 2: Given points = [[1,1],[-1,-1]], return false.
 * 
 * Follow up: Could you do better than O(n2)?
 * 
 ********/

public class Q356_Line_Reflection {
	// using map, time complexity is O(nlogn)
	public boolean isReflected(int[][] points) {
		if (points == null || points.length == 0 || points[0].length == 0) {
			return true;
		}

		int leftBound = Integer.MAX_VALUE, rightBound = Integer.MIN_VALUE;
		Map<Integer, List<Integer>> map = new HashMap<>();

		Arrays.sort(points, new Comparator<int[]>() {         // sort first !!!
			public int compare(int[] array1, int[] array2) {
				return array1[0] - array2[0];
			}
		});

		for (int[] point : points) {
			leftBound = Math.min(leftBound, point[0]);
			rightBound = Math.max(rightBound, point[0]);

			if (map.containsKey(point[1])) {
				if (!map.get(point[1]).contains(point[0])) {
					map.get(point[1]).add(point[0]);
				}
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(point[0]);
				map.put(point[1], list);
			}
		}

		int sum = leftBound + rightBound;

		for (int key : map.keySet()) {
			List<Integer> list = map.get(key);

			if (isValid(list, sum) == false) {
				return false;
			}
		}

		return true;
	}

	public boolean isValid(List<Integer> list, int sum) {
		int left = 0, right = list.size() - 1;

		while (left < right) {
			if (list.get(left) + list.get(right) == sum) {
				left++;
				right--;
			} else {
				return false;
			}
		}

		return true;
	}

	
	
	// using Arrays.hashCode, time complexity is O(n), space is O(n)
	public boolean isReflected2(int[][] points) {
		if (points == null || points.length == 0 || points[0].length == 0) {
			return true;
		}

		Set<Integer> set = new HashSet<Integer>();
		int minX = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;

		for (int[] point : points) {
			minX = Math.min(minX, point[0]);
			maxX = Math.max(maxX, point[0]);
			set.add(Arrays.hashCode(point));
		}

		int sum = minX + maxX;

		for (int[] point : points) {
			if (!set.contains(Arrays.hashCode(new int[] { sum - point[0], point[1] }))) {
				return false;
			}
		}

		return true;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	/****************************** main function ***********************************/

	public static void main(String[] args) {
		Q356_Line_Reflection t = new Q356_Line_Reflection();
		int[][] points = { { 1, 1 }, { -1, 1 } };

		System.out.println(t.isReflected(points));
	}
}
