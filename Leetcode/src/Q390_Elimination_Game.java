public class Q390_Elimination_Game {
	// by Jackie
	public int lastRemaining(int n) {
		if(n == 1){
            return 1;
        }
		
        int index = 0;
        int radix = 4;
        int leftBound = 2, rightBound = n % 2 == 0 ? n : n - 1;
        int size = n / 2;
               
        while(size > 2){  
        	if(index % 2 == 0){        		
        		rightBound -= radix / 2;       		
        		leftBound = size % 2 == 0 ? leftBound : leftBound + radix / 2;
        	} else {        		
        		leftBound += radix / 2;       		
        		rightBound = size % 2 == 0 ? rightBound : rightBound - radix / 2;
        	}
        	
        	index++;
        	radix *= 2;
        	size /= 2;
        }

        return index % 2 == 0 ? leftBound : rightBound;
    }
	

	
	public static void main(String[] args){
		Q390_Elimination_Game t = new Q390_Elimination_Game();
		System.out.println(t.lastRemaining(20));
	}
}
