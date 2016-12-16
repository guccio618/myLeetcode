import java.util.ArrayList;
import java.util.List;


public class Q386_Lexicographical_Numbers {
	// by other
	public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<Integer>();
        
        if(n <= 0){
            return ans;
        }
        
        int current = 1;
        
        for(int i = 1; i <= n; i++){
            ans.add(current);
            
            if(current * 10 <= n){
                current *= 10;
            } else if(current % 10 != 9 && current + 1 <= n){
                current++;
            } else {
                while((current / 10) % 10 == 9){
                    current /= 10;
                }
                
                current = current / 10 + 1;
            }
        }
        
        return ans;
    }
}
