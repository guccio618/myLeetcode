import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;


public class Q000_Java_Sort {
	public static void main(String[] args){
	/********************* Arrays Sort ***********************/
		Pair[] pair = new Pair[5];
		for(int i = 0; i < pair.length; ++i)
			pair[i] = new Pair(5-i, i);
		
		System.out.println("before: ");
		for(int i = 0; i < pair.length; ++i)
			System.out.print(pair[i].val + ", ");
		System.out.println();
	
		Arrays.sort(pair, new Comparator<Pair> () {   // 参数1是array类型   
			public int compare(Pair p1, Pair p2) {
				return p1.val - p2.val;               // return 正数时换位置，从小到大排
	        } 
		});
		
		System.out.println("after: ");
		for(int i = 0; i < pair.length; ++i)
			System.out.print(pair[i].val + ", ");
		System.out.println();
	
	/******************* Collections Sort ********************/
		LinkedList<Pair> list = new LinkedList<Pair>();
        for(int i = 4; i >= 0; i--) {
            list.add(pair[i]);
        }
        
        System.out.println("before: ");
        for(int i = 0; i < list.size(); ++i)
			System.out.print(list.get(i).val + ", ");
		System.out.println();
		
		Collections.sort(list, new Comparator<Pair> () {  // 参数1是List类型 
			public int compare(Pair p1, Pair p2) {
				return p1.val - p2.val;
			}
		});
		
		System.out.println("after: ");
		for(int i = 0; i < list.size(); ++i)
			System.out.print(list.get(i).val + ", ");
		System.out.println();
	}
}

class Pair {
    int val;
    int index;
    Pair(int v, int i) {
        this.val = v;
        this.index = i;
    }
}
