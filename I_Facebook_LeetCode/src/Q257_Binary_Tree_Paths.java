import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*********
 * 
 Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]

 * 
 * */

public class Q257_Binary_Tree_Paths {
	// solution 1: using recursion
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<String>();
        
        if(root == null){
            return ans;
        }
        
        DFS(ans, root, "");
        return ans;
    }
    
    public void DFS(List<String> ans, TreeNode node, String solution){
        if(node == null){
            return ;
        } 
        
        if(solution.length() == 0){
            solution = Integer.toString(node.val);
        } else {
            solution = solution + "->" + Integer.toString(node.val);
        }
        
        if(node.left == null && node.right == null){
            ans.add(solution);
        } else {
            DFS(ans, node.left, solution);   
            DFS(ans, node.right, solution); 
        }
    }
	
    
    
    
  
	// solution 2: using Iterator
	public List<String> binaryTreePaths2(TreeNode root) {
        List<String> ans = new ArrayList<String>();
        
        if(root == null){
            return ans;
        }
        
        Queue<List<TreeNode>> queue = new LinkedList<>();
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        queue.offer(list);
        
        while(!queue.isEmpty()){
            List<TreeNode> currentList = queue.poll();
            TreeNode node = currentList.get(currentList.size() - 1);
            
            if(node.left != null){
                List<TreeNode> leftList = new ArrayList<>(currentList);
                leftList.add(node.left);
                queue.offer(leftList);
            }
            
            if(node.right != null){
                List<TreeNode> rightList = new ArrayList<>(currentList);
                rightList.add(node.right);
                queue.offer(rightList);
            } 
            
            if(node.left == null && node.right == null){
                ans.add(getStr(currentList));
            }
        }
        
        return ans;
    }
    
    public String getStr(List<TreeNode> list){
        StringBuilder builder = new StringBuilder();
        
        for(TreeNode node : list){
            if(builder.length() == 0){
                builder.append(node.val);
            } else {
                builder.append("->").append(node.val);
            }
        }
        
        return builder.toString();
    }
	
	
	
    
    
    
    
    
    
//	public ArrayList<String> binaryTreePaths3(TreeNode root) {
//		ArrayList<String> res = new ArrayList<String>();
//        if(root == null) return res;
//        preOrder(root, res, "");
//        return res;
//    }
//	
//    // 前序遍历，直至所有的子树均为null，此时即得到一条路径
//    public void preOrder(TreeNode node, ArrayList<String> res, String str){
//        if(node == null) {
//        	return;
//        }
//        
//        if(str.equals(""))
//        	str +=  node.val;
//        else
//        	str = str + "->" + node.val;
//        String tempStr = str;          // tempStr用于记录访问到当前node时的路径
//
//        if(node.left == null && node.right == null)
//            res.add(str);        
//        if(node.left != null)
//        	preOrder(node.left, res, tempStr);
//        if(node.right != null)     	
//        	preOrder(node.right, res, str);
//    }
    
    /*********************** main function ***************************/
    
    public static void main(String[] args){
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(3);
    	root.left.left = new TreeNode(4);
    	root.left.right = new TreeNode(5);
    	Q257_Binary_Tree_Paths t = new Q257_Binary_Tree_Paths();
    	List<String> res = t.binaryTreePaths(root);
    	
    	for(int i = 0; i < res.size(); ++i)
    		System.out.println(res.get(i));
    }   
}
