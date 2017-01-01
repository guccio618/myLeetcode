import java.util.HashMap;
/*******
 * 
You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to determine if the starting player can guarantee a win.

For example, given s = "++++", return true. The starting player can guarantee a win by flipping the middle "++" to become "+--+".

Follow up:
	Derive your algorithm's runtime complexity.
 * 
 * */

public class Le_294_Flip_Game_II {
	public boolean canWin(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        
        char[] status = s.toCharArray();
        return search(status);
    }
    
    public boolean search(char[] status) {
        for (int i = 0; i < status.length - 1; i++) {
            if (status[i] == '+' && status[i + 1] == '+') {
                status[i] = status[i + 1] = '-';
                
                if (!search(status)) {
                    status[i] = status[i + 1] = '+';
                    return true; 
                }
                
                status[i] = status[i + 1] = '+';
            }
        }
        
        return false;
    }
    
    
    
	
	public boolean canWin2(String s) {
	    HashMap<String, Boolean> memoize = new HashMap<String, Boolean>();
	    return canWinRec(s, memoize);
	}
	
	public boolean canWinRec(String s, HashMap<String, Boolean> memoize) {
	    if(memoize.containsKey(s)){
	        return memoize.get(s);
	    }

	    for(int i = 0; i < s.length() - 1; i++){
	        if(s.charAt(i) == '+' && s.charAt(i+1) == '+'){
	            String flipedString = s.substring(0,i) + "--" +  s.substring(i+2);
	            if(canWinRec(flipedString, memoize)){ // 
	                continue;
	            }
	            memoize.put(s, true);
	            return true;
	        }
	    }
	    memoize.put(s, false);
	    return false;
	}
	
	
	public boolean canWin3(String s) {
        if(s == null || s.length() == 0){
            return false;
        }
        
        int n = s.length();
        boolean[] state = new boolean[n];
        
        for(int i = 0; i < n; i++){
        	state[i] = (s.charAt(i) == '+') ? true : false; 
        }
        
        return search(state);
    }
    
    public boolean search(boolean[] state){
    	int n = state.length;
    	for(int i = 0; i < n - 1; i++){
    		if(state[i] && state[i + 1]){
    			state[i] = state[i + 1] = false;
    			if(!search(state)){
    				state[i] = state[i + 1] = true;
    				return true;
    			} else {
    				state[i] = state[i + 1] = true;
    			}
    		}
    	}
    	return false;
    }

    
    
    
    public static void main(String[] args){
    	Le_294_Flip_Game_II t = new Le_294_Flip_Game_II();
    	String str = "++++++++";
    	System.out.println(t.canWin(str));
    	System.out.println(t.canWin2(str));
    }
    
}
