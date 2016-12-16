/*****************************************************************
 * 此题中只要不被人know的，必定不是celebrity，因此可以优化时间复杂度至O(N)
 * 
 *****************************************************************/


public class Le_277_Find_the_Celebrity {
	public int findCelebrity(int n) {
        if(n <= 0){
            return -1;
        }
        
        int candidate = 0;
        
        for(int i = 1; i < n; i++){
            if(knows(candidate, i)){
                candidate = i;
            }
        }
        
        for(int i = 0; i < n; i++){
            if(candidate != i){
                if(!knows(i, candidate) || knows(candidate, i)){
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
