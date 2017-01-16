/**************************************************
 * (1). 二分法， 求出mid = left + (right - left) / 2， 
 * 		判断mid所处的位置，从而决定向哪边移动
 * 重点题型： Le_4*，**29, *33, *50, 69, 154, **162, Le_215*, 222, **274, 275, *302，*392, Le_475, Li_5
 * 
 * 	(1). search: *33, 154, *162 
 * 	(2). 数的运算操作: **29, *50, 69   
 * 	(3). H-index: *274(桶排序), 275
 * 
 **************************************************/


public class Datastructure_Definition {

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}