import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class Le_356_Line_Reflection {
	public boolean isReflected(int[][] points) {
		if(points == null || points.length == 0 || points[0].length == 0){
            return true;
        } 
        
        Set<Integer> set = new HashSet<Integer>();
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        
        for(int[] point : points){
            minX = Math.min(minX, point[0]);
            maxX = Math.max(maxX, point[0]);
            set.add(Arrays.hashCode(point));
        }
        
        int sum = minX + maxX;
        
        for(int[] point : points){
            if(!set.contains(Arrays.hashCode(new int[]{sum - point[0], point[1]}))){
                return false;
            }
        }
        
        return true;
    }
    
	
	
    public static void main(String[] args){
    	Le_356_Line_Reflection t = new Le_356_Line_Reflection();
    	int[][] points = {
    			{1, 1},
    			{-1,1}
    	};
    	
    	System.out.println(t.isReflected(points));
    }
}
