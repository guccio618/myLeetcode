
public class Q307_Range_Sum_Query_Mutable {
	/**
     * Binary Indexed Trees (BIT or Fenwick tree):
     * https://www.topcoder.com/community/data-science/data-science-
     * tutorials/binary-indexed-trees/
     * 
     * Example: given an array a[0]...a[7], we use a array BIT[9] to
     * represent a tree, where index [2] is the parent of [1] and [3], [6]
     * is the parent of [5] and [7], [4] is the parent of [2] and [6], and
     * [8] is the parent of [4]. I.e.,
     * 
     * BIT[] as a binary tree:
     *            ______________*
     *            ______*
     *            __*     __*
     *            *   *   *   *
     * indices: 0 1 2 3 4 5 6 7 8
     * 
     * BIT[i] = ([i] is a left child) ? the partial sum from its left most
     * descendant to itself : the partial sum from its parent (exclusive) to
     * itself. (check the range of "__").
     * 
     * Eg. BIT[1]=a[0], BIT[2]=a[1]+BIT[1]=a[1]+a[0], BIT[3]=a[2],
     * BIT[4]=a[3]+BIT[3]+BIT[2]=a[3]+a[2]+a[1]+a[0],
     * BIT[6]=a[5]+BIT[5]=a[5]+a[4],
     * BIT[8]=a[7]+BIT[7]+BIT[6]+BIT[4]=a[7]+a[6]+...+a[0], ...
     * 
     * Thus, to update a[1]=BIT[2], we shall update BIT[2], BIT[4], BIT[8],
     * i.e., for current [i], the next update [j] is j=i+(i&-i) //double the
     * last 1-bit from [i].
     * 
     * Similarly, to get the partial sum up to a[6]=BIT[7], we shall get the
     * sum of BIT[7], BIT[6], BIT[4], i.e., for current [i], the next
     * summand [j] is j=i-(i&-i) // delete the last 1-bit from [i].
     * 
     * To obtain the original value of a[7] (corresponding to index [8] of
     * BIT), we have to subtract BIT[7], BIT[6], BIT[4] from BIT[8], i.e.,
     * starting from [idx-1], for current [i], the next subtrahend [j] is
     * j=i-(i&-i), up to j==idx-(idx&-idx) exclusive. (However, a quicker
     * way but using extra space is to store the original array.)
     */
	private SegmentTreeNode root;

    public Q307_Range_Sum_Query_Mutable(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }

    void update(int i, int val) {
        SegmentTreeNode node = root;
        modify(node, i, val);
    }

    public int sumRange(int i, int j) {
        SegmentTreeNode node = root;     // 注意这里用一个临时变量 node 来作为参数 ！！！
        return query(node, i, j);
    }
    
    public SegmentTreeNode buildTree(int[] nums, int start, int end){
        if(start > end){
            return null;   
        } else if(start == end){
            return new SegmentTreeNode(start, end, nums[start]);
        } else {
            SegmentTreeNode root = new SegmentTreeNode(start, end, nums[start]);
            int mid = (start + end) / 2;
            root.left = buildTree(nums, start, mid);
            root.right = buildTree(nums, mid + 1, end);
            root.sum = root.left.sum + root.right.sum;
            return root;
        }
    }
    
    public int query(SegmentTreeNode node, int start, int end){
        if(start > end){
            return -1;
        }
        if(node.start == start && node.end == end){
            return node.sum;
        }
        
        int mid = (node.start + node.end) / 2;
        int leftSum = 0;
        int rightSum = 0;
        
        if(start <= mid){
            if(end > mid){
                leftSum = query(node.left, start, mid);
            } else {
                leftSum = query(node.left, start, end);
            }
        }
        if(end > mid){
            if(start <= mid){
                rightSum = query(node.right, mid + 1, end);
            } else {
                rightSum = query(node.right, start, end);
            }
        }
        
        return leftSum + rightSum;
    }
    
    public void modify(SegmentTreeNode node, int index, int value){
        if(node.start == index && node.end == index){
            node.sum = value;
            return;
        }
        
        int mid = (node.start + node.end) / 2;
        if(node.start <= index && index <= mid){
            modify(node.left, index, value);
        }
        if(mid < index && index <= node.end) {
            modify(node.right, index, value);
        }
        
        node.sum = node.left.sum + node.right.sum;
    }
    
    public class SegmentTreeNode {
		public int start, end;
		public int sum;
		public SegmentTreeNode left, right;
		
		public SegmentTreeNode(int start, int end, int sum) {
			this.start = start;
			this.end = end;
			this.sum = sum;
			this.left = this.right = null;
		}
	}
	
	
    
    public static void main(String[] args){
    	int[] nums = {1,3,5};
    	Q307_Range_Sum_Query_Mutable t = new Q307_Range_Sum_Query_Mutable(nums);
    	System.out.println(t.sumRange(0, 2));
    	t.update(1, 2);
    	System.out.println(t.sumRange(0, 2));
    	
    }
	
	
	// by other
	
//	private int[] nums;
//    private int[] BIT;
//    private int n;
//
//    public Q307_Range_Sum_Query_Mutable(int[] nums) {
//        this.nums = nums;
//        n = nums.length;
//        BIT = new int[n + 1];
//        for (int i = 0; i < n; i++)
//            init(i, nums[i]);
//    }
//
//    public void init(int i, int val) {
//        i++;
//        while (i <= n) {
//            BIT[i] += val;
//            i += (i & -i);
//        }
//    }
//
//    void update(int i, int val) {
//        int diff = val - nums[i];
//        nums[i] = val;
//        init(i, diff);
//    }
//
//    public int getSum(int i) {
//        int sum = 0;
//        i++;
//        while (i > 0) {
//            sum += BIT[i];
//            i -= (i & -i);
//        }
//        return sum;
//    }
//
//    public int sumRange(int i, int j) {
//        return getSum(j) - getSum(i - 1);
//    }
}

// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
