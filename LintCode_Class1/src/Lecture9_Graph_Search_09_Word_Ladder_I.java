import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Lecture9_Graph_Search_09_Word_Ladder_I {
	public int ladderLength(String start, String end, Set<String> dict) {
		if (dict == null || dict.size() == 0 || start.equals(end)) {
			return 0;
		}
		Queue<String> q = new LinkedList<String>();
		Set<String> set = new HashSet<String>();
		q.offer(start);
		dict.add(end);
		set.add(start);
		int length = 0;

		while (!q.isEmpty()) {
			length++;
			int size = q.size();

			for (int i = 0; i < size; ++i) {
				String word = q.poll();
				for (String nextWord : findWordRange(word, dict)) {
					if (nextWord.equals(end)) {
						return length;
					} else if (set.contains(nextWord)) {
						continue;
					} else {
						q.offer(nextWord);
						set.add(word);
					}
				}
			}
		}
		return 0;
	}

	public ArrayList<String> findWordRange(String word, Set<String> dict) {
		ArrayList<String> wordList = new ArrayList<String>();
		char[] str = word.toCharArray();
		int len = word.length();

		for (int i = 0; i < len; ++i) {
			char tempChar = str[i];
			for (char c = 'a'; c <= 'z'; ++c) {
				if (str[i] == c) {
					continue;
				}
				str[i] = c;
				String newWord = new String(str);
				if (dict.contains(newWord)) {
					wordList.add(newWord);
				}
			}
			str[i] = tempChar;
		}
		return wordList;
	}
}
