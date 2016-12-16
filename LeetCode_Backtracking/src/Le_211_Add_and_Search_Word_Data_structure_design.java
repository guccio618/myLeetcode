
public class Le_211_Add_and_Search_Word_Data_structure_design {
	class TrieNode{
        char val;
        TrieNode[] children;
        boolean isWord;
        
        public TrieNode(char v){
            val = v;
            children = new TrieNode[26];
            isWord = false;
        }
    }
    
    private TrieNode root = new TrieNode('s');
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node = root;
        char[] letters = word.toCharArray();
        
        for(int i = 0; i < letters.length; i++){
            int pos = (int) (letters[i] - 'a');
            if(node.children[pos] == null){
                node.children[pos] = new TrieNode(letters[i]);
            }
            node = node.children[pos];
        }
        
        node.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        TrieNode node = root;
        char[] letters = word.toCharArray();
        
        return searchHelper(node, letters, 0);
    }
    
    public boolean searchHelper(TrieNode node, char[] letters, int pos) {
        if(pos == letters.length){
            return node.isWord;
        }
        
        if(letters[pos] != '.'){
            int index = (int) (letters[pos] - 'a');
            if(node.children[index] == null){  
                return false;
            } else {
                return searchHelper(node.children[index], letters, pos + 1);
            }
        } else {
            boolean flag = false;
            for(int i = 0; i < 26; i++) {
                if(node.children[i] != null){     // 注意必需做判断是否为空
                    flag |= searchHelper(node.children[i], letters, pos + 1);
                    if(flag == true){
                        return true;
                    }
                }
            }
            return flag;
        }
    }
}
