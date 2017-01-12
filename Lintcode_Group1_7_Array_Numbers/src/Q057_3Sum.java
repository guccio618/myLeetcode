import java.util.ArrayList;
import java.util.Arrays;


public class Q057_3Sum {
	// by Jackie
	public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        ArrayList<ArrayList<Integer>> res = new  ArrayList<ArrayList<Integer>>();
        if(numbers == null || numbers.length == 0){
            return res;
        }
        int len = numbers.length;
        Arrays.sort(numbers);
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(numbers, 0, 0, res, list);
        return res;
    }
    
    public void helper(int[] numbers, int pos, int sum, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list){
        if(list.size() == 3){
            if(sum == 0){
                res.add(new ArrayList<Integer>(list));  
            }
            return;
        }       

        for(int i = pos; i < numbers.length; ++i){
        	if(i != pos && numbers[i] == numbers[i-1]){
        		continue;
        	}
        	list.add(numbers[i]);
        	helper(numbers, i + 1, sum + numbers[i], res, list);
        	list.remove(list.size() - 1);
        }  
    }
    
    
    public static void main(String[] args){
    	Q057_3Sum t = new Q057_3Sum();
    	int[] numbers = {-2,-3,5,-1,-4,5,-11,7,1,2,3,4,-7,-1,-2,-3,-4,-5};
    	ArrayList<ArrayList<Integer>> res = t.threeSum(numbers);
    	
    	for(int i = 0; i < res.size(); ++i){
    		for(int j = 0; j < res.get(i).size(); ++j){
    			System.out.print(res.get(i).get(j) + ", ");
    		}
    		System.out.println();
    	}
    }
}
