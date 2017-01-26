import java.util.*;

public class Other_Add_Remove_Random_Remove {
	private Map<String, Integer> numberToPosMap;
    private List<String> numbers;
    private java.util.Random rand;
    
    /** Initialize your data structure here. */
    public Other_Add_Remove_Random_Remove() {
        numberToPosMap = new HashMap();
        numbers = new ArrayList();
        rand = new java.util.Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(String val) {
        if(numberToPosMap.containsKey(val)) {
            return false;
        }
        
        numbers.add(val);
        numberToPosMap.put(val, numbers.size() - 1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(String val) {
        if(!numberToPosMap.containsKey(val)) {
            return false;
        }
        
        int pos = numberToPosMap.get(val);
        
        if(pos < numbers.size() - 1) {
            String lastElement = numbers.get(numbers.size() - 1);
            numberToPosMap.put(lastElement, pos);
            numbers.set(pos, lastElement);
        }
        
        numbers.remove(numbers.size() - 1);
        numberToPosMap.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public String getRandom() {
        return numbers.get(rand.nextInt(numbers.size()));
    }
    
    /** Remove a random element from the set. */
    public boolean removeRandom() {
    	if(numbers.size() == 0) {
    		return false;
    	}
    	
    	int randomPos = rand.nextInt(numbers.size());
    	String randomRemoveElement = numbers.get(randomPos);
    	
    	if(randomPos < numbers.size() - 1) {
            String lastElement = numbers.get(numbers.size() - 1);
            numberToPosMap.put(lastElement, randomPos);
            numbers.set(randomPos, lastElement);
        }
        
        numbers.remove(numbers.size() - 1);
        numberToPosMap.remove(randomRemoveElement);
        return true;
    }
}
