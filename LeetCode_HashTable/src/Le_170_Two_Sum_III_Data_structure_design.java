import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Le_170_Two_Sum_III_Data_structure_design {
	private List<Integer> list = new ArrayList<Integer>();  // 使用list速度快一些
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();  

    // Add the number to an internal data structure.
	public void add(int number) {
	    if (map.containsKey(number)) map.put(number, map.get(number) + 1);
        else {
            map.put(number, 1);
            list.add(number);
        }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for (int i = 0; i < list.size(); i++){
            int num1 = list.get(i), num2 = value - num1;
            if ((num1 == num2 && map.get(num1) > 1) || (num1 != num2 && map.containsKey(num2))) {
            	return true;
            }
        }
        return false;
	}
	
	
	
	/********************************************************/
	// 使用entry遍历hash表，速度比第一种list的方法慢一些
	private Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();

    // Add the number to an internal data structure.
	public void add2(int number) {
	    map2.put(number, map2.containsKey(number) ? map2.get(number) + 1 : 1);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find2(int value) {
	    for(Map.Entry<Integer, Integer> entry : map2.entrySet()){
	    	int i = entry.getKey();
	    	int j = value - i;
	    	if(i == j && entry.getValue() > 1 || i != j && map2.containsKey(j)){
	    		return true;
	    	}
	    }
	    
	    return false;
	}
}
