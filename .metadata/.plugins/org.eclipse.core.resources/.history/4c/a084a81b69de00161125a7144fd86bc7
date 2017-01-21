/*******************************************************************
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] 
 * is rotated to [5,6,7,1,2,3,4].
 *******************************************************************/

public class Q189_Rotate_Array {
	/*****************************************************/
	// by other, faster but not in place
	public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newList = new int[n];
        if (n > 1) {
            k = k % n;
            System.arraycopy(nums, n - k, newList, 0, k);
            System.arraycopy(nums, 0, newList, k, n - k);
            System.arraycopy(newList, 0, nums, 0, n);
        }
    }
	
	
	/*****************************************************/
	// by other, in place and O(1)
	public void rotate2(int[] nums, int k) {
        if(nums == null || k == 0) return;
        int len = nums.length;
        k %= len;
        int d = gcd(k, len);
        
        System.out.println("d = " + d);
        
        for(int i = 0; i < d; ++i){
            int record = nums[i];
            int idx = i + k;
            idx %= len;
            
            System.out.println("1: idx = " + idx);
            print(nums);
            
            while(idx != i){
                int temp = record;
                record = nums[idx];
                nums[idx] = temp;
                idx += k;
                idx %= len;
                
                System.out.println("2: idx = " + idx);
                print(nums);
                
            }
            int temp = record;
            record = nums[idx];
            nums[idx] = temp;
        }
    }
    
    public int gcd(int a, int b) {
        if(a % b == 0) return b;
        else return gcd(b, a % b);
    }
    
    public void print(int[] array){
    	for(int i = 0; i < array.length; ++i)
    		System.out.print(array[i] + ", ");
    	System.out.println();
    }
    
    
    public static void main(String[] args){
    	Q189_Rotate_Array t = new Q189_Rotate_Array();
    	int[] nums = {1,2,3,4,5,6,7,8,9};
    	t.rotate(nums, 3);
    	t.print(nums);
    }
    
}
