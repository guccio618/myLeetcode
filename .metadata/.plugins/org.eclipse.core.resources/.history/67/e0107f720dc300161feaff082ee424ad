import java.util.*;

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
