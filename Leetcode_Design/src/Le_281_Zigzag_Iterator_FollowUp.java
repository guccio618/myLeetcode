import java.util.*;
/*******
 * 
Follow up for Q281:
 * 
 * */
public class Le_281_Zigzag_Iterator_FollowUp {
	private Queue<Iterator> queue;
	
	public Le_281_Zigzag_Iterator_FollowUp(List<Integer>[] listArray) {
		queue = new LinkedList<>();
		
		for(List<Integer> list : listArray) {
			if(list.iterator().hasNext()) {
				queue.offer(list.iterator());
			}
		}
	}
	
	public int next() {
        if(hasNext() == false) {
            return -1;
        }
        
        Iterator iter = queue.poll();
        int ans = (int) iter.next();
        
        if(iter.hasNext()) {
            queue.offer(iter);
        }
        
        return ans;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*************************** main function *********************************/
    
    public static void main(String[] args) {
    	List<Integer>[] listArray = new List[3];
    	
    	for(int i = 0; i < 3; i++) {
    		listArray[i] = new ArrayList<>();
    		
    		for(int j = 0; j < 3; j++) {
    			listArray[i].add(j);
    		}
    	}
    	
    	Le_281_Zigzag_Iterator_FollowUp t = new Le_281_Zigzag_Iterator_FollowUp(listArray);
    	
    	for(int i = 0; i < 10; i++) {
    		System.out.println(t.hasNext());
    		
    		if(t.hasNext()) {
    			System.out.println(t.next());
    		}
    	}
    	
    	
    	
    }
}
