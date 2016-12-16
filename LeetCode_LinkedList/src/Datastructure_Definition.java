/****************************************************************************************
 * 解题思路：
 * 		(1). dummy的使用
 * 		(2). 重点题型：**25, 109, **138, *141, 142, *143, *147, *148, 234的revertList实现,
 * 			         **287
 * 
 * 题型归纳：
 * 	1. 链表排序： *147, *148, 86 
 * 	2. 链表判断是否有环： 141, 142, **287
 *   
 ****************************************************************************************/

public class Datastructure_Definition {
	
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

class RandomListNode {
	int label;
	RandomListNode next, random;
	RandomListNode(int x) { this.label = x; }
};

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int v){
		val = v;
	}
}
