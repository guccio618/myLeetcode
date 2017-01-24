class TrieNode {
	// by Jackie
    // Initialize your data structure here.
    public TrieNode[] children;
    public boolean isWord;
    
    public TrieNode() {
        children = new TrieNode[26];
        isWord = false;
    }
}

public class Q208_Implement_Trie_Prefix_Tree {
    private TrieNode root;

    public Q208_Implement_Trie_Prefix_Tree() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if(word.length() == 0) return;
        char[] letters = word.toCharArray();
        int pos = 0;
        TrieNode temp = root;

        for(int i = 0, len = letters.length; i < len; ++i){
            pos = letters[i] - 'a';
            if(temp.children[pos] == null){
                temp.children[pos] = new TrieNode();
            }
            temp = temp.children[pos];
        }
        temp.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if(word.length() == 0) return false;
        char[] letters = word.toCharArray();
        int pos = 0;
        TrieNode temp = root;
        
        for(int i = 0, len = letters.length; i < len; ++i){
            pos = letters[i] - 'a';
            if(temp.children[pos] == null)
                return false;
            else
                temp = temp.children[pos];
        }
        return temp.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if(prefix.length() == 0) return false;
        char[] letters = prefix.toCharArray();
        int pos = 0;
        TrieNode temp = root;
        
         for(int i = 0, len = letters.length; i < len; ++i){
             pos = letters[i] - 'a';
            if(temp.children[pos] == null)
                return false;
            else
                temp = temp.children[pos];
         }
         return true;
    }
}

