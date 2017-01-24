import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/********
 * 
A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

Each LED represents a zero or one, with the least significant bit on the right.


For example, the above binary watch reads "3:25".

Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.

Example:

Input: n = 1
Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
Note:
The order of output does not matter.
The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".

 * 
 * */

public class Q401_Binary_Watch {
	public List<String> readBinaryWatch(int num) {
        List<String> ans = new ArrayList<>();
        
        if(num < 0 || num > 10) {
            return ans;
        }
        
        backtrack(ans, new int[10], 0, num, 0);  
        return ans;
    }
    
    public void backtrack(List<String> ans, int[] lights, int lightNum, int num, int pos) {
        if(lightNum == num) {
            int part1 = 0;
            int base1 = 1;
            
            for(int i = 3; i >= 0; i--) {
                part1 += lights[i] * base1;
                base1 *= 2;
            }
            
            int part2 = 0;
            int base2 = 1;
            
            for(int i = 9; i >= 4; i--) {
                part2 += lights[i] * base2;
                base2 *= 2;
            }
            
            if(part1 >= 12 || part2 >= 60) {
                return;
            } else {
                String str1 = Integer.toString(part1);
                String str2 = Integer.toString(part2);
                str2 = str2.length() == 1 ? "0" + str2 : str2;
                ans.add(str1 + ":" + str2);
            }
        } else {
            for(int i = pos; i < lights.length; i++) {
                if(lights[i] == 0) {
                    lights[i] = 1;
                    backtrack(ans, lights, lightNum + 1, num, i + 1);
                    lights[i] = 0;
                }
            }    
        }
    }
	
	
    
    
    
    
    
    
    
    /********************************** main function ***************************************/
    
	public List<String> readBinaryWatch2(int num) {
		List<String> ans = new ArrayList<String>();
		
		if(num < 0 || num > 10){
			return ans;
		}
		
		for(int i = 0; i <= num; i++){
			if(i <= 4 && num - i <= 6){
				parse(ans, i, num - i);
			}
		}
		
		return ans;
    }
	
	public void parse(List<String> ans, int upNum, int downNum){
		Set<Integer> left = new HashSet<Integer>();
		Set<Integer> right = new HashSet<Integer>();
		boolean[] flag_left = new boolean[4];
		boolean[] flag_right = new boolean[6];
		backtrack(upNum, left, 0, flag_left);
		backtrack(downNum, right, 0, flag_right);
		
		for(int leftNum : left){
			for(int rightNum : right){
				StringBuilder builder = new StringBuilder();
				String rightStr = rightNum < 10 ? "0" + Integer.toString(rightNum) : Integer.toString(rightNum);
				builder.append(leftNum).append(":").append(rightStr);
				ans.add(builder.toString());
			}
		}
	}
	
	public void backtrack(int lightNum, Set<Integer> set, int solution, boolean[] flag){
		if(flag.length == 4 && solution >= 12){    // 12:00不算？？？
			return ;
		} else if(flag.length == 6 && solution > 59){
			return ;
		} else if(lightNum == 0){
			set.add(solution);
			return ;
		}
				
		for(int i = 0; i < flag.length; i++){
			if(flag[i] == false){
				flag[i] = true;
				backtrack(lightNum - 1, set, solution + (1 << i), flag);
				flag[i] = false;
			}
		}
	}

	
	
	public static void main(String[] args){
		Q401_Binary_Watch t = new Q401_Binary_Watch();
		List<String> ans = t.readBinaryWatch(2);
		
		for(String str : ans){
			System.out.println(str);
		}
	}
}
