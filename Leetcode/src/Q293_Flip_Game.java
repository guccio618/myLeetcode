import java.util.ArrayList;
import java.util.List;


public class Q293_Flip_Game {
	public List<String> generatePossibleNextMoves(String s) {
        List<String> ans = new ArrayList<String>();
        if(s == null || s.length() <= 1){
            return ans; 
        }
        
        int n = s.length();
        char[] array = s.toCharArray();
        
        for(int i = 0; i < n - 1; i++){
            if(array[i] == '+' && array[i + 1] == '+'){
                array[i] = '-';
                array[i + 1] = '-';
                ans.add(new String(array));
                array[i] = '+';
                array[i + 1] = '+';
            }
        }
        
        return ans;
    }
}
