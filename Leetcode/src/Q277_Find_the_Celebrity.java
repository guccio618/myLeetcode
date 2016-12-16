
public class Q277_Find_the_Celebrity {
	public int findCelebrity(int n) {
        if(n <= 0){
            return -1;
        }
        
        int candidate = 0;
        
        for(int i = 0; i < n; i++){
            if(knows(candidate, i)){   
                candidate = i;
            }
        }
        
        for(int i = 0; i < n; i++){    
            if(candidate != i){        // 注意candidate != i ！！！
                if(!knows(i, candidate) || knows(candidate, i)){  // 做两个检验 ！！！
                    return -1;
                }
            }
        }
        
        return candidate;
    }
	
	
		
	public boolean knows(int x, int y){
		return true;
	}
}
