/*******
 * 
 * give two arrays which are the permutation of numbers from 0 to 1-n, 
 * the first array in special order (orig), the second one is also in a special order (desired),
 * how to transfer orig to desired array only by swap number 0 with other number
 * 
 *******/

public class Find_Right_Order {
	public void transfer(int[] orig, int[] desired) {
		if(orig == null || orig.length == 0 || desired == null || desired.length == 0) {
			return;
		} else if(orig.length != desired.length) {
			return;
		}
		
		int len = orig.length;
		int zeroIndex = 0;
		
		for(int i = 0; i < len; i++) {
			if(orig[i] == 0) {
				zeroIndex = i;
				break;
			}
		}
		
		for(int pos = 0; pos < len; pos++) {
			swap(orig, zeroIndex, pos);
			zeroIndex = pos;
			int newPos = find(orig, desired[zeroIndex]);
			swap(orig, zeroIndex, newPos);
			zeroIndex = newPos;
		}
	}
	
	public void swap(int[] array, int x, int y) {
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}
	
	public int find(int[] orig, int target) {
		for(int i = 0; i < orig.length; i++) {
			if(orig[i] == target) {
				return i;
			}
		}
		
		return -1;
	}
	
	
	
	
	
	
	
	
	
	
	
	/****************************** main function *********************************/
	
	public static void main(String[] args) {
		Find_Right_Order t = new Find_Right_Order();
		int[] orig = {0, 1, 2, 3, 4};
		int[] desired = {0, 2, 1, 4, 3};
		t.transfer(orig, desired);
		
		for(int num : orig) {
			System.out.print(num + " ");
		}
	}
}
