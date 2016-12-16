import java.util.HashMap;
import java.util.Map;


public class Q000_Data_Structure_Map {
	public static void main(String[] args){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int num = 1;
		
		map.put(num, map.getOrDefault(num, 0) + 1);    // 找default值
		
		for(Map.Entry<Integer, Integer> entry : map.entrySet()){
			// 遍历： entry.getKey(), entry.getValue();
		}
		
		// Arrays.hashCode();
	}
}
