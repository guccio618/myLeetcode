import java.util.Arrays;


public class Le_324_Wiggle_Sort_II {	
	/********************************************************/
	// by other, faster, nlogn
	public void wiggleSort(int[] nums) {
		if(nums == null || nums.length == 0){
            return ;
        }
        
        int len = nums.length;
        Arrays.sort(nums);
        int mid = (len % 2 == 0) ? len / 2 - 1 : len / 2;
        int index = 0;
        int[] temp = new int[len];
        
        for(int i = 0; i <= mid; i++){
            temp[index] = nums[mid - i];
            if(index + 1 < len){
                temp[index + 1] = nums[len - 1 - i];
            }
            index += 2;
        }
        
        System.arraycopy(temp, 0, nums, 0, len);
	}
	
	/********************************************************/
	// by Jackie
	public void wiggleSort2(int[] nums) {
		if(nums == null || nums.length == 0) return;
        int len = (nums.length % 2 == 0) ? nums.length/2 : nums.length/2+1;
        Arrays.sort(nums);
        int[] arraySmall = new int[len];
        int[] arrayLarge = new int[nums.length-len];
        
        for(int i = 0, n = nums.length, len1 = arraySmall.length; i < n; ++i){
            if(i <= len1-1)
                arraySmall[i] = nums[i];
            else
                arrayLarge[i-len1] = nums[i];
        }
        
        int flag = 0;
        int x = 0, y = 0;
        for(int i = 0, n = nums.length; i < n; ++i){
            if(flag++ % 2 == 0)
                nums[i] = arraySmall[x++];
            else
                nums[i] = arrayLarge[y++];
        }
        return;
    }
	
	
	public static void main(String[] args){
		Le_324_Wiggle_Sort_II t = new Le_324_Wiggle_Sort_II();
		int[] nums = {4,5,5,6};
		t.wiggleSort(nums);
		for(int i = 0; i < nums.length; ++i){
			System.out.print(nums[i] + ", ");
		}		
	}
	
	// 1 2 3 4 5 6 -7- 8 9 10 11 12 13
	// 13 2 3 4 5 6 7 8 9 10 11 12 1
}	
