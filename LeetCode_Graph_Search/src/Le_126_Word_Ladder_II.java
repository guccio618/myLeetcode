import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
/******
 * 
Given two words (beginWord and endWord), and a dictionary's word list, 
find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list

For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
Note:
All words have the same length.
All words contain only lowercase alphabetic characters.
 * 
 * */

public class Le_126_Word_Ladder_II {
	// test case: 
    // beginWord == null or endWord == null
    // beginWord == endWord
    // wordList is empty
    // beginWord cannot been transfered to endWord

	
	// using DFS, BFS
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
    	List<List<String>> ans = new LinkedList<>();
    	
    	if(beginWord == null || endWord == null || wordList == null || wordList.size() == 0) {
            return ans;
        } else if(beginWord.equals(endWord)) {
            return ans;
        }
    	
        HashMap<String, List<String>> nextWordMap = new HashMap<>();
        Set<String> level1 = new HashSet<>();
        Set<String> level2 = new HashSet<>();
        level1.add(beginWord); 
        level2.add(endWord);
        BFS(level1, level2, nextWordMap, wordList, true);

        List<String> path = new LinkedList<>();
        path.add(beginWord);
        
        DFS(beginWord, endWord, nextWordMap, path, ans);
        return ans;
    }

    public void BFS(Set<String> level1, Set<String> level2, Map<String, List<String>> nextWordMap, Set<String> wordList, boolean forward) {
        if(level1.size() > level2.size()) {
            BFS(level2, level1, nextWordMap, wordList, !forward);
            return ;
        }
        
        wordList.removeAll(level1);    // 注意这里需要removeAll, 去除已经访问过的string ！！！
        wordList.removeAll(level2);	   // 注意这里需要removeAll, 去除已经访问过的string ！！！
        Set<String> nextLevel = new HashSet<>();
        boolean connected = false;
        
        for(String word : level1) {
            char[] letters = word.toCharArray();
            
            for(int i = 0; i < letters.length; i++) {
                char temp = letters[i];
                
                for(char c = 'a'; c <= 'z'; c++) {
                    if (c == temp) {
                        continue;
                    }
                    
                    letters[i] = c;
                    String newWord = new String(letters);
        
                    if (level2.contains(newWord) || (!connected && wordList.contains(newWord))) {
                        if (level2.contains(newWord)) {
                            connected = true;
                        } else {
                            nextLevel.add(newWord);
                        }

                        String curWord = forward ? word : newWord;
                        String nextWord = forward ? newWord : word;     
                        List<String> nextList = nextWordMap.getOrDefault(curWord, new LinkedList<>());
                        nextList.add(nextWord);
                        nextWordMap.put(curWord, nextList);
                    }
                }
                
                letters[i] = temp;
            }
        }
        
        if(!connected && !nextLevel.isEmpty()) {
            BFS(nextLevel, level2, nextWordMap, wordList, forward);
        }
    }
    
    public void DFS(String curWord, String endWord, Map<String, List<String>> nextWordMap, List<String> path, List<List<String>> ans) {
        if(curWord.equals(endWord)) {
            ans.add(new LinkedList<String>(path));
            return;
        } else if(!nextWordMap.containsKey(curWord)) {
            return;
        }
        
        for(String nextWord : nextWordMap.get(curWord)) {
            path.add(nextWord);
            DFS(nextWord, endWord, nextWordMap, path, ans);
            path.remove(path.size() - 1);
        }
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**************************************************************/
    // by other
    public List<List<String>> findLadders2(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> ans = new LinkedList<>();
        
        if(beginWord == null || endWord == null || wordList == null || wordList.size() == 0) {
            return ans;
        } else if(beginWord.equals(endWord)) {
            return ans;
        }
        
        Map<String, List<String>> prevWordMap = new HashMap<>();
        Map<String, Integer> minDistanceMap = new HashMap<>();
        List<String> path = new LinkedList<>();
        
        BFS(prevWordMap, minDistanceMap, beginWord, wordList);
		DFS(prevWordMap, minDistanceMap, path, ans, beginWord, endWord);
		return ans;
    }
    
    public void BFS(Map<String, List<String>> prevWordMap, Map<String, Integer> minDistanceMap, String beginWord, Set<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        minDistanceMap.put(beginWord, 0);
        
        for(String word : wordList) {
            prevWordMap.put(word, new LinkedList<String>());
        }
        
        while(!queue.isEmpty()) {
            String word = queue.poll();
            
            for(String newWord : Expends(word, wordList)) {
                prevWordMap.get(newWord).add(word);
                
                if(!minDistanceMap.containsKey(newWord)) {
                    minDistanceMap.put(newWord, minDistanceMap.get(word) + 1);
                    queue.offer(newWord);
                }
            }
        }
    }
    
    public List<String> Expends(String word, Set<String> wordList) {
		List<String> list = new LinkedList<String>();
		char[] letters = word.toCharArray();
		char temp = ' ';

		for (int i = 0; i < letters.length; i++) {
			temp = letters[i];

			for (char c = 'a'; c <= 'z'; c++) {
				if (c == temp) {
					continue;
				}

				letters[i] = c;
				String newWord = new String(letters);

				if (wordList.contains(newWord)) {
					list.add(newWord);
				}
			}

			letters[i] = temp;
		}

		return list;
	}
	
	public void DFS(Map<String, List<String>> prevWordMap, Map<String, Integer> minDistanceMap, List<String> path, List<List<String>> ans, String beginWord, String curWord) {
	    path.add(curWord);
	    
	    if(beginWord.equals(curWord)) {
	        Collections.reverse(path);
	        ans.add(new LinkedList<String>(path));
	        Collections.reverse(path);
	    } else {
	        for(String prevWord : prevWordMap.get(curWord)) {
	            if(minDistanceMap.containsKey(prevWord) && minDistanceMap.get(prevWord) + 1 == minDistanceMap.get(curWord)) {
	                DFS(prevWordMap, minDistanceMap, path, ans, beginWord, prevWord);
	            }
	        }
	    }
	    
	    path.remove(path.size() - 1);
	}
    
    
    

	/**************************************************************/
	// by other
	public List<List<String>> findLadders3(String beginWord,
			String endWord, Set<String> wordList) {
		List<List<String>> list = new LinkedList<>();
		int level = 0;
		boolean found = false; // flag used to stop searching for the next level
		Queue<TreeNode> q = new LinkedList<>();
		Map<String, Integer> map = new HashMap<>(); // map records visited node
													// and its level
		q.offer(new TreeNode(beginWord, null)); // beginWord is the root of
												// tree, no parent
		map.put(beginWord, 0);
		while (!q.isEmpty()) {
			if (found)
				return list;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				String word = node.val;
				if (word.equals(endWord)) {
					found = true; // mark true so it will go on searching until
									// the end of current level, so all paths
									// are of the same length.
					List<String> ladder = new LinkedList<>();
					while (node != null) {
						ladder.add(0, node.val);
						node = node.parent;
					}
					list.add(ladder);
				} else { // change character one at a time
					if (found) {
						continue;
					}
					char[] wordArray = word.toCharArray();
					for (int j = 0; j < wordArray.length; j++) {
						char c = wordArray[j];
						for (char k = 'a'; k <= 'z'; k++) {
							if (c != k) {
								wordArray[j] = k;
								String newWord = new String(wordArray);
								// if a visited node is at lower level, it won't
								// be added again. Duplicate is allowed ONLY at
								// same level
								if (wordList.contains(newWord)
										&& (!map.containsKey(newWord) || map
												.get(newWord) == level)) {
									map.put(newWord, level);
									TreeNode child = new TreeNode(newWord, node);
									q.offer(child);
								}
							}
						}
						wordArray[j] = c; // change it back before modifying
											// next char
					}
				}
			}
			level++;
		}
		return list;// empty list
	}

	private class TreeNode {
		public String val;
		public TreeNode parent;

		public TreeNode(String v, TreeNode p) {
			val = v;
			parent = p;
		}
	}

	/**************************************************************/
	// by Jackie, but exceed time limited
	private LinkedList<LinkedList<String>> res = new LinkedList<LinkedList<String>>();
	private LinkedList<LinkedList<String>> result = new LinkedList<LinkedList<String>>();
	private int minStep = Integer.MAX_VALUE;

	public LinkedList<LinkedList<String>> findLadders4(String beginWord,
			String endWord, Set<String> wordList) {
		LinkedList<String> path = new LinkedList<String>();
		wordList.add(endWord);
		dfs(beginWord, path, wordList, 1, endWord);
		for (int i = 0; i < res.size(); ++i)
			if (res.get(i).size() == minStep)
				result.add(res.get(i));
		return res;
	}

	public void dfs(String str, LinkedList<String> path, Set<String> wordList,
			int step, String endWord) {
		if (step >= minStep)
			return;
		path.add(str);
		char[] array = str.toCharArray();
		for (int i = 0, len = array.length; i < len; ++i) {
			for (char j = 'a'; j <= 'z'; ++j) {
				char temp = array[i];
				if (array[i] == j)
					continue;
				array[i] = j;
				String newStr = new String(array);
				if (newStr.equals(endWord)) {
					path.add(endWord);
					res.add(new LinkedList<String>(path));
					path.remove(endWord);
					array[i] = temp;
					minStep = Math.min(minStep, step + 1);
					continue;
				}
				if (wordList.contains(newStr)) {
					wordList.remove(newStr);
					dfs(newStr, path, wordList, step + 1, endWord);
					wordList.add(newStr);
				}
				array[i] = temp;
			}
		}
		path.remove(str);
	}

	public static void main(String[] args) {
		Le_126_Word_Ladder_II t = new Le_126_Word_Ladder_II();
		Set<String> wordList = new HashSet<String>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		
		Set<String> wordList2 = new HashSet<String>();
		wordList2.add("hot");
		wordList2.add("dot");
		wordList2.add("dog");
		wordList2.add("lot");
		wordList2.add("log");
		
		
		List<List<String>> res = t.findLadders("hit", "cog", wordList);
		for (int i = 0; i < res.size(); ++i) {
			for (int j = 0; j < res.get(i).size(); ++j) {
				System.out.print(res.get(i).get(j) + ", ");
			}
			System.out.println();
		}
	}
}
