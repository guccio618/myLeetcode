import java.util.ArrayList;


public class Lecture9_Graph_Search_05_N_Queens {
	private int nums_1 = 0;
	private int nums_2 = 0;
	
	/****************************** non-recursion *******************************/
	public ArrayList<ArrayList<String>> solveNQueens(int n) {
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		if(n <= 0){
			return res;
		}
		int[] pos = new int[n + 1];
		int row = 1, col = 1;
		
		while(row <= n){
			while(col <= n){
				if(valid(pos, row, col) == true){
					pos[row] = col;
					col = 1;
					break;
				} else{
					col++;
				}
			}
			
			if(pos[row] == 0){
				if(row == 1){
					break;
				} else{
					row--;
					col = pos[row] + 1;
					pos[row] = 0;
					continue;
				}
			}
			
			if(row == n){
				nums_1++;
				res.add(getResString(pos));
				col = pos[row] + 1;
				pos[row] = 0;
			} else{
				row++;
			}
		}
		return res;
	}
	
	
	
	/****************************** recursion *******************************/
	public ArrayList<ArrayList<String>> solveNQueens2(int n) {
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		if(n <= 0){
			return res;
		}
		int[] pos = new int[n + 1];
		helper(pos, res, 1, n);
		return res;
	}
	
	public void helper(int[] pos, ArrayList<ArrayList<String>> res, int row, int n){
		if(row <= n){
			for(int i = 1; i <= n; ++i){	
				if(valid(pos, row, i) == true){
					pos[row] = i;	
					helper(pos, res, row + 1, n);
				}
			}
		} else{
			nums_2++;
			res.add(getResString(pos));
		}
	}

	

	/****************************** functions *******************************/	
	public boolean valid(int[] pos, int row, int col){
		for(int i = 1; i < row; ++i){
			if(pos[i] == col || Math.abs(row - i) == Math.abs(col - pos[i])){
				return false;
			}
		}
		return true;
	}
		
	public ArrayList<String> getResString(int[] pos){
		int len = pos.length;
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 1; i < len; ++i){
			StringBuffer sb = new StringBuffer();
			int queenPos = pos[i];
			for(int j = 1; j < len; ++j){
				if(j == queenPos){
					sb.append("Q");
				} else{
					sb.append(".");
				}
			}
			list.add(sb.toString());
		}
		return list;
	}
	
	
	
	/****************************** main function *******************************/	
	public static void main(String[] args){
		Lecture9_Graph_Search_05_N_Queens t = new Lecture9_Graph_Search_05_N_Queens();
		int n = 8;
		
		ArrayList<ArrayList<String>> res_1 = t.solveNQueens(n);
		System.out.println("nums_1 = " + t.nums_1);
		for(int i = 0; i < res_1.size(); ++i){
			System.out.println(res_1.get(i) + ", ");
		}
		System.out.println();
		
		ArrayList<ArrayList<String>> res_2 = t.solveNQueens2(n);
		System.out.println("nums_2 = " + t.nums_2);
		for(int i = 0; i < res_2.size(); ++i){
			System.out.println(res_2.get(i));
		}
		System.out.println();
	}
}
