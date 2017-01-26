import java.util.*;

public class Other_Play_Game {
	public boolean playGame(int n, int target) {
		if(n <= 0 || target <= 0 || (n+1) * n / 2 < target) {
			return false;
		} else if(target <= n) {
			return true;
		}
		
		boolean[] status = new boolean[n + 1];		
		return canWin(status, target);
	}
	
	public boolean canWin(boolean[] status, int numLeft) {
		for(int i = 1; i < status.length; i++) {
			if(status[i] == false) {
				if(i >= numLeft) {
					return true;
				} 
				
				status[i] = true;
				
				if(canWin(status, numLeft - i) == false){
					status[i] = false;
					return true;
				}
				
				status[i] = false;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Other_Play_Game t = new Other_Play_Game();
		System.out.println(t.playGame(9, 100));
	}
}
