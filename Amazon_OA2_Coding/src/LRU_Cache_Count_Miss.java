import java.util.*;

public class LRU_Cache_Count_Miss {
	public int Solution(int[] array, int size) {
		if (array == null){
			return 0;
		}
		
		List<Integer> cache = new LinkedList<Integer>();   // 这里必须用linkedlist
		int count = 0;
		
		for (int i = 0; i < array.length; i++) {
			if (cache.contains(array[i])) {
				cache.remove(new Integer(array[i]));    // 必须这样写，表示移除的是[i]，而不是这个index上的element ！！！
			} else {
				count++;
				
				if (size == cache.size()){
					cache.remove(0);
				}
			}
			
			cache.add(array[i]);      // 最后都要加 ！！！
		}
		
		return count;
	}
}
