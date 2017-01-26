/********
 * 
Design a data structure that supports the following two operations:
	void addWord(word)
	bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

For example:
	addWord("bad")
	addWord("dad")
	addWord("mad")
	search("pad") -> false
	search("bad") -> true
	search(".ad") -> true
	search("b..") -> true
	
Note:
	You may assume that all words are consist of lowercase letters a-z.
	
 * 
 * */

public class Le_211_Add_and_Search_Word_Data_structure_design {
	private Trie root = new Trie();
    
    public void addWord(String word) {
        Trie node = root;
        char[] letters = word.toCharArray();
        
        for(int i = 0; i < letters.length; i++){
            int pos = letters[i] - 'a';
            
            if(node.child[pos] == null){
                node.child[pos] = new Trie();
                node.child[pos].value = letters[i];
            }
            
            node = node.child[pos];
        }
        
        node.isWord = true;
    }
 
    
    public boolean search(String word) {
        return searchHelper(root, word, 0);
    }
    
    public boolean searchHelper(Trie node, String word, int start){
        if(start == word.length()){
            return node.isWord;
        }
        
        char c = word.charAt(start);
        
        if(c != '.'){
            int pos = c - 'a';
            
            if(node.child[pos] == null){
                return false;
            } else {
                return searchHelper(node.child[pos], word, start + 1);
            }
        } else {
            for(int i = 0; i < 26; i++){
                if(node.child[i] != null && searchHelper(node.child[i], word, start + 1) == true){
                    return true;
                }
            }
            
            return false;
        }
    }
}

class Trie {
    char value; 
    Trie[] child;
    boolean isWord;
    
    public Trie(){
        value = ' ';
        child = new Trie[26];
        isWord = false;
    }
}
