import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Q121_Word_Lader_II {
	// by other using BFS
	public List<List<String>> findLadders(String start, String end,
			Set<String> dict) {
		List<List<String>> res = new ArrayList<List<String>>();
		if (start == null || end == null || start.length() == 0
				|| end.length() == 0) {
			return res;
		}
		int len = start.length();
		HashMap<String, Integer> visited = new HashMap<String, Integer>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(new TreeNode(start, null));
		visited.put(start, 0);
		int level = 0;
		boolean found = false;

		while (!queue.isEmpty()) {
			if (found) {
				return res;
			}
			int size = queue.size();
			for (int i = 0; i < size; ++i) {
				TreeNode node = queue.poll();
				String word = node.val;
				ArrayList<String> list = new ArrayList<String>();
				if (word.equals(end)) {
					found = true;
					while (node != null) {
						list.add(0, node.val);
						node = node.parent;
					}
					res.add(list);
				} else {
					if (found) {
						continue;
					}
					char[] array = word.toCharArray();
					for (int j = 0; j < word.length(); ++j) {
						char temp = array[j];
						for (char k = 'a'; k <= 'z'; ++k) {
							if (k == array[j]) {
								continue;
							}
							array[j] = k;
							String newWord = new String(array);
							if (dict.contains(newWord)
									&& (!visited.containsKey(newWord) || visited
											.get(newWord) == level)) {
								visited.put(newWord, level);
								queue.offer(new TreeNode(newWord, node));
							}
						}
						array[j] = temp;
					}
				}
			}
			level++;
		}
		return res;
	}

	private class TreeNode {
		protected String val;
		protected TreeNode parent;

		public TreeNode(String v, TreeNode p) {
			val = v;
			parent = p;
		}
	}
}
