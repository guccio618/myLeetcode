public class Le_211_Add_and_Search_Word_Data_structure_design {
	// 注意此题“.”号的处理！！！
	
	private TrieNode root = new TrieNode();

	// Adds a word into the data structure.
	public void addWord(String word) {
		char[] letters = word.toCharArray();
		int n = letters.length;
		TrieNode node = root;

		for (int i = 0; i < n; i++) {
			int pos = (int) (letters[i] - 'a');
			if (node.child[pos] == null) {
				node.child[pos] = new TrieNode();
				node.child[pos].val = letters[i];
			}
			node = node.child[pos];
		}

		node.isWord = true;
	}

	// Returns if the word is in the data structure. A word could
	// contain the dot character '.' to represent any one letter.
	public boolean search(String word) {
		char[] letters = word.toCharArray();
		int n = letters.length;
		TrieNode node = root;

		return searchHelper(node, letters, 0);
	}

	public boolean searchHelper(TrieNode node, char[] letters, int pos) {
		if (pos == letters.length) {
			return node.isWord;
		}

		if (letters[pos] != '.') {
			int n = letters[pos] - 'a';
			if (node.child[n] != null) {
				return searchHelper(node.child[n], letters, pos + 1);
			} else {
				return false;
			}
		} else {
			boolean flag = false;
			for (int i = 0; i < 26; ++i) {
				if (node.child[i] != null) {
					flag = searchHelper(node.child[i], letters, pos + 1);
					if (flag == true) {
						return true;
					}
				}
			}
			return flag;
		}
	}
}

class TrieNode {
	TrieNode[] child;
	char val;
	boolean isWord;

	public TrieNode() {
		child = new TrieNode[26];
		isWord = false;
	}
}
