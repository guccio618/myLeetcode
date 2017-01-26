
public class Q16_myHashtable_lineProbing {
	private int[] dataArray;           // 输入为Integer时使用
	private String[] dataStringArray;  // 输入为String时使用
	private int capacity;
	private int used;
	private int initialSize = 100;
	private int prime = 31;
	
	// 主体函数
	public Q16_myHashtable_lineProbing(){
		capacity = initialSize;
		dataArray = new int[capacity];
		used = 0;
		dataStringArray = new String[capacity];
		
		for(int i = 0; i < capacity; i++){
			dataArray[i] = Integer.MIN_VALUE;
		}
	}
	
	public void add(Integer num){
		if(used == capacity){
			grow();
		}
		
		int pos = lineProbing(num);
		dataArray[pos] = num;
		used++;
	}
	
	public void add(String str){
		if(used == capacity){
			grow();
		}
		
		int value = 0;
		
		for(char c : str.toCharArray()){
			value = (value * prime + (int) c) % capacity;
		}
		
		int pos = lineProbing(value);
		dataStringArray[pos] = str;
	}
	
	public boolean contains(int num){
		if(used == 0){
			return false;
		}
		
		int pos = num % capacity;
		
		while(dataArray[pos] != Integer.MIN_VALUE && num != dataArray[pos]){
			pos = (++pos) % capacity;
		}
		
		return num == dataArray[pos];
	}
	
	public boolean remove(int num){
		if(used == 0){
			return false;
		}
		
		int pos = num % capacity;
		
		while(dataArray[pos] != Integer.MIN_VALUE && num != dataArray[pos]){
			pos = (++pos) % capacity;
		}
		
		if(num == dataArray[pos]){
			dataArray[pos] = Integer.MIN_VALUE;
			used--;
			return true;
		} else {
			return false;
		}
	}
	
	// 辅助函数
	public void grow(){
		int[] tempArray = dataArray;
		capacity = capacity * 2;
		dataArray = new int[capacity];
		
		for(int i = 0; i < capacity; i++){
			dataArray[i] = Integer.MIN_VALUE;
		}
		
		for(int num : tempArray){
			int pos = lineProbing(num);
			dataArray[pos] = num;
		}
	}
	
	public int lineProbing(int num){
		int pos = num % capacity;
		
		while(dataArray[pos] != Integer.MIN_VALUE && num != dataArray[pos]){
			pos = (++pos) % capacity;
		}
		
		return pos;
	}	
	
	public void print(){
		for(int i = 0; i < capacity; i++){
			if(dataArray[i] != Integer.MIN_VALUE){
				System.out.print(dataArray[i] + ", ");
			}
		}
		
		System.out.println();
	}
	
	
	
	public static void main(String[] args){
		Q16_myHashtable_lineProbing t = new Q16_myHashtable_lineProbing();
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
