
public class Q14_1_Find_Word_In_Dice {
	public boolean FindWordInDice(String[] dices, String target) {
		if(target == null || target.length() == 0) {
			return true;
		} else if(dices == null || dices.length == 0) {
			return false;
		} 
		
		int len = dices.length;
		boolean[] visited = new boolean[len];
		return backtrack(dices, visited, 0, target);
	}
	
	public boolean backtrack(String[] dices, boolean[] visited, int strIndex, String target) {
		if(strIndex == target.length()) {
			return true;
		}
		
		for(int i = 0; i < dices.length; i++) {
			if(!visited[i] && dices[i].indexOf(target.charAt(strIndex)) >= 0) {
				visited[i] = true;
				if(backtrack(dices, visited, strIndex + 1, target)) {
					return true;
				}
				visited[i] = false;
			}
		}
		
		return false;
	}
	
	
		
	// follow up 1:
	public boolean FindWordInDice_follow_up_1(String[] dices, String target) {
		if(target == null || target.length() == 0) {
			return true;
		} else if(dices == null || dices.length == 0) {
			return false;
		}  
		
		int len = dices.length;
		boolean[] visited = new boolean[len];
		return backtrack1(dices, visited, 0, target);
	}
	
	public boolean backtrack1(String[] dices, boolean[] visited, int strIndex, String target) {
		if(strIndex == target.length()) {
			return true;
		}
		
		for(int i = 0; i < dices.length; i++) {
			if(!visited[i] && dices[i].indexOf(target.charAt(strIndex)) >= 0 || dices[i].indexOf('*') >= 0) {
				visited[i] = true;
				if(backtrack1(dices, visited, strIndex + 1, target)) {
					return true;
				}
				visited[i] = false;
			}
		}
		
		return false;
	}
	
	
	
	// follow up 2:
	public boolean FindWordInDice_follow_up_2(String[] dices, String target) {
		if(target == null || target.length() == 0) {
			return true;
		} else if(dices == null || dices.length == 0) {
			return false;
		}  

		return backtrack2(dices, 0, 0, target);
	}
	
	public boolean backtrack2(String[] dices, int diceIndex, int strIndex, String target) {
		if(strIndex == target.length()) {
			return true;
		}
		
		for(int i = diceIndex; i < dices.length; i++) {
			if(dices[i].indexOf(target.charAt(strIndex)) >= 0 || dices[i].indexOf('*') >= 0) {
				if(backtrack2(dices, i + 1, strIndex + 1, target)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	
	
	// follow up 3:
	public boolean FindWordInDice_follow_up_3(String[] dices, String target, int k) {
		if(target == null || target.length() == 0) {
			return true;
		} else if(dices == null || dices.length == 0) {
			return false;
		}  

		return backtrack3(dices, 0, 0, target, k);
	}
	
	public boolean backtrack3(String[] dices, int diceIndex, int strIndex, String target, int wrongNumLeft) {
		if(target.length() - strIndex <= wrongNumLeft) {
			return true;
		} else if(strIndex == target.length()) {
			return true;
		}
		
		for(int i = diceIndex; i < dices.length; i++) {
			if(dices[i].indexOf(target.charAt(strIndex)) >= 0 || dices[i].indexOf('*') >= 0) {
				if(backtrack3(dices, i + 1, strIndex + 1, target, wrongNumLeft)) {
					return true;
				}
			} else if(wrongNumLeft > 0) {
				if(backtrack3(dices, i + 1, strIndex + 1, target, wrongNumLeft - 1)) {
					return true;
				}
			}
		}

		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/********************************* main function ************************************/
	
	public static void main(String[] args) {
		Q14_1_Find_Word_In_Dice t = new Q14_1_Find_Word_In_Dice();
		String[] dices = {"ab*cd", "fghij", "klmno", "pqr*s"};
		String target = "bglts";
		System.out.println(t.FindWordInDice(dices, target));
		System.out.println(t.FindWordInDice_follow_up_1(dices, target));
		System.out.println(t.FindWordInDice_follow_up_2(dices, target));
		System.out.println(t.FindWordInDice_follow_up_3(dices, target, 2));
	}
}
