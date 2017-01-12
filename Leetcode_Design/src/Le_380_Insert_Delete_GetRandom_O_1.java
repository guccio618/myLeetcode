import java.util.ArrayList;
import java.util.HashMap;

/******
 * 
Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
Example:

// Init an empty set.
RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomSet.insert(1);

// Returns false as 2 does not exist in the set.
randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
randomSet.getRandom();

// Removes 1 from the set, returns true. Set now contains [2].
randomSet.remove(1);

// 2 was already in the set, so return false.
randomSet.insert(2);

// Since 1 is the only number in the set, getRandom always return 1.
randomSet.getRandom();

 * 
 * */

public class Le_380_Insert_Delete_GetRandom_O_1 {
	private ArrayList<Integer> numbers;
    private HashMap<Integer, Integer> number_pos_Map;
    private java.util.Random rand = new java.util.Random();

    /** Initialize your data structure here. */
    public Le_380_Insert_Delete_GetRandom_O_1() {
        numbers = new ArrayList<Integer>();
        number_pos_Map = new HashMap<Integer, Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(number_pos_Map.containsKey(val)){
            return false;   
        } 
        
        numbers.add(val);
        number_pos_Map.put(val, numbers.size() - 1);    
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!number_pos_Map.containsKey(val)){ 
            return false;
        }
        
        int pos = number_pos_Map.get(val);
        number_pos_Map.remove(val);
        
        if (pos < numbers.size() - 1) { // not the last one then swap the last one with this val
            int lastElement = numbers.get(numbers.size() - 1);
            numbers.set(pos, lastElement);
            number_pos_Map.put(lastElement, pos);
        }
        
        numbers.remove(numbers.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return numbers.get(rand.nextInt(numbers.size()));
    }
}
