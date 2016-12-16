import java.util.Arrays;

public class Q000_Algorithm_Greedy {
	public void greedy(int[] weight, int[] value, int capacity) {
		/** 
         * 按单位重量价值r[i] = v[i] / w[i]降序排列 
		 * ps:排序用到了选择排序，详情请查看选择排序 
         */  
		int num = weight.length;
        double[] rate = new double[num];  
        int[] index = new int[num];   // 存放排序前的数组顺序
        for (int i = 0; i < num; i++) {  
            rate[i] = (double) value[i] / (double) weight[i];  
            index[i] = i;  
        }  
        double temp = 0;  
        for (int i = 0; i < num - 1; i++) {  
            for (int j = i + 1; j < num; j++) {  
                if (rate[i] < rate[j]) {  
                    temp = rate[i];  
                    rate[i] = rate[j];  
                    rate[j] = temp;  
                    
                    int x = index[i];  
                    index[i] = index[j];  
                    index[j] = x;  
                }  
            }  
        }  
        /** 
         * 排序后的重量和价值分别存到weightNew[]和valueNew[]中 
         */  
        int[] weightNew = new int[num];  
        int[] valueNew = new int[num];  
        for (int i = 0; i < num; i++) {  
            weightNew[i] = weight[index[i]];  
            valueNew[i] = value[index[i]];  
        }  
        /** 
         * 初始化解向量occupied[num] 
         */  
        int[] occupied = new int[num];  
        for (int i = 0; i < num; i++) {  
            occupied[i] = 0;  
        }  
        /** 
         * 求解并打印解向量 
         */  
        for (int i = 0; i < num; i++) {  
            if (weightNew[i] < capacity) {  
                occupied[index[i]] = 1;  
                capacity = capacity - weightNew[i];  
            }  
        }  
        System.out.println("The solution vector is: " + Arrays.toString(occupied));

        /** 
         * 根据解向量求出背包中存放物品的最大价值并打印 
         */  
        int maxValue = 0;  
        for (int i = 0; i < num; i++) {  
            if (occupied[i] == 1)  
                maxValue += valueNew[i];  
        }  
        System.out.println("Now, the largest values of objects in the pack is: " + maxValue);  
    }  

	public static void main(String[] args) {
		Q000_Algorithm_Greedy t = new Q000_Algorithm_Greedy();
		int[] w = { 77,22,29,50,99 };
		int[] v = { 92,22,87,46,90 };
		t.greedy(w, v, 100);
	}
}
