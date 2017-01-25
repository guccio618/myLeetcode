import java.util.*;

public class P1_Window_Sum {
	// solution 1: time complexity O(n)
	public static List<Integer> GetSum(List<Integer> list, int windowSize) {		
		List<Integer> ans = new ArrayList<>();
		
		if(list == null || list.size() == 0 || windowSize <= 0) {
			return ans;
		} else if(windowSize > list.size()) {
			windowSize = list.size();
		}
		
		int startIndex = 0;
		int sum = 0;
		
		for(int i = 0; i < list.size(); i++) {
			sum += list.get(i);
			
			if(i + 1 >= windowSize) {
				if(i - startIndex + 1 > windowSize) {
					sum -= list.get(startIndex++);
				}
				
				ans.add(sum);
			}
		}
		
		return ans;
	}

	
	
	// solution 2: time complexity O(n^2)
	public List<Integer> GetSum2(List<Integer> A, int k) {
		ArrayList<Integer> result = new ArrayList<>();
		if (A == null || A.size() == 0 || k <= 0) {
			return result;
		}

		int count = 0;
		
		for (int i = 0; i < A.size(); i++) {
			count++;
			
			if (count >= k) {
				int sum = 0;
				
				for (int j = i; j >= i - k + 1; j--) {
					sum += A.get(j);
				}
				
				result.add(sum);
			}
		}
		
		return result;
	}

	
	
	
	
	
	
	
	
	
	/************************************* main function ***************************************/
	
	public static void main(String[] args) {
		P1_Window_Sum t = new P1_Window_Sum();
		List<Integer> A = new ArrayList<Integer>();
		int n = 7;
		int k = 3;

		for (int i = 1; i <= 7; i++) {
			A.add(i);
		}

		List<Integer> res1 = t.GetSum(A, k);
		List<Integer> res2 = t.GetSum2(A, k);

		for (int num : res1) {
			System.out.print(num + ", ");
		}
		System.out.println();

		for (int num : res2) {
			System.out.print(num + ", ");
		}
	}
}
