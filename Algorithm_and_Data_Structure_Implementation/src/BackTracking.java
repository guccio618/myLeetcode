import java.util.LinkedList;


public class BackTracking {
	private int num_recursive;      // 皇后的数目
	private int sum_recursive;	    // 解的数目
	private int[] x_recursive;	    // x[i]用于表示在第i行，皇后所放的位置
	private int num;
	private int sum;
	private int[] x;
	private LinkedList<LinkedList<Integer>> result;
	
	public BackTracking(){
		num_recursive = 8;        
		sum_recursive = 0;
		x_recursive = new int[num_recursive+1];
		num = 8;
		sum = 0;
		x = new int[num+1];
		result = new LinkedList<LinkedList<Integer>>();
	}
	
	/***********************   递归   ***********************/
	public void backtrack_recursive(int row) {
		if(row <= num_recursive){        
			 for(int i = 1; i <= num_recursive; i++) {
				 x_recursive[row] = i;  
				 
		         if(valid_recursive(row)) {        // 判断是否当前列可以摆放皇后，如果成立，进入下一级递归	            	
		        	 backtrack_recursive(row+1);   // 计算第t+1行的摆放方法
		         }
		     }
		} else {  // 打印可行的解的构成， 若不想打印，可以直接设置: if(t > num) return;
	        sum_recursive++;      // 可行的解数目＋1
	        
	        for(int m = 1; m <= num_recursive; m++) {
	            System.out.print(x_recursive[m] + ", "); // 这一行用输出当递归到叶节点的时候，一个可行解
	        }
	        
	        System.out.println();
	    }	       
	}
	
	// 此函数用于判断当前列是否可以摆放皇后
	public boolean valid_recursive(int row) {
	    for(int j = 1; j < row; j++){
	    	// 当row和j行的皇后都摆在对角线上，或者都摆放在同一列上，返回false
	    	if(Math.abs(x_recursive[row] - x_recursive[j]) == Math.abs(row-j) || x_recursive[j] == x_recursive[row]){
	    		return false;    
		    }
		}
	    
	    return true;
	}
		
	public int getSum_recursive() {
		return sum_recursive;
	}
	
	/***************   非递归   ***************/
	public LinkedList<LinkedList<Integer>> backtrack(int n) {
        int j = 1, i = 1;
       
        while(i <= n) {
            while(j <= n) {
                if(valid(i, j)) {  
                	x[i] = j;       // 检查合格后才往x[i]里存，不同于递归法
                    j = 1;          // mark and try next j
                    break;
                } else {
                    j++;
                }
            }
            
            if(x[i] == 0) {    // 如果第i行没有找到可以放置皇后的位置
                if(i == 1) {     	   // 回溯到第一行，还是没找到可行的解，那就说明都遍历了
                    break;
                } else {             // 否则的话回溯,并把上一行的皇后清空，再往后移动一位
                    --i;       
                    j = x[i] + 1;  // j从上一行的皇后位置的后一位开始，因为之前的位置已经判断过不可以放置
                    x[i] = 0;      // 原来的皇后位置清零
                    continue;
                }
            }         
            
            if(i == n) {       // 这个时候已经找到了全部需要的皇后
            	sum++;
                pushIn(result, x, num); // 保存解的结果           
                j = x[i] + 1;           // 但是由于还没完全返回全部的组合，所以还要继续找
                x[i] = 0;
            } else{
            	i++;
            }
        }
        return result;
    }
	
	public boolean valid(int row, int col) {
        for(int i = 1; i < row; i++) {      //  x中之前的行
            if(x[i] == col || Math.abs(row - i) == Math.abs(col - x[i])) {
                return false;
            }
        }
        return true;
    }
	
	public int getSum() {
		return sum;
	}
	
	
	public void pushIn(LinkedList<LinkedList<Integer>> result, int[] x,int num) {
		LinkedList<Integer> temp = new LinkedList<Integer>();
		
        for(int i = 1; i <= num; ++i) {
            temp.add(x[i]);
        }
        
        result.add(temp);
    }
	
	public void printResult(){
		for(int i = 0; i < result.size(); ++i){
			for(int j = 0; j < result.get(i).size(); ++j){
				System.out.print(result.get(i).get(j) + ", ");
			}
			System.out.println();
		}
	}

	
	public static void main(String[] args){
		BackTracking test = new BackTracking();
	    test.backtrack_recursive(1);   // 计算第1行的摆放
	    System.out.println("recursive result is " + test.getSum_recursive());
	    
	    test.backtrack(8);
//	    test.printResult();
	    System.out.println("non_recursive result is " + test.getSum());
	}
	
}
