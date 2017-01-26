import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Li_5_1_Inverted_Index {
	public Map<String, List<Integer>> invertedIndex(List<Document> docs) {
        Map<String, List<Integer>> results = new HashMap<String, List<Integer>>();
        
        for (Document doc : docs) {
            int id = doc.id;
            StringBuffer temp = new StringBuffer("");
            String content = doc.content;
            int n = content.length();
            
            for (int i = 0; i < n; ++i) {
                if (content.charAt(i) == ' ') {
                    insert(results, temp.toString(), id);
                    temp = new StringBuffer("");
                } else {
                    temp.append(content.charAt(i));
                }
            }
            insert(results, temp.toString(), id);
        }
        
        return results;
    }

    public void insert(Map<String, List<Integer>> rt, String tmp, int id) {
        if (tmp.equals("") || tmp == null){
            return;
        }
        if (!rt.containsKey(tmp)) {
            rt.put(tmp, new ArrayList<Integer>());
        }
        if(!rt.get(tmp).contains(id)){
        	rt.get(tmp).add(id);
        }
    }
}


class Document {
	public int id;
	public String content;
}
