/***************************************************
 * 注意题型： **004, *081, 153, **179, 215, *274
 * 
 ***************************************************/



public class Datastructure_Definition {
	public static void main(String[] args){
		int n = 6;
        
        int count = 0;
        for(int i = 0; i < 32; i++){
        	count += (n >> i) & 1;
        }
        
        System.out.println(count);
	}
}

class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}
