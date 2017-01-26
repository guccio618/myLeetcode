import java.util.*;



public class Other_Add_Remove_Random_Remove_II {
	private Map<String, Set<Integer>> numberToPosMap;
    private List<String> numbers;
    private java.util.Random rand;
    
    /** Initialize your data structure here. */
    public Other_Add_Remove_Random_Remove_II() {
        numbers = new ArrayList<>();
        numberToPosMap = new HashMap<>();
        rand = new java.util.Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(String val) {
        boolean isContainFlag = numberToPosMap.containsKey(val);
        
        if(!isContainFlag) {
            numberToPosMap.put(val, new HashSet<Integer>());
        }
        
        numbers.add(val);
        numberToPosMap.get(val).add(numbers.size() - 1);
        return !isContainFlag;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
		if(!numberToPosMap.containsKey(val)) {
		    return false;
		}
		
		int pos = numberToPosMap.get(val).iterator().next();
		numberToPosMap.get(val).remove(pos);
		
		if(numberToPosMap.get(val).isEmpty()) {
		    numberToPosMap.remove(val);
		}
		
		if(pos < numbers.size() - 1) {
		    String lastElement = numbers.get(numbers.size() - 1);
		    numbers.set(pos, lastElement);
		    numberToPosMap.get(lastElement).remove(numbers.size() - 1);
		    numberToPosMap.get(lastElement).add(pos);
		}
		
		numbers.remove(numbers.size() - 1);
		return true;
    }
    
    /** Get a random element from the collection. */
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
    	numberToPosMap.get(randomRemoveElement).remove(randomPos);
    	
    	if(numberToPosMap.get(randomRemoveElement).isEmpty()) {
		    numberToPosMap.remove(randomRemoveElement);
		}
    	
    	if(randomPos < numbers.size() - 1) {
    		String lastElement = numbers.get(numbers.size() - 1);
		    numbers.set(randomPos, lastElement);
		    numberToPosMap.get(lastElement).remove(numbers.size() - 1);
		    numberToPosMap.get(lastElement).add(randomPos);
        }
        
        numbers.remove(numbers.size() - 1);
        return true;
    }
}
