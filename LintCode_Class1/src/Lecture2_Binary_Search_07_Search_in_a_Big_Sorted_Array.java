
public class Lecture2_Binary_Search_07_Search_in_a_Big_Sorted_Array {
	/******************************************************************************************
    *  Binary Search
    * 		Algorithm:
    * 			(1). get the index that ArrayReader.get(index) >= target or == -1 in O(log k)
    * 			(2). Binary search the target between 0 and index
    * 
	*******************************************************************************************/
	
	public int searchBigSortedArray(ArrayReader reader, int target) {       
        int index = 1;
        
        // 先找到开始执行二分搜索的上限；
        while (reader.get(index - 1) < target && reader.get(index - 1) != -1) {
            index = index * 2;
        }
        
        int start = 0, end = index - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (reader.get(mid) < target && reader.get(mid) != -1) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (reader.get(start) == target) {
            return start;
        }
        
        if (reader.get(end) == target) {
            return end;
        }
        
        return -1;
    }
	
	
	
	class ArrayReader{
		public int get(int pos){
			return pos;
		}
	}
}
