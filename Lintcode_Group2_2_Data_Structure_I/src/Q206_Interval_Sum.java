import java.util.ArrayList;


public class Q206_Interval_Sum {
	// by Jackie using Segment tree
	public ArrayList<Long> intervalSum(int[] nums, ArrayList<Interval> queries) {
        ArrayList<Long> res = new ArrayList<Long>();
        if(nums == null || nums.length == 0 || queries.size() == 0){
            return res;
        }
        sNode root = builder(nums, 0, nums.length - 1);
        int len = queries.size();
        for(Interval n : queries){
            res.add(query(root, n.start, n.end));
        }
        return res;
    }
    
    public sNode builder(int[] nums, int start, int end){
        if(start == end){
            return new sNode(start, end, nums[start]);
        }
        sNode node = new sNode(start, end, 0);
        int mid = (node.start + node.end) / 2;     // 注意必须要用root.start和root.end
        node.left = builder(nums, start, mid);
        node.right = builder(nums, mid + 1, end);
        node.sum = node.left.sum + node.right.sum;
        return node;
    }
    
    public long query(sNode node, int start, int end){
        if(start <= node.start && end >= node.end){
            return node.sum;
        }
        int mid = (start + end) / 2;
        long leftSum = 0, rightSum = 0;
        if(start <= mid){
            if(end > mid){
                leftSum = query(node.left, start, mid);
            } else {
                leftSum = query(node.left, start, end);
            }
        }
        if(end > mid){
            if(start <= mid){
                rightSum = query(node.left, mid + 1, end);
            } else {
                rightSum = query(node.left, start, end);
            }
        }
        return leftSum + rightSum;
    }
    
    class sNode{
        int start;
        int end;
        long sum;
        sNode left;
        sNode right;
        public sNode(int s, int e, long sum){
            start = s;
            end = e;
            this.sum = sum;
            left = right = null;
        }
    }
}
