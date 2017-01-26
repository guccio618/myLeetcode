import java.util.Arrays;
import java.util.Random;


public class Sort {
	
	/************************ Select Sort ************************/
	// 时间O(n^2)，空间O(1)，稳定
	void select_sort(int[] p){
		for (int i = 0; i < p.length; i++) {
            for (int j = i + 1; j < p.length; j++) {
                if (p[i] > p[j]) {
                    swap(p, i, j);
                }
            }
        }
	}

	/*********************** Insert Sort **************************/
	// 时间O(n^2)，空间O(1)，稳定
	void insert_sort(int[] p) {      
		int j, key;
		
		for (int i = 1; i < p.length; i++) {
			j = i - 1;
			key = p[i];
			
			while (j >= 0 && p[j] > key) {
				p[j + 1] = p[j];
				j--;
			}
			
			p[j + 1] = key;
		}
	}

	
	/*********************** Bubble Sort **************************/
	// 时间O(n^2)，空间O(1)，稳定
	void bubble_sort(int[] p) {      
		for (int i = 0; i < p.length - 1; i++) {
			for (int j = p.length - 1; j >= i + 1; j--) {
				if (p[j] < p[j - 1]) {
					swap(p, j-1, j);
				}
			}
		}
	}
	
	
	/*********************** Merge Sort **************************/
	// 时间稳定在O(n*logn)，空间O(n)，稳定； 但如果n足够大，开辟space O(n)费时
	// Divide and Conquer; 先局部有序，再整体有序
	void recursive_merge_sort(int[] p, int x, int y){     
		if(x < y){
			int m = (x+y) / 2;
			recursive_merge_sort(p, x, m);
			recursive_merge_sort(p, m+1, y);
			merge_sort(p, x, m, y);
		}
	}
	
	void merge_sort(int[] p, int x, int m, int y){
		int a = m-x+1;
		int b = y-m;
		int[] L = new int[a+1];
		int[] R = new int[b+1];
		
		for(int i = 0; i < a; i++) {
			L[i] = p[x+i];
		}
		
		for(int j = 0; j < b; j++) {
			R[j] = p[m+1+j];
		}
		
		L[a] = R[b] = Integer.MAX_VALUE;
		int i = 0, j = 0;
		
		for(int k = x; k <= y; k++){
			if(L[i] < R[j]) {
				p[k] = L[i++];
			} else { 
				p[k] = R[j++];		
			}
		}
	}

	
	/*********************** Random Quick Sort **************************/
	// 时间最理想O(n*logn)，最差O(n^2)，空间O(logn)，不稳定; worse case 是整个序列倒序，此时快速排序退化成冒泡排序
	// Divide and Conquer； 先整体有序，再局部有序； 如果不是worse case，其速度快于merge sort
	public int partition(int[] p, int left, int right) {
		int start = left;
	 	int temp;
		int pivot = p[right];
		
		for (int i = left; i < right; i++) {
			if (p[i] <= pivot) {
				temp = p[start];
				p[start] = p[i];
				p[i] = temp;
				start++;
			}
		}
		
		temp = p[start];
		p[start] = p[right];
		p[right] = temp;
		
		return start;
	}

	public int randomized_partition(int[] p, int x, int y) {
		int n = y - x + 1;
		int temp;
		int gap = new Random().nextInt(n); // 0~n-1间的随机数
		temp = p[y];
		p[y] = p[x + gap];
		p[x + gap] = temp;
		return partition(p, x, y);
	}

	public void quickSort(int[] p, int x, int y) {
		if (x < y) {
			int position = randomized_partition(p, x, y); // 也可以用 random_partition
			quickSort(p, x, position - 1);                // 注意这里是position - 1 !!!
			quickSort(p, position + 1, y);
		}
	}
	
	/*********************** Quick Sort **************************/
	// 时间最理想O(n*logn)，最差O(n^2)，空间O(logn)，不稳定; worse case 是整个序列倒序，此时快速排序退化成冒泡排序
	// Divide and Conquer； 先整体有序，再局部有序； 如果不是worse case，其速度快于merge sort
	public void quickSort2(int[] x, int left, int right){   
		if(left >= right) {
			return;                         
		}
		
		int i = left, j = right;                  
		double pivot = (x[left]+x[right])/2.0;  // pivot必须用double
		
		while(i < j) {
			while(i < right && x[i] < pivot) i++;  // 右边界的判定
			while(j > left && x[j] >= pivot) j--;  // 左边界的判定
			
			if(i < j) {
				int temp = x[i];
				x[i] = x[j];
				x[j] = temp;
			}
		}
		
		if(j > left) {                         // 分割
			quickSort2(x, left, j);
		}
		
		if(right > j+1) {
			quickSort2(x, j+1, right);	
		}
	}
	
	
	/*********************** Heap Sort **************************/
	
	void heapSort(int[] array) {         // 时间O(n*logn)，空间O(1)，不稳定
		build_Max_heap(array);   // 构建堆,除了叶子外，其他叶子以上部分已经完成排序，
		int n = array.length;    // 按照从小到大，至上而下排序
		
		for (int i = n-1; i >= 1; i--) {  // 叶子无法排序，因此每次将位于root的最大的节点
			swap(array, 0, i);            // 和最后的节点替换，然后重新进行排序
			heapify(array, 0, i);
		}
	}

	void build_Max_heap(int[] array) {    // 仅完成叶子以上节点从大到小排序
		int n = array.length; 
		
		for (int i = n/2-1; i >= 0; i--){
			heapify(array, i, n);
		}
	}

	void heapify(int[] A, int i, int max) {
		int left = 2*i+1;              // 左孩子的下标（如果存在的话）
		int right = 2*i+2;             // 右孩子的下标（如果存在的话）
		int largest = i;   
		
		if (left < max && A[left] > A[i]) {
			largest = left;
		} 
		if (right < max && A[right] > A[largest]) {
			largest = right;
		}
		
		if (largest != i) {
			swap(A, largest, i);
			heapify(A, largest, max);
		}
	}
	
	
	public void swap(int[] x, int i, int j){
		int temp = x[i];
		x[i] = x[j];
		x[j] = temp;
	}
	
	
	
	/***********************   count sort   **************************/	
	// 时间复杂度为O(n+k), 其中k为排序数的范围； 空间复杂度为O(n+k)
	// 限制:
	// (1). 必须知道待排序的数组的最大值range
	// (2). 待排序数组中的元素必须为非负值

	void countSort(int[] nums, int range) {
		int[] countArray = new int[range + 1];
		int[] tempArray = new int[nums.length];      // 与数组p一样长的临时数组
		
		for (int i = 0; i < nums.length; i++){
			countArray[ nums[i] ]++;
		}
		
		for (int i = 1; i < countArray.length; i++){
			countArray[i] += countArray[i-1];
		}
		
		for (int i = nums.length-1; i >= 0; i--) {     // 必需要从 n - 1开始，从后往前
			int value = nums[i];
			int position = countArray[value]-1;
			tempArray[position] = value;
			countArray[value] -= 1;
		}
		
		for (int i = 0; i < nums.length; i++){
			nums[i] = tempArray[i];
		}
	}

	
	

    /***********************   radix sort   **************************/	
    // 基于count_sort的radix sort
	public void radixSort(int[] nums, int radix, int bit_num){    // array为待排序数; radix代表基数，如10进制radix就为10;
        int len = nums.length;                                    // bit_num代表排序元素的最大位数;
        int[] tempArray = new int[len];                           // 用于暂存元素 
        int divide = 1;
        
        for(int i = 0; i < bit_num; i++){
            int[] count = new int[radix];                         // 用于计数排序
            
            for(int j = 0; j < len; j++){
                int value = (nums[j] / divide) % radix;
                count[value]++;
            }
            
            for(int j = 1; j < radix; j++){
                count[j] += count[j - 1];
            }
            
            for(int j = len - 1; j >= 0; j--){
                int value = (nums[j] / divide) % radix;
                int position = count[value] - 1;
                tempArray[position] = nums[j];
                count[value]--;
            }
            
            divide = divide * radix;
            System.arraycopy(tempArray, 0, nums, 0, len);
        }
    }
	
	
	
	/***********************   main   **************************/
	
	public static void main(String[] args){
		Sort t = new Sort();
		
		int [] array = {2,5,3,3,3,2,35,2,1,36,6,4,9,6,7}; 
		
		int [] array0 = new int[array.length];
		for(int i = 0; i < array.length; ++i)
			array0[i] = array[i];
		t.select_sort(array0);
		System.out.print("Select Sort: ");
		for(int i = 0; i < array0.length; ++i)
			System.out.print(array0[i] + ", ");
		System.out.println();
		
		int [] array1 = new int[array.length];
		for(int i = 0; i < array.length; ++i)
			array1[i] = array[i];
		t.insert_sort(array1);
		System.out.print("Insert Sort: ");
		for(int i = 0; i < array1.length; ++i)
			System.out.print(array1[i] + ", ");
		System.out.println();
		
		int [] array2 = new int[array.length];
		for(int i = 0; i < array.length; ++i)
			array2[i] = array[i];
		t.bubble_sort(array2);
		System.out.print("Bubble Sort: ");
		for(int i = 0; i < array2.length; ++i)
			System.out.print(array2[i] + ", ");
		System.out.println();
		
		int [] array3 = new int[array.length];
		for(int i = 0; i < array.length; ++i)
			array3[i] = array[i];
		t.recursive_merge_sort(array3, 0, array3.length-1);
		System.out.print("Merge Sort:  ");
		for(int i = 0; i < array3.length; ++i)
			System.out.print(array3[i] + ", ");
		System.out.println();
		
		int [] array4 = new int[array.length];
		for(int i = 0; i < array.length; ++i)
			array4[i] = array[i];
		t.quickSort(array4, 0, array4.length-1);
		System.out.print("Quick Sort:  ");
		for(int i = 0; i < array4.length; ++i)
			System.out.print(array4[i] + ", ");
		System.out.println();
		
		int [] array5 = new int[array.length];
		for(int i = 0; i < array.length; ++i)
			array5[i] = array[i];
		t.quickSort(array5, 0, array5.length-1);
		System.out.print("Quick Sort2:  ");
		for(int i = 0; i < array5.length; ++i)
			System.out.print(array5[i] + ", ");
		System.out.println();
		
		int [] array6 = new int[array.length];
		for(int i = 0; i < array.length; ++i)
			array6[i] = array[i];
		t.heapSort(array6);
		System.out.print("Heap Sort:   ");
		for(int i = 0; i < array6.length; ++i)
			System.out.print(array6[i] + ", ");
		System.out.println();
		
		int [] array7 = new int[array.length];
		for(int i = 0; i < array.length; ++i)
			array7[i] = array[i];
		t.countSort(array7, 36);
		System.out.print("Count Sort:  ");
		for(int i = 0; i < array7.length; ++i)
			System.out.print(array7[i] + ", ");
		System.out.println();
		
		int [] array8 = new int[array.length];
		for(int i = 0; i < array.length; ++i)
			array8[i] = array[i];
		t.radixSort(array8, 10, 2);
		System.out.print("Radix Sort:  ");
		for(int i = 0; i < array8.length; ++i)
			System.out.print(array8[i] + ", ");
		System.out.println();
	}	
}
