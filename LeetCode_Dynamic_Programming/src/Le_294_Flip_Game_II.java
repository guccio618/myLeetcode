import java.util.HashMap;


public class Le_294_Flip_Game_II {
	public boolean canWin(String s) {
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
	
	
	public boolean canWin2(String s) {
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
}
