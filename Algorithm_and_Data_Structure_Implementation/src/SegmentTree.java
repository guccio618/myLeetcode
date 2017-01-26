public class SegmentTree {
	private int bound = 0;
	
	private class SegmentTreeNode {
		private int start, end;
		private int max;
		private SegmentTreeNode left, right;
		
		private SegmentTreeNode(int start, int end, int max) {
			this.start = start;
			this.end = end;
			this.max = max;
			this.left = this.right = null;
		}
	}
	
	public SegmentTreeNode build(int[] nums) {
		bound = nums.length - 1;
        return buildTree(0, nums.length - 1, nums);
    }
	
	public SegmentTreeNode buildTree(int start, int end, int[] nums) {
        if (start > end){
            return null;
        } else if (start == end) {
            return new SegmentTreeNode(start, end, nums[start]);
        }
        
        SegmentTreeNode node = new SegmentTreeNode(start, end, nums[start]);  // 先随便给一个max值
        int mid = start + (end - start) / 2;
        node.left = this.buildTree(start, mid, nums);
        node.right = this.buildTree(mid + 1, end, nums);
        node.max = Math.max(node.left.max, node.right.max);     // 从左右子树中寻找最大的max，作为当前max的值
   
        return node;
    }
	
	public int query(SegmentTreeNode root, int start, int end) {
		end = Math.min(end, bound);              // 防止query时候end越界
		
        if(start == root.start && root.end == end) {           // 相等 
            return root.max;
        }
              
        int mid = root.start + (root.end - root.start)/2;
        int leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE;
        
        // 左子树
        if(start <= mid) {
            if(mid < end) {     // 存在右子树 
                leftMax = query(root.left, start, mid);
            } else {            // 不存在右子树 
                leftMax = query(root.left, start, end);
            }
        }
        
        // 右子树
        if(mid < end) {          // 存在右子树
            if(start <= mid) {
                rightMax = query(root.right, mid+1, end);
            } else {             // 不存在右子树
                rightMax = query(root.right, start, end);
            }
        } 
        
        // else 就是不相交
        
        return Math.max(leftMax, rightMax);
    }
	
	public void modify(SegmentTreeNode root, int index, int value) {
		if(index > bound) {
			return ;
		}
		
        if(root.start == index && root.end == index) {    // find the index
            root.max = value;
            return;
        }
        
        // get the mid
        int mid = root.start + (root.end - root.start)/2;
        
        // index is in left subtree
        if(root.start <= index && index <= mid) {
            modify(root.left, index, value);
        }
        
        // index is in right subtree
        if(mid < index && index <= root.end) {
        	modify(root.right, index, value);
        }
               
        // update value
        root.max = Math.max(root.left.max, root.right.max);
    }
	
	
	
	
	public static void main(String[] args) {
		SegmentTree t = new SegmentTree();
		int[] nums = {0,1,2,3,4,5,6,7,8,9,10,11};
		SegmentTreeNode root = t.build(nums);
		
		System.out.println(t.query(root, 0, 19));
		t.modify(root, 19, 12);
		System.out.println(t.query(root, 0, 19));		
	}
}
