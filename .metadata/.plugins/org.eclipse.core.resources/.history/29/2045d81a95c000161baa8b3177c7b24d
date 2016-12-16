import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Le_297_Serialize_and_Deserialize_Binary_Tree {
	/********************************************************************
	 * serialize:   运用层序遍历进行纪录； 并同时纪录lastPos, 纪录最后一个有效字符。
	 * deserialize： 运用ArrayList, 按顺序纪录每个结点；index纪录访问到的root结点
	 * 				 的id。
	 *      
	 ********************************************************************/
	
	public String serialize(TreeNode root) {
        if(root == null){
            return new String();
        }
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        StringBuffer builder = new StringBuffer();
        int lastPos = 0;
        
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node != null){
                builder.append(node.val).append(",");
                q.offer(node.left);
                q.offer(node.right);
                lastPos = builder.length() - 2;  // node.val所在的字符位置, 只记录有效的字符位置，null时不记录
            } else {
                builder.append("#,");
            }
        }
        
        return builder.substring(0, lastPos + 1);
    }
    
    
	public TreeNode deserialize(String data) {
        if(data == null || data.equals("")){
            return null;
        }
        
        String[] array = data.split(",");
        int n = array.length;
        if(array[0].equals("#")){   // 此处需要做非空判断
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(array[0]));
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        int index = 0;
        
        for(int i = 1; i < n; ++i){
            if(!array[i].equals("#")){
                TreeNode node = new TreeNode(Integer.parseInt(array[i]));
                if(i % 2 == 1){                            // i为单数时，存放的为左子树位置,      注意这里用的是i而不是index !!!
                    list.get(index).left = node;
                } else{                                    // i为复数时，存放的为右子树位置
                    list.get(index).right = node;
                }
                list.add(node);                            // !!!别忘记将新的node加入到list里
            }
            
            if(i % 2 == 0){                                // 无论当前字符是否为null，index++正常进行，因此不能置于 if(!array[i].equals("#")) 里
                index++;
            }
        }
        
        return root;
    }
}
