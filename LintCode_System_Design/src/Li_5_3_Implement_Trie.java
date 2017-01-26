public class Li_5_3_Implement_Trie {
	private TrieNode1 root;

	public Li_5_3_Implement_Trie() {
		root = new TrieNode1();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
		root.insert(word, 0);
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		TrieNode1 node = root.find(word, 0);
		return (node != null && node.hasWord);
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		TrieNode1 node = root.find(prefix, 0);
		return node != null;
	}
}

class TrieNode1 {
	TrieNode1[] children;
	public boolean hasWord;

	// Initialize your data structure here.
	public TrieNode1() {
		children = new TrieNode1[26];
		hasWord = false;
	}

	public void insert(String word, int index) {
		if (index == word.length()) {
			this.hasWord = true;
			return;
		}

		int pos = word.charAt(index) - 'a';
		if (children[pos] == null) {
			children[pos] = new TrieNode1();
		}
		children[pos].insert(word, index + 1);
	}

	public TrieNode1 find(String word, int index) {
		if (index == word.length()) {
			return this;
		}

		int pos = word.charAt(index) - 'a';
		if (children[pos] == null) {
			return null;
		}
		return children[pos].find(word, index + 1);
	}
}
