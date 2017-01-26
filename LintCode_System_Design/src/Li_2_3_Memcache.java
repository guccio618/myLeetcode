import java.util.HashMap;
import java.util.Map;

public class Li_2_3_Memcache {
	Map<Integer, Resource> client = null;

	public Li_2_3_Memcache() {
		client = new HashMap<Integer, Resource>();
	}

	public int get(int curtTime, int key) {
		if (!client.containsKey(key))
			return Integer.MAX_VALUE;

		Resource res = client.get(key);
		if (res.expired >= curtTime || res.expired == -1)
			return res.value;
		else
			return Integer.MAX_VALUE;
	}

	public void set(int curtTime, int key, int value, int ttl) {
		int expired;
		if (ttl == 0)
			expired = -1;
		else
			expired = curtTime + ttl - 1;
		client.put(key, new Resource(value, expired));
	}

	public void delete(int curtTime, int key) {
		if (!client.containsKey(key))
			return;
		
		client.remove(key);
	}

	public int incr(int curtTime, int key, int delta) {
		if (!client.containsKey(key))
			return Integer.MAX_VALUE;
		
		client.get(key).value += delta;
		return get(curtTime, key);
	}

	public int decr(int curtTime, int key, int delta) {
		if (!client.containsKey(key))
			return Integer.MAX_VALUE;
		
		client.get(key).value -= delta;
		return get(curtTime, key);
	}
}

class Resource {
	public int value;
	public int expired;

	public Resource(int value, int expired) {
		this.value = value;
		this.expired = expired;
	}
}
