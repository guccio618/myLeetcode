public class Q365_Water_and_Jug_Problem {
	// by other using math
	public boolean canMeasureWater(int x, int y, int z) {
        if(z == x + y || x == z || y == z || z == 0){
            return true;
        } else if(x == 0 || y == 0 || z > x + y || z % gcd(x, y) != 0){
            return false;
        }
        
        return true;
    }
    
    public int gcd(int x, int y){
        if(y == 0){
            return x;
        }
        
        int large = (x > y) ? x : y;
        int small = (x > y) ? y : x;
        
        return gcd(small, large % small);
    }
	
	
	
	public static void main(String[] args){
		Q365_Water_and_Jug_Problem t = new Q365_Water_and_Jug_Problem();
		System.out.println(t.canMeasureWater(13, 11, 1));
	}
}
