import java.util.*;
/*******
 * 
Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

For example,
	add(1); add(3); add(5);
	find(4) -> true
	find(7) -> false
	
 * 
 * */



public class Q170_Two_Sum_III_Data_structure_design {
	// this method, insert O(1), find O(n), which is used in write heavy
	
	private List<Integer> list = new ArrayList<Integer>();
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    // Add the number to an internal data structure.
    public void add(int number) {
    	if(map.containsKey(number)){
	        map.put(number, map.get(number) + 1);
	    } else {
	        map.put(number, 1);
	        list.add(number);
	    }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
    	for(int i = 0; i < list.size(); i++){
	        int num1 = list.get(i);
	        int num2 = value - num1;
	        
	        if(num1 == num2 && map.get(num1) > 1 || num1 != num2 && map.containsKey(num2)){
	            return true;
	        }
	    }
	    
	    return false;
    }
	
    
    
    // in this method, insert O(n), find O(1), which is used in read heavy
    private Set<Integer> numbers = new HashSet();
    private Set<Integer> sums = new HashSet();
    
    public void add2(int number) {
    	for(int num : numbers) {
	        sums.add(num + number);
	    }
	    
	    numbers.add(number);
    }
    
    public boolean find2(int value) {
    	return sums.contains(value);
    }
    
    
    
//	private Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//
//    // Add the number to an internal data structure.
//	public void add(int number) {
//	    map.put(number, map.containsKey(number) ? map.get(number) + 1 : 1);
//	}
//
//    // Find if there exists any pair of numbers which sum is equal to the value.
//	public boolean find(int value) {
//	    for(Map.Entry<Integer, Integer> entry : map.entrySet()){
//	    	int i = entry.getKey();
//	    	int j = value - i;
//	    	if(i == j && entry.getValue() > 1 || i != j && map.containsKey(j)){
//	    		return true;
//	    	}
//	    }
//	    
//	    return false;
//	}
	
	
	public static void main(String[] args){
		Q170_Two_Sum_III_Data_structure_design t = new Q170_Two_Sum_III_Data_structure_design();
		t.add(0);
		t.add(0);
		System.out.println(t.find(0));		
	}
}
