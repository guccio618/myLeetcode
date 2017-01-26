
public class Other_Minimun_of_the_maximun_distance_of_three_element {
	public int[] findMinDitance(int[] array1, int[] array2, int[] array3) {
		if(array1 == null || array1.length == 0 || array2 == null || array2.length == 0 || array3 == null || array3.length == 0 ){
			return new int[0];
		}
		
		int index1 = 0, index2 = 0, index3 = 0;
		int len1 = array1.length, len2 = array2.length, len3 = array3.length;
		int[] ans = new int[3];
		int distance = Integer.MAX_VALUE;
		
		while(index1 < len1 && index2 < len2 && index3 < len3) {
			int largest = Math.max(array1[index1], Math.max(array2[index2], array3[index3]));
			int smallest = Math.min(array1[index1], Math.min(array2[index2], array3[index3]));
			
			if(distance > largest - smallest) {
				distance = largest - smallest;
				ans[0] = index1;
				ans[1] = index2;
				ans[2] = index3;
			}
			
			if(array1[index1] == smallest) {
				index1++;
			} else if(array2[index2] == smallest) {
				index2++;
			} else {
				index3++;
			}
		}
		
		return ans;
	}
	
	
	
	public static void main(String[] args) {
		Other_Minimun_of_the_maximun_distance_of_three_element t = new Other_Minimun_of_the_maximun_distance_of_three_element();
//		int[] array1 = {1, 4, 10};
//		int[] array2 = {2, 15, 20};
//		int[] array3 = {10, 12};
		
		int[] array1 = {20, 24, 100};
		int[] array2 = {2, 19, 22, 79, 800};
		int[] array3 = {10, 12, 23, 24, 119};
		
		int[] indexs = t.findMinDitance(array1, array2, array3);
		
		System.out.println(array1[indexs[0]] + ", " + array2[indexs[1]] + ", " + array3[indexs[2]]);
		
	}
}
