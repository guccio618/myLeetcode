import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;


public class Li_2_4_Mini_Cassandra {
	private Map<String, NavigableMap<Integer, String>> hash;
    
	public Li_2_4_Mini_Cassandra() {
        hash = new HashMap<String, NavigableMap<Integer, String>>();
    }

    public void insert(String raw_key, int column_key, String column_value) {
        if (!hash.containsKey(raw_key))
            hash.put(raw_key, new TreeMap<Integer, String>());
        hash.get(raw_key).put(column_key, column_value);
    }

    public List<Column> query(String raw_key, int column_start, int column_end) {
        List<Column> rt = new ArrayList<Column>();
        if (!hash.containsKey(raw_key))
            return rt;
        for (Map.Entry<Integer, String> entry : 
                hash.get(raw_key).subMap(column_start, true, column_end, true).entrySet()) {
            rt.add(new Column(entry.getKey(), entry.getValue()));
        }
        return rt;
    }
}

class Column {
	public int key;
	public String value;
	public Column(int key, String value) {
		this.key = key;
		this.value = value;
	}
}

