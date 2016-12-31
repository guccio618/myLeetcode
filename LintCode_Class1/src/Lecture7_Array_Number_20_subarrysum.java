
public class Lecture7_Array_Number_20_subarrysum {
	public void quickSort(int[] nums, int left, int right){
		if(left < right){
			int m = partition(nums, left, right);
			quickSort(nums, left, m);
			quickSort(nums, m + 1, right);
		}
	}
	
	public int partition(int[] nums, int left, int right){
		int i = left, j = right;
		double pivot = (nums[left] + nums[right]) / 2.0;
		while (i < j) {
			while (i < right && nums[i] < pivot) {
				i++;
			}
			while (j > left && nums[j] >= pivot) {
				j--;
			}
			if (i < j) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			}
		}
		return j;
	}
	
	
	public void print(int[] nums){
		for(int i = 0; i < nums.length; ++i){
			System.out.print(nums[i] + ", ");
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		Lecture7_Array_Number_20_subarrysum t = new Lecture7_Array_Number_20_subarrysum();
		int[] nums = {2,5,3,3,3,2,35,2,1,36,6,4,9,6,7};
		t.quickSort(nums, 0, nums.length - 1);
		t.print(nums);
	}
}
