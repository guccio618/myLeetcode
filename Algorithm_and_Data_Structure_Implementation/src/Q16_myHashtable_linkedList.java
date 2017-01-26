import java.util.LinkedList;
import java.util.List;


public class Q16_myHashtable_linkedList {
	private List<Integer>[] dataList;
	private int used = 0;
	private int capacity = 100;
	
	public Q16_myHashtable_linkedList(){
		dataList = new List[capacity];
		
		for(int i = 0; i < capacity; i++){
			dataList[i] = new LinkedList<Integer>();
		}
	}
	
	public void add(int num){
		int pos = num % capacity;
		
		for(int element : dataList[pos]){
			if(num == element){
				return;
			}
		}
		
		dataList[pos].add(num);
		used++;
	}
	
	public void remove(int num){
		int pos = num % capacity;
		
		for(int i = 0; i < dataList[pos].size(); i++){
			if(num == dataList[pos].get(i)){
				dataList[pos].remove(i);
				used--;
				return;
			}
		}
	}
	
	public boolean contains(int num){
		int pos = num % capacity;
		
		for(int element : dataList[pos]){
			if(num == element){
				return true;
			}
		}
		
		return false;
	}
	
	public void print(){
		for(int i = 0; i < capacity; i++){
			if(dataList[i].size() > 0){
				for(int element : dataList[i]){
					System.out.print(element + ", ");
				}
			}
		}
		
		System.out.println();
	}
	
	
	
	public static void main(String[] args){
		Q16_myHashtable_linkedList t = new Q16_myHashtable_linkedList();
		int[] nums = {5,6,3,5,9,8,6,2,4,5,56,43,12,11};
		int index = 0;		
		
		System.out.println(t.contains(nums[index]));
		t.add(nums[index]);
		System.out.println(t.contains(nums[index]));
		index++;
		
		t.add(nums[index++]);
		t.add(nums[index++]);
		t.print();
		t.remove(6);
		t.print();
		
		while(index < nums.length){
			t.add(nums[index++]);
		}
		
		t.print();
		
	}
}
