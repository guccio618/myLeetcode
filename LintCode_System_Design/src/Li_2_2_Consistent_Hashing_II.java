import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class Li_2_2_Consistent_Hashing_II {
	/*****************************************************************************************************
	 * 在 Consistent Hashing I 中我们介绍了一个比较简单的一致性哈希算法，这个简单的版本有两个缺陷：
	 * 		(1). 增加一台机器之后，数据全部从其中一台机器过来，这一台机器的读负载过大，对正常的服务会造成影响。
	 * 		(2). 当增加到3台机器的时候，每台服务器的负载量不均衡，为1:1:2。
	 * 
	 * 为了解决这个问题，引入了 micro-shards 的概念，一个更好的算法是这样：
	 * 		(1). 将 360° 的区间分得更细。从 0~359 变为一个 0 ~ n-1 的区间，将这个区间首尾相接，连成一个圆。
	 * 			 当加入一台新的机器的时候，随机选择在圆周中撒 k 个点，代表这台机器的 k 个 micro-shards。
	 * 			 每个数据在圆周上也对应一个点，这个点通过一个 hash function 来计算。一个数据该属于那台机器负责管理，
	 * 			 是按照该数据对应的圆周上的点在圆上顺时针碰到的第一个 micro-shard 点所属的机器来决定。
	 * 			 n 和 k在真实的 NoSQL 数据库中一般是 2^64 和 1000。
	 * 
	 ******************************************************************************************************/
	
	public int n, k;
    public List<Integer> ids = null;
    public Map<Integer, List<Integer>> machines = null;

    // @param n a positive integer
    // @param k a positive integer
    // @return a Solution object
    public static Li_2_2_Consistent_Hashing_II create(int n, int k) {
        // Write your code here
    	Li_2_2_Consistent_Hashing_II solution = new Li_2_2_Consistent_Hashing_II();
        solution.n = n;
        solution.k = k;
        solution.ids = new ArrayList<Integer>();
        solution.machines = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; ++i)
            solution.ids.add(i);
        return solution;
    }

    // @param machine_id an integer
    // @return a list of shard ids
    public List<Integer> addMachine(int machine_id) {
        // Write your code here
        Random ra =new Random();
        List<Integer> random_nums = new ArrayList<Integer>();
        for (int i = 0; i < k; ++i) {
            int index = ra.nextInt(ids.size());
            random_nums.add(ids.get(index));
            ids.remove(index);
        }

        Collections.sort(random_nums);
        machines.put(machine_id, random_nums);
        return random_nums;
    }

    // @param hashcode an integer
    // @return a machine id
    public int getMachineIdByHashCode(int hashcode) {
        // Write your code here
        int distance = n + 1;
        int machine_id = 0;
        for (Map.Entry<Integer, List<Integer>> entry : machines.entrySet()) {
            int key = entry.getKey();
            List<Integer> random_nums = entry.getValue();
            for (Integer num : random_nums) {
                int d = num - hashcode;
                if (d < 0)
                    d += n;
                if (d < distance) {
                    distance = d;
                    machine_id = key;
                }
            }
        }
        return machine_id;
    }
}
