import java.util.*;

/******
 * 
Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.


Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.


Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.

 * 
 * */

public class Q451_Sort_Characters_By_Frequency {
	public String frequencySort(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }
        
        int[] hash = new int[256];
        Node[] array = new Node[256];
        
        for(char c : s.toCharArray()) {
            hash[c]++;
        }
        
        for(int i = 0; i < 256; i++) {
            array[i] = new Node((char) i, hash[i]);    
        }
        
        Arrays.sort(array, new Comparator<Node>(){
            public int compare(Node n1, Node n2) {
                return n2.frequency - n1.frequency;
            }
        });
        
        StringBuilder sb = new StringBuilder();
        
        for(Node n : array) {
            for(int i = 0; i < n.frequency; i++) {
                sb.append(n.c);
            }
        }
        
        return sb.toString();
    }
    
    class Node{
        char c;
        int frequency;
        
        public Node(char c, int frequency) {
            this.c = c;
            this.frequency = frequency;
        }
    }
}
