import java.util.PriorityQueue;
import java.util.Comparator;
import java.lang.Math;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.List;


public class test {
	public static Cpoint[] findKClose_Heap(Cpoint[] list, int k) {
		if(list == null || list.length == 0 || k <= 0 || k > list.length) {
			return new Cpoint[0];
		}
		
		PriorityQueue<Cpoint> maxHeap = new PriorityQueue<Cpoint>(k, new Comparator<Cpoint>() {
			@Override
			public int compare(Cpoint p1, Cpoint p2) {
				return -Double.compare(Math.sqrt(p1.x*p1.x + p1.y*p1.y), Math.sqrt(p2.x*p2.x + p2.y*p2.y));
			}
		});
		
		for(Cpoint p : list) {
			maxHeap.offer(p);
			
			if(maxHeap.size() > k) {
				maxHeap.poll();		
			}	
		}
		
		Cpoint[] ans = new Cpoint[k];
		
		for(int i = k-1; i >= 0; i--) {
			ans[i] = maxHeap.poll();
		}
		
		return ans;
	}

	
	public static Cpoint[] findKClose_Sort(Cpoint[] list, int k) {
		if(list == null || list.length == 0 || k <= 0 || k > list.length) {
			return new Cpoint[0];
		}
		
		Cpoint[] tempList = new Cpoint[list.length];
		
		for(int i = 0; i < list.length; i++) {
			tempList[i] = list[i];
		}
		
		Arrays.sort(tempList, new Comparator<Cpoint>() {
			@Override
			public int compare(Cpoint p1, Cpoint p2) {
				return Double.compare(Math.sqrt(p1.x*p1.x + p1.y*p1.y), Math.sqrt(p2.x*p2.x + p2.y*p2.y));
			}
		});
		
		System.out.println();
		
		Cpoint[] ans = new Cpoint[k];
		
		for(int i = 0; i < k; i++) {
			ans[i] = tempList[i];
		}
		
		return ans;
	}
	
	
	
	public static String longestPalindrome(String s) {
		if(s == null || s.length() <= 1) {
			return s;
		}
		
		int[] pair = new int[2];
		
		for(int i = 0; i < s.length() - 1; i++) {
			getPalindrome(pair, s, i, i);
			getPalindrome(pair, s, i, i + 1);
		}
		
		return s.substring(pair[1], pair[1] + pair[0]);
	}

	public static void getPalindrome(int[] pair, String s, int start, int end) {
		while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
			start--;
			end++;	
		}
		
		if(end - start - 1 > pair[0]) {
			pair[0] = end - start - 1;
			pair[1] = start + 1;
		}
	}
	
	
	
	
	public static multiTreeNode solve(multiTreeNode root) {
		if(root == null) {
			return root;
		}
		
		Pair p = new Pair(null, Double.MIN_VALUE);
		DFS(p, root);
		return p.largestNode;
	}

	public static double[] DFS(Pair p, multiTreeNode node) {
		if(node == null) {
			return new double[] {0, 0};
		} else if(node.child == null || node.child.size() == 0) {
			return new double[] {1, node.val};
		}
		
		double[] current = new double[] {1, node.val};
		
		for(multiTreeNode c : node.child) {
			double[] childResult = DFS(p, c);
			current[0] += childResult[0];
			current[1] += childResult[1];
		}
		
		if(current[1] / current[0] > p.average) {
			p.average = current[1] / current[0];
			p.largestNode = node;	
		}
		
		return current;
	}

	static class Pair {
		multiTreeNode largestNode;
		double average;
		
		public Pair(multiTreeNode largestNode, double average) {
			this.largestNode = largestNode;
			this.average = average;
		}
	}
	
	
	
	

	
	
	
	

	public static void main(String[] args) {
		Cpoint[] list = new Cpoint[7];
		int k = 3;
	
		for (int i = list.length - 1; i >= 0; i--) {
			list[i] = new Cpoint(-i-1, i+1);
		}
		
		int left = 0, right = list.length - 1;
		
		while(left < right) {
			Cpoint temp = list[left];
			list[left] = list[right];
			list[right] = temp;
			left++;
			right--;
		}
		
		for(Cpoint p : list) {
			System.out.println(p.toString());
		}
		
		System.out.println();

		Cpoint[] array = findKClose_Heap(list, k);
	
		for(Cpoint p : array) {
			System.out.println(p.toString());
		}

		Cpoint[] array2 = findKClose_Sort(list, k);
		
		for(Cpoint p : array2) {
			System.out.println(p.toString());
		}
		
		System.out.println();
		
		for(Cpoint p : list) {
			System.out.println(p.toString());
		}
		
		String str = "ddabccbad";
		System.out.println(longestPalindrome(str));

		
		String str2 = "ddabcba";
		System.out.println(longestPalindrome(str2));
	}
}