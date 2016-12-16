import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class Q241_Different_Ways_to_Add_Parentheses {
	// by other using divide and conquer
	public List<Integer> diffWaysToCompute(String input) {
	    List<Character> operations = new ArrayList<Character>();
	    List<Integer> nums = new ArrayList<Integer>();
	    int number = 0;
	    for(int i=0, L=input.length(); i<L; i++) {
	        char ch = input.charAt(i);
	        if(!(ch-'0'<=9 && ch-'0'>=0)) {
	            nums.add(number);
	            operations.add(ch);
	            number = 0;
	        }
	        else {
	            number = number*10 + (ch-'0');
	        }
	    }
	    nums.add(number);
	    return diffWaysToCompute(nums, operations, 0, nums.size()-1);
	}

	private List<Integer> diffWaysToCompute(List<Integer> nums, List<Character> operations, int start, int end) {
	    List<Integer> list = new LinkedList<Integer>();
	    if(start == end) {
	        list.add(nums.get(start));
	        return list;
	    }
	    
	    for(int i=start; i<end; i++) {
	        List<Integer> leftRes = diffWaysToCompute(nums, operations, start, i);
	        List<Integer> rightRes = diffWaysToCompute(nums, operations, i+1, end);
	        for(int left : leftRes) {
	            for(int right : rightRes) {
	                switch(operations.get(i)) {
	                    case '+': list.add(left+right); break;
	                    case '-': list.add(left-right); break;
	                    case '*': list.add(left*right); break;
	                }
	            }
	        }
	    }
	    return list;
	}
	
	
	public static void main(String[] args){
		Q241_Different_Ways_to_Add_Parentheses t = new Q241_Different_Ways_to_Add_Parentheses();
		t.diffWaysToCompute("2*3-4*5");
	}
}	
