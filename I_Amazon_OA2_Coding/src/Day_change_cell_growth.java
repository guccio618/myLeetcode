import java.util.*;

public class Day_change_cell_growth {
	public int[] Solution(int[] days, int n) {
		if(days == null || days.length == 0 || n <= 0) {
			return days;
		}
		
		int len = days.length;
		int[] tempDays = new int[len + 2];
		tempDays[0] = tempDays[len + 1] = 0;
		int prevDayStatus = 0;
		
		for (int i = 1; i <= len; i++){
			tempDays[i] = days[i - 1];
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= len; j++) {
				int temp = tempDays[j];                // 拿temp记录一下之前的数值 ！！！
				tempDays[j] = prevDayStatus ^ tempDays[j + 1];
				prevDayStatus = temp;
			}
		}
		
		int[] ans = new int[len];
		
		for(int i = 0; i < len; i++){
			ans[i] = tempDays[i + 1];
		}
		
		return ans;
	}
	
	
	
	public static void main(String[] args){
		Day_change_cell_growth t = new Day_change_cell_growth();
		int[] days = {1, 0, 0, 0, 0, 1, 0, 0};
		int[] ans = t.Solution(days, 1);
		
		for(int num : days){
			System.out.print(num + ", ");
		}
		System.out.println();
		
		for(int num : ans){
			System.out.print(num + ", ");
		}
	}
}
