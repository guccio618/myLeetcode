import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class Q000_Java_Arrays {
	public static void main(String[] args){
		/********************* Arrays Sort ***********************/
		Pair[] pair = new Pair[5];
		for(int i = 0; i < pair.length; ++i)
			pair[i] = new Pair(5-i, i);
		
		System.out.println("before: ");
		for(int i = 0; i < pair.length; ++i)
			System.out.print(pair[i].val + ", ");
		System.out.println();
	
		Arrays.sort(pair, new Comparator<Pair> () {   // 参数1是array类型   
			public int compare(Pair p1, Pair p2) {
				return p1.val - p2.val;               // return 正数时换位置，从小到大排
	        } 
		});
		
		System.out.println("after: ");
		for(int i = 0; i < pair.length; ++i)
			System.out.print(pair[i].val + ", ");
		System.out.println();
		
		/********************* Arrays binarySort ***********************/
		// 1.该搜索键在范围内，但不在数组中，由1开始计数；
		// 2.该搜索键在范围内，且在数组中，由0开始计数；
		// 3.该搜索键不在范围内，且小于范围内元素，由1开始计数；
		// 4.该搜索键不在范围内，且大于范围内元素，返回-(endIndex + 1);（特列）
		int[] nums = {1, 3, 4, 6, 8, 9};
		int x1 = Arrays.binarySearch(nums, 5);
		int x2 = Arrays.binarySearch(nums, 4);
		int x3 = Arrays.binarySearch(nums, 0);
		int x4 = Arrays.binarySearch(nums, 10);
		System.out.println("x1:" + x1 + ", x2:" + x2);
		System.out.println("x3:" + x3 + ", x4:" + x4);
		
		int N = 3;
		System.out.println(Arrays.binarySearch(nums, 0, N, 2));
		
		/********************* Arrays copyOf ***********************/
		int[] a = Arrays.copyOf(nums, nums.length);
		for(int i = 0; i < a.length; ++i)
			System.out.print(a[i] + ", ");
		System.out.println();
	}
}
