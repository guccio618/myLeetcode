
public class Q447_Search_in_a_Big_Sorted_Array {
	// by Jackie
	// 倍增法
	public int searchBigSortedArray(ArrayReader reader, int target) {
        // write your code here
        if(reader == null){
            return -1;
        }
        int index = 1;
        while(reader.get(index) < target && reader.get(index) != -1){
            index *= 2;
        }
        int left = 0, right = index;
        while(left <= right){
            int mid = (left + right) / 2;
            if(reader.get(mid) < target){
                left = mid + 1;
            }
            else if(reader.get(mid) > target){
                right = mid - 1;
            }
            else{
                while(mid - 1 >= 0 && reader.get(mid - 1) == reader.get(mid))
                    --mid;
                return mid;
            }
        }
        return -1;
    }
	
	class ArrayReader{
		public int get(int pos){
			return 1;
		}
	}
}
