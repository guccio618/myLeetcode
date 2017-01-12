public class Q125_Backpack_II {
	/*************************************************************
	 * state: f[i][j]表示前i个物品装到体积为j的背包里，可以装的最大价值
	 * funciton: f[i][j] = f[i-1][j], 第i个item[i]不往里装时
	 * 			 f[i][j] = f[i-1][j - itemsize[i]], 第i个item[i]往里装时
	 * initial: f[0][0] = true
	 * answer:  f[size][capacity]
	 *************************************************************/
	// by other using DP
	public int backPackII(int capacity, int[] size, int[] value) {
		int[][] res = new int[size.length + 1][capacity + 1];
		res[0][0] = 0;
		for (int i = 1; i <= size.length; i++) {
			for (int j = 0; j <= capacity; j++) {
				if (j - size[i - 1] < 0)
					res[i][j] = res[i - 1][j];
				if (j - size[i - 1] >= 0) {
					res[i][j] = Math.max(res[i-1][j], res[i-1][j-size[i-1]] + value[i-1]);
				}
			}
		}
		return res[size.length][capacity];
	}
}
