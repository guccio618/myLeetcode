
public class Q473_Add_and_Search_Word {
	// by Jackie
	private TreeNode root;
    private class TreeNode{
        TreeNode[] children;
        boolean isEnd;
        char val;
        
        public TreeNode(){
            children = new TreeNode[26];
            isEnd = false;
        }
    }
    
    public Q473_Add_and_Search_Word(){
        root = new TreeNode();
    }
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        TreeNode node = root;
        char[] letters = word.toCharArray();
        
        for(int i = 0; i < letters.length; ++i){
            int pos = letters[i] - 'a';
            if(node.children[pos] == null){
                node.children[pos] = new TreeNode();
                node.children[pos].val = letters[i];
            }
            node = node.children[pos];
        }
        node.isEnd = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if(word == null || word.length() == 0){
            return false;
        }
        char[] letters = word.toCharArray();
        return helper(root, letters, 0);
    }
    
    public boolean helper(TreeNode n, char[] letters, int pos){
    	if(pos == letters.length){
    		return n.isEnd;
    	}
		
		if(letters[pos] != '.'){
			int nextPos = letters[pos] - 'a';
			if(n.children[nextPos] != null){
				return helper(n.children[nextPos], letters, pos+1);
			}
			else {
				return false;
			}
		} else {
			boolean flag = false;
			for(int i = 0; i < 26; ++i){
				if(n.children[i] != null){
					flag = helper(n.children[i], letters, pos+1);
					if(flag == true){
						return true;
					}
				}
			}
			return flag;
		}
    }
    
    
    public static void main(String[] args){
    	Q473_Add_and_Search_Word t = new Q473_Add_and_Search_Word();
    	t.addWord("bad");
    	t.addWord("dad");
    	t.addWord("mad");
//    	t.search("pad");
//    	System.out.println("1");
//    	t.search("bad");
//    	System.out.println("2");
    	System.out.println(t.search(".ad"));
//    	System.out.println("3");
    	System.out.println(t.search("b.."));
    }
}
