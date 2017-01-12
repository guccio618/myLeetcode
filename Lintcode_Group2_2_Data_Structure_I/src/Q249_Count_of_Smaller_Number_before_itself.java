import java.util.ArrayList;


public class Q249_Count_of_Smaller_Number_before_itself {
	// by ninechapter using segment tree
	public ArrayList<Integer> countOfSmallerNumberII(int[] nums) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0){
            return res;
        }
        
        sNode root = builder(0, 10000);
        for(int i = 0; i < nums.length; ++i){
            int count = 0;
            if(nums[i] > 0){
                count = query(root, 0, nums[i] - 1);
            }
            res.add(count);
            modify(root, nums[i], 1);
        }
        return res;
    }
    
    public void modify(sNode node, int index, int value){
        if(node.start == index && node.end == index){
            node.count += value;
            return;
        }
        int mid = (node.start + node.end) / 2;
        if(node.start <= index && index <= mid){
            modify(node.left, index, value);
        } 
        if(index > mid && (index <= node.end)) {
            modify(node.right, index, value);
        }
        node.count = node.left.count + node.right.count;
    }
    
    public int query(sNode node, int start, int end){
        if(node == null || start > end){
            return 0;
        }
        if(start <= node.start && end >= node.end){
            return node.count;
        }
        int mid = (node.start + node.end) / 2;
        int leftCount = 0, rightCount = 0;
        if(start <= mid){
            if(mid < end){
                leftCount = query(node.left, start, mid);
            } else {
                leftCount = query(node.left, start, end);
            }
        }
        if(end > mid){
            if(start <= mid){
                rightCount = query(node.right, mid + 1, end);
            } else {
                rightCount = query(node.right, start, end);
            }
        }
        return leftCount + rightCount;
    }
    
    public sNode builder(int start, int end){
        if(start == end){
            return new sNode(start, end); 
        }
        
        sNode node = new sNode(start, end);
        node.left = builder(start, (start + end) / 2);
        node.right = builder((start + end) / 2 + 1, end);
        return node;
    }
    
    class sNode{
        int start;
        int end;
        int count;
        sNode left;
        sNode right;
        public sNode(int s, int e){
            start = s;
            end = e;
            count = 0;
            left = right = null;
        }
    }
    
    
    
    /*************************** main function *********************************/
    
    public static void main(String[] args){
    	Q249_Count_of_Smaller_Number_before_itself t = new Q249_Count_of_Smaller_Number_before_itself();
    	int[] nums = {1,2,7,8,5,6,7};
    	ArrayList<Integer> res = t.countOfSmallerNumberII(nums);
    	for(int i = 0; i < res.size(); ++i){
    		System.out.print(res.get(i) + ", ");
    	}
    }
}
