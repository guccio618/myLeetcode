import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/******
 * 
Design a data structure that supports all following operations in average O(1) time.

Note: Duplicate elements are allowed.
insert(val): Inserts an item val to the collection.
remove(val): Removes an item val from the collection if present.
getRandom: Returns a random element from current collection of elements. 
The probability of each element being returned is linearly related to the number of same value the collection contains.

Example:

// Init an empty collection.
RandomizedCollection collection = new RandomizedCollection();

// Inserts 1 to the collection. Returns true as the collection did not contain 1.
collection.insert(1);

// Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
collection.insert(1);

// Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
collection.insert(2);

// getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
collection.getRandom();

// Removes 1 from the collection, returns true. Collection now contains [1,2].
collection.remove(1);

// getRandom should return 1 and 2 both equally likely.
collection.getRandom();
 * 
 * */

public class Q381_Insert_Delete_GetRandom_O_1_Duplicates_allowed {
	List<Integer> numbers;
	Map<Integer, Set<Integer>> number_pos_Map;
	java.util.Random rand = new java.util.Random();

	/** Initialize your data structure here. */
	public Q381_Insert_Delete_GetRandom_O_1_Duplicates_allowed() {
		numbers = new ArrayList<Integer>();
		number_pos_Map = new HashMap<Integer, Set<Integer>>();
	}

	/**
	 * Inserts a value to the collection. Returns true if the collection did not
	 * already contain the specified element.
	 */
	public boolean insert(int val) {
		boolean contain_flag = number_pos_Map.containsKey(val);

		if (!contain_flag) {
			number_pos_Map.put(val, new HashSet<Integer>());
		}

		number_pos_Map.get(val).add(numbers.size());
		numbers.add(val);
		return !contain_flag;
	}

	/**
	 * Removes a value from the collection. Returns true if the collection
	 * contained the specified element.
	 */
	public boolean remove(int val) {
		boolean contain_flag = number_pos_Map.containsKey(val);

		if (!contain_flag) {
			return false;
		}

		int pos = number_pos_Map.get(val).iterator().next();
		number_pos_Map.get(val).remove(pos);

		if (pos < numbers.size() - 1) {
			int lastElement = numbers.get(numbers.size() - 1);
			numbers.set(pos, lastElement);
			number_pos_Map.get(lastElement).remove(numbers.size() - 1);
			number_pos_Map.get(lastElement).add(pos);
		}

		numbers.remove(numbers.size() - 1);

		if (number_pos_Map.get(val).isEmpty()) {
			number_pos_Map.remove(val);
		}

		return true;
	}

	/** Get a random element from the collection. */
	public int getRandom() {
		return numbers.get(rand.nextInt(numbers.size()));
	}
}
