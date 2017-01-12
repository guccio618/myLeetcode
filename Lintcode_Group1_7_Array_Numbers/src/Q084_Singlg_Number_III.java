import java.util.ArrayList;
import java.util.List;


public class Q084_Singlg_Number_III {
	/*******************************************************************************
	 * 首先计算nums数组中所有数字的异或，记为xor, 令lowbit = xor & -xor，lowbit的含义
	 * 为xor从低位向高位，第一个非0位所对应的数字。 例如假设xor = 6（二进制：0110），
	 * 则-xor为（二进制：1010，-6的补码，two's complement）， 则lowbit = 2（二进制：0010）
	 * 根据异或运算的性质，“同0异1” 记只出现一次的两个数字分别为a与b，可知a & lowbit与b & lowbit
	 * 的结果一定不同通过这种方式，即可将a与b拆分开来
	 *******************************************************************************/
	// by other
	
	public List<Integer> singleNumberIII(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        
        int lastBit = xor & -xor;  // 从低位到高位，第一个非0的位置， 如0110和1010，lastBit = 2

        int group0 = 0, group1 = 0;
        for (int i = 0; i < nums.length; i++) {  // group0 & lastBit 与 group1 & lastBit一定不同
            if ((lastBit & nums[i]) == 0) {      // 分为两组，一组含group0
                group0 ^= nums[i];
            } else {                             // 另一组含group1
                group1 ^= nums[i];
            }
        }
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(group0);
        result.add(group1);
        return result;
    }
	
	
	public static void main(String[] args){
		Q084_Singlg_Number_III t = new Q084_Singlg_Number_III();
		int[] nums = {1,2,2,3,4,4,7,3};
		t.singleNumberIII(nums);
	}
}
