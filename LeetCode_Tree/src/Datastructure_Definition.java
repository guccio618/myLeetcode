import java.util.*;

/***********************************************************************************
 * 解题思路：
 * 		(1). BFS, DFS, 递归和非递归
 * 		(2). BST: 通常可以用中序递归的方法，加上全局变量，具体例题见(98)，(99); BST通常要
 * 			 设置最大最小值范围， 如98, 333
 * 		(3). Tree中表示叶子结点的方法：node.left == null && node.right == null
 * 		(4). 涉及树和其子树关系的，通常用递归方法
 * 		(5). 改变树遍历的顺序，可以考虑用stack或者queue, 例如题(114)
 * 		(6). 树的序列化和非序列化，引入ArrayList, 参见题(297)
 * 		(7). BST的插入，删除操作
 * 		(8). 二叉树通常可以考虑用二分法，且完全二叉树的树高为其左子树的树高
 * 		(9). 重点题型：95, **96, *98(两种方法)，*99，113，116, *117(两种方法，含层序遍历)，124, 
 * 					**156, **173, *222, 230, 236, 250, **255(两种方法), **272(两种方法), 
 * 					*297, 314, **331, **333, *337，**li_87
 * 		
 * 			与动归结合: 95, 96
 * 			BST插入，删除: li_87
 * 		(10). 剪枝法：Le_310*, Le_366
 * 
 * 重点题目型: Le_95, Le_96, Le_099, Le_105, Le_106*, Le_114*, Le_257*(iterator 方法), Le_261*, 
 * 			 Le_310*, Le_437*
 *   
 ************************************************************************************/

public class Datastructure_Definition {
	
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

class TreeLinkNode {
	int val;
    TreeLinkNode left;
    TreeLinkNode right;
    TreeLinkNode next;
    
    public TreeLinkNode(int val) {
    	this.val = val;
    	next = left = right = null;  	
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}