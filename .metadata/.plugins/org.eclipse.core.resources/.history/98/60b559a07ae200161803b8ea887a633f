
public class Q335_Self_Crossing {
	public boolean isSelfCrossing(int[] x) {
        if(x == null || x.length < 4){
            return false;
        }
        int xCoordinary = 0;
        int yCoordinary = 0;
           
        int len = x.length;
        int index = 0;
        
        while(len > 0){
        	System.out.println("x = " + xCoordinary + ", y = " + yCoordinary);
            if(len - 4 >= 0){
            	xCoordinary = x[index + 3] - x[index + 1] + xCoordinary;
                yCoordinary = x[index] - x[index + 2] + yCoordinary;         
                len -= 4;
                index += 4;
            } else {
                int[] dx = new int[4];
                if(len >= 1){ dx[0] = x[index];}
                if(len >= 2){ dx[1] = x[index + 1]; System.out.println("in here");}
                if(len >= 3){ dx[2] = x[index + 2];}
                System.out.println("1: x = " + xCoordinary + ", y = " + yCoordinary);
                System.out.println("in here" + dx[0] + ", " + dx[1] + ", " + dx[2] + ", " + dx[3]);
                System.out.println((dx[3] - dx[1]) + ", " + (dx[0] - dx[2]));
                xCoordinary = dx[3] - dx[1] + xCoordinary;
                yCoordinary = dx[0] - dx[2] + yCoordinary; 
                System.out.println("2: x = " + xCoordinary + ", y = " + yCoordinary);
                len = 0;
            }
        }
        
        System.out.println("x = " + xCoordinary + ", y = " + yCoordinary);
        
        if(xCoordinary >= 0 && yCoordinary >= 0){
            return true;
        } else {
            return false;
        }
    }
	
	
	
	public static void main(String[] args){
		Q335_Self_Crossing t = new Q335_Self_Crossing();
		int[] x = {1,2,2,3,4};
		System.out.println(t.isSelfCrossing(x));
	}
}
