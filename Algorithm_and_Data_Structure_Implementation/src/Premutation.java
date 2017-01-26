import java.util.*;


public class Premutation {
	/*********************************** recursion *************************************/
	
	public void permute(int[] nums, int len){
		if(len == 0) {
			print(nums);
		}

		for(int i = 0; i <= len; ++i){
			swap(nums, i, len);
			permute(nums, len - 1);
			swap(nums, i, len);
		}
	}

	public void swap(int[] a, int x, int y){
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	
	public void print(int[] array){
		for(int i = 0; i < array.length; ++i) {
			System.out.print(array[i] + ", ");
		}
		System.out.println();
	}
	
	
	/*********************************** backtrack *************************************/
	
	public void permute_backtrack(int[] nums) {
		if(nums == null || nums.length == 0) {
			return ;
		}
		
		Arrays.sort(nums);   
		boolean[] visited = new boolean[nums.length];
		int[] solution = new int[nums.length];
		backtrack(nums, visited, solution, 0);
	}
	
	
	public void backtrack(int[] array, boolean[] visited, int[] solution, int solutionIndex) {
		if(solutionIndex == array.length) {
			print(solution);
			return;
		}
		
		for(int i = 0; i < array.length; i++) {
			if(visited[i] == false) {
				visited[i] = true;
				solution[solutionIndex] = array[i];
				backtrack(array, visited, solution, solutionIndex + 1);
				visited[i] = false;
				
				// remove duplicate
				while(i + 1 < array.length && array[i] == array[i + 1]) {
					i++;
				}
			}
		}
	}
	
	
	
	/*********************************** next permute *************************************
	 * 如输入：1 4 6 5 3 2
	 * step1：从右往左找到第一个破坏升序(非严格)的元素，此例中为4.记下标为 i
     * step2: 依然从右往左,找到第一个大于4的元素，此例中5，交换4和5.
     * step3：从i+1到最右端，逆置。6 4 3 2 to 2 3 4 6
	 * 
	 **************************************************************************************/
	
	public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return ;
        }
        
        int len = nums.length;
        int index1 = len - 2, index2 = len - 1;
        
        while(index1 >= 0 && nums[index1] >= nums[index1 + 1]) {
            index1--;
        }
        
        if(index1 >= 0) {
            while(index2 >= 0 && nums[index2] <= nums[index1]) {
                index2--;
            }
            
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }
        
        reverseArray(nums, index1 + 1, len - 1);
    }
    
    public void reverseArray(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
	
	
	
	/*********************************** kth permute *************************************
    * The pattern was that:
		say n = 4, you have {1, 2, 3, 4}
		If you were to list out all the permutations you have

		1 + (permutations of 2, 3, 4) 
		2 + (permutations of 1, 3, 4) 
		3 + (permutations of 1, 2, 4) 
		4 + (permutations of 1, 2, 3)

		We know how to calculate the number of permutations of n numbers... n! So each of those with permutations of 3 numbers means there are 6 possible permutations. Meaning there would be a total of 24 permutations in this particular one. So if you were to look for the (k = 14) 14th permutation, it would be in the
		3 + (permutations of 1, 2, 4) subset.
		To programmatically get that, you take k = 13 (subtract 1 because of things always starting at 0) and divide that by the 6 we got from the factorial, which would give you the index of the number you want. In the array {1, 2, 3, 4}, k/(n-1)! = 13/(4-1)! = 13/3! = 13/6 = 2. The array {1, 2, 3, 4} has a value of 3 at index 2. So the first number is a 3.
		
		Then the problem repeats with less numbers.
		The permutations of {1, 2, 4} would be:

		1 + (permutations of 2, 4) 
		2 + (permutations of 1, 4) 
		4 + (permutations of 1, 2)

		But our k is no longer the 14th, because in the previous step, we've already eliminated the 12 4-number permutations starting with 1 and 2. So you subtract 12 from k.. which gives you 1. Programmatically that would be...
		k = k - (index from previous) * (n-1)! = k - 2(n-1)! = 13 - 2(3)! = 1
		In this second step, permutations of 2 numbers has only 2 possibilities, meaning each of the three permutations listed above a has two possibilities, giving a total of 6. We're looking for the first one, so that would be in the 1 + (permutations of 2, 4) subset.
		Meaning: index to get number from is k / (n - 2)! = 1 / (4-2)! = 1 / 2! = 0.. from {1, 2, 4}, index 0 is 1

		so the numbers we have so far is 3, 1... and then repeating without explanations.

		{2, 4} 
		k = k - (index from pervious) * (n-2)! = k - 0 * (n - 2)! = 1 - 0 = 1; 
		third number's index = k / (n - 3)! = 1 / (4-3)! = 1/ 1! = 1... from {2, 4}, index 1 has 4 
		Third number is 4

		{2} 
		k = k - (index from pervious) * (n - 3)! = k - 1 * (4 - 3)! = 1 - 1 = 0; 
		third number's index = k / (n - 4)! = 0 / (4-4)! = 0/ 1 = 0... from {2}, index 0 has 2 
		Fourth number is 2

		Giving us 3142. If you manually list out the permutations using DFS method, it would be 3142. Done! It really was all about pattern finding.
	
	***************************************************************************************************************/
	
	public String getPermutation(int n, int k) {
        if(n <= 0 || k <= 0) {
            return "";
        }
        
        int[] factors = new int[n + 1];
        factors[0] = 1;
        List<Integer> numbers = new LinkedList<Integer>();
        StringBuilder builder = new StringBuilder();
        
        for(int i = 1; i <= n; i++) {
            factors[i] = factors[i - 1] * i;
            numbers.add(i);
        }
        
        k--;
        
        for(int i = 1; i <= n; i++) {
            int index = k / factors[n - i];
            builder.append(numbers.get(index));
            numbers.remove(index);
            k -= index * factors[n - i];
        }
        
        return builder.toString();
    }
	
	
	
	
	
	/*********************************** main function *************************************/
	
	public static void main(String[] args){
		Premutation p = new Premutation();
		int[] nums = {1, 2, 3};
		p.permute(nums, 2);
		System.out.println();
		p.permute_backtrack(nums);
		//p.print(array);
	}
}
