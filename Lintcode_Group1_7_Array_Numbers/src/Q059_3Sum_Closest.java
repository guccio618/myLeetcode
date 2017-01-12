import java.util.Arrays;


public class Q059_3Sum_Closest {
	// by Jackie
	public int threeSumClosest(int[] numbers ,int target) {
        Arrays.sort(numbers);
        int n = numbers.length;
        int diff = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < n - 2; ++i){
            int front = i + 1, back = n - 1;
            int sum = 0;
            while(front < back){
                sum = numbers[i] + numbers[front] + numbers[back];
                if(diff > Math.abs(target - sum)){
                	diff = Math.abs(target - sum);
                	result = sum;
                }
                if(sum < target){
                    front++;
                }
                else if(sum > target){
                    back--;
                }
                else{
                    return result;
                }
            }
        }
        return result;
    }
	
	
	public static void main(String[] args){
		Q059_3Sum_Closest t = new Q059_3Sum_Closest();
		int[] numbers = {2,7,11,15};
		System.out.println(t.threeSumClosest(numbers, 3));
	}
}
