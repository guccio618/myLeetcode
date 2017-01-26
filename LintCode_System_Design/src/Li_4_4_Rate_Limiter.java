import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Li_4_4_Rate_Limiter {
	private HashMap<String, List<Integer>> map = new HashMap<String , List<Integer>>();
	
	public boolean isRatelimited(int timestamp, String event, String rate, boolean increment) {
        int start = rate.indexOf("/");
        int total_time = Integer.parseInt(rate.substring(0, start));
        String type = rate.substring(start + 1, rate.length());

        int time = 1;
        if (type.equals("m"))
            time = time * 60;
        else if (type.equals("h"))
            time = time * 60 * 60;
        else if (type.equals("d"))
            time = time * 60 * 60 * 24;
        int last_time = timestamp - time + 1;
        
        if (!map.containsKey(event))
            map.put(event, new ArrayList<Integer>());

        boolean rt = find_event(map.get(event), last_time) < total_time;
        if (increment && rt)
            insert_event(map.get(event), timestamp);
        return rt;
    }

    public void insert_event(List<Integer> event, int timestamp) {
        event.add(timestamp);
    }

    public int find_event(List<Integer> event, int last_time) {
        int l = 0, r = event.size() - 1;
        if (r == -1)
            return 0;
        if (event.get(r) < last_time) 
            return 0;
        int ans = 0;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (event.get(mid) >= last_time) {
                ans = mid;
                r = mid - 1;
            } else
                l = mid + 1;
        }
        return event.size() - 1 - ans + 1;
    }
}
