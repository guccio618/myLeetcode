
/*******************************************************************
 *  它有三个基本性质:                                                  *
 *  	(1) 根节点不包含字符;                                          *
 *		(2) 除根节点外每一个节点都只包含一个字符;                          *
 *		(3) 从根节点到某一节点，路径上经过的字符连接起来，为该节点对应的字符串，  *
 *			每个节点的所有子节点包含的字符都不相同。                        *
 *                                                                 *
 *******************************************************************/  

public class Trie {
	private final int SIZE = 26;
	private TrieNode root;       // 字典树的根

	Trie() { // 初始化字典树
		root = new TrieNode();
	}
	
	/***********   字典树节点   ************/
	private class TrieNode {       
		private int wordCount;           // 有多少单词通过这个节点,即节点字符出现的次数
		private TrieNode[] children;    // 所有的儿子节点
		private boolean isWord;     // 是不是最后一个节点
		private char val;          // 节点存放的值

		TrieNode() {
			wordCount = 1;
			children = new TrieNode[SIZE];
			isWord = false;
		}
	}

	/***********   字典树应用   ************/
	// 在字典树中插入一个单词
	public void insert(String str) {   
		if (str == null || str.length() == 0) {
			return;
		}
		
		TrieNode node = root;
		char[] letters = str.toCharArray();
		
		for (int i = 0, len = str.length(); i < len; i++) {
			int pos = letters[i] - 'a';
			
			if (node.children[pos] == null) {
				node.children[pos] = new TrieNode();
				node.children[pos].val = letters[i];
			} else {
				node.children[pos].wordCount++;
			}
			
			node = node.children[pos];
		}
		
		node.isWord = true;
	}
	
	// 计算单词前缀的数量
	public int countPrefix(String prefix) { 
		if (prefix == null || prefix.length() == 0) {
			return -1;
		}
		
		TrieNode node = root;
		char[] letters = prefix.toCharArray();
		
		for (int i = 0, len = prefix.length(); i < len; i++) {
			int pos = letters[i] - 'a';
			if (node.children[pos] == null) {
				return 0;
			} else {
				node = node.children[pos];
			}
		}
		
		return node.wordCount;
	}

	// 在字典树中查找一个完全匹配的单词.
	public boolean has(String str) {
		if (str == null || str.length() == 0) {
			return false;
		}
		
		TrieNode node = root;
		char[] letters = str.toCharArray();
		
		for (int i = 0, len = str.length(); i < len; i++) {
			int pos = letters[i] - 'a';
			
			if (node.children[pos] != null) {
				node = node.children[pos];
			} else {
				return false;
			}
		}
		
		return node.isWord;
	}
	
	// 匹配含“..”的 regular expression
	public boolean search(String word) {
        if(word.length() == 0){
        	return false;
        }
        
        char[] letters = word.toCharArray();
        TrieNode node = root;
        
        return bt(node, letters, 0);
    }
	
	public boolean bt(TrieNode node, char[] letters, int pos){
		if(pos == letters.length) {
			return node.isWord;
		}
		
		if(letters[pos] != '.'){
			int n = letters[pos] - 'a';
			
			if(node.children[n] != null) {
				return bt(node.children[n], letters, pos+1);
			} else {
				return false;
			}
		} else{			
			for(int i = 0; i < 26; ++i){
				if(node.children[i] != null){
					if(bt(node.children[i], letters, pos+1) == true) {
						return true;
					}
				}
			}
			
			return false;
		}
	}

	// 前序遍历字典树. 递归实现
	public void preTraverse(TrieNode node) {
		if (node != null) {
			System.out.print(node.val + "-");
			
			for (TrieNode child : node.children) {
				preTraverse(child);
			}
		}
	}

	public TrieNode getRoot() {
		return this.root;
	}

	public static void main(String[] args) {
		Trie tree = new Trie();
		String[] strs = { "banana", "band", "bee", "absolute", "acm", };
		String[] prefix = { "ba", "b", "band", "abc", };
		
		for (String str : strs) {
			tree.insert(str);
		}
		
		System.out.println("acm: " + tree.has("acm"));
		System.out.println("a.: " + tree.search("a."));
		System.out.println("a..: " + tree.search("a.."));
		System.out.println("a...: " + tree.search("a..."));
		tree.preTraverse(tree.getRoot());
		System.out.println();
		// tree.printAllWords();
		
		for (String pre : prefix) {
			int num = tree.countPrefix(pre);
			System.out.println(pre + " " + num);
		}
	}
}
