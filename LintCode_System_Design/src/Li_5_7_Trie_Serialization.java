import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Stack;
import java.util.TreeMap;


public class Li_5_7_Trie_Serialization {
	public String serialize(TrieNode root) {
        if (root == null) {
            return "";
        }

        StringBuffer sb = new StringBuffer();
        sb.append("<");
        Iterator iter = root.children.entrySet().iterator(); 
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry)iter.next(); 
            Character key = (Character)entry.getKey(); 
            TrieNode child = (TrieNode)entry.getValue();
            sb.append(key);
            sb.append(serialize(child));
        }
        sb.append(">");
        return sb.toString();
    }

    public TrieNode deserialize(String data) {
        if (data == null || data.length() == 0)
            return null;

        TrieNode root = new TrieNode();
        TrieNode current = root;
        Stack<TrieNode> path = new Stack<TrieNode>();
        for (Character c : data.toCharArray()) {
            switch (c) {
            case '<':
                path.push(current);
                break;
            case '>':
                path.pop();
                break;
            default:
                current = new TrieNode();
                path.peek().children.put(c, current);
            }
        }
        return root;
    }
    
    public class TrieNode {
    	public NavigableMap<Character, TrieNode> children;
    	public TrieNode() {
    		children = new TreeMap<Character, TrieNode>();
    	}
	}
}
