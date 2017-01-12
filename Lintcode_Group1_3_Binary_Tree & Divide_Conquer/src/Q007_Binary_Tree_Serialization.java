import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Q007_Binary_Tree_Serialization {
	// this part by Jackie, next part by ninechapter
	public String serialize(TreeNode root) {		
        if(root == null){
            return "{}";
        }
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node != null){
                sb.append(node.val).append(",");
                q.add(node.left);
                q.add(node.right);
            }
            else{
                sb.append("#").append(",");
            }
        }

        int lastPos = sb.length()-1;
        while(lastPos >= 0){
        	if(sb.charAt(lastPos) != '#' && sb.charAt(lastPos) != ','){
        		break;
        	}
        	lastPos--;
        }      
        return sb.toString().substring(0, lastPos+1) + "}";
    }
	
	
    /******************************************************************
     *  by ninechapte, 借助ArrayList来记录每一个node,以便进行构建树操作 nice! 
     ******************************************************************/
	public TreeNode deserialize(String data) {		
		if (data.equals("{}")) {
            return null;
        }
			
        String[] vals = data.substring(1, data.length() - 1).split(",");
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        queue.add(root);
        int index = 0;                // index：parent的下标
        boolean isLeftChild = true;   // 开关变量； vals[]里相邻的为left和right
        for (int i = 1; i < vals.length; i++) {
            if (!vals[i].equals("#")) {
                TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
                if (isLeftChild) {
                    queue.get(index).left = node;
                } else {
                    queue.get(index).right = node;
                }
                queue.add(node);
            }                    // 注意一下if的顺序，无论此时是否为"#"，均表示构建当前子树完成！！！
            if (!isLeftChild) {  // 构建完右子树后，parent向后移动一位
                index++;
            }
            isLeftChild = !isLeftChild;
        }
        return root;
    }
    
	
	public String serialize2(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		
		while(!s.isEmpty() || root != null){
			while(root != null){
				s.push(root);
				sb.append(root.val).append(",");
				root = root.left;
			}
			sb.append("#").append(",");
			root = s.pop();
			root = root.right;
		}
		
		int pos = sb.length() - 1;
		while(pos >= 0){
			char c = sb.charAt(pos);
			if(c != '#' && c != ','){
				break;
			}
			pos--;
		}
		
		return sb.substring(0, pos + 1) + "}";
	}
	
    
    public static void main(String[] args){
    	Q007_Binary_Tree_Serialization t = new Q007_Binary_Tree_Serialization();
    	String data = "{3,9,20,#,#,15,7}";
    	System.out.println("source: " + data);
    	TreeNode root = t.deserialize(data);
    	System.out.println(t.serialize(root));
    	System.out.println(t.serialize2(root));
    	
    	
//    	TreeNode root = new TreeNode(1);
//    	root.left = new TreeNode(2);
//    	root.left.left = new TreeNode(3);
//    	root.left.left.left = new TreeNode(4);
//    	System.out.println(t.serialize(root));
    }
}
