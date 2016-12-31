import java.util.*;


public class P2_High_5_Average_Score {
	/********************************************************************************************
	 * 那道题的input是一个arraylist，里面每一个element是一个pair，studentid和他的一个score。
	 * code就是要把这个list里面的所有学生的所有分数都读进去 然后计算每一个学生最高5个分数的平均值 然后output一个map key是id value是平均分
	 * 
	 ********************************************************************************************/
	public static Map<Integer, Double> high_5_average_score(List<Pair> list){
		Map<Integer, Double> ans = new HashMap<Integer, Double>();
		
		if(list == null || list.size() == 0){
			return ans;
		}
		
		Map<Integer, PriorityQueue<Double>> map = new HashMap<Integer, PriorityQueue<Double>>();
		
		for(Pair p : list){
			if(map.containsKey(p.id)){
				map.get(p.id).offer(p.score);
				
				if(map.get(p.id).size() > 5) {
					map.get(p.id).poll();
				}
			} else {
				PriorityQueue<Double> minHeap = new PriorityQueue<Double>(5, new Comparator<Double>(){
					@Override
					public int compare(Double score1, Double score2){
						return Double.compare(score1, score2);
					}
				});
				
				minHeap.offer(p.score);				
				map.put(p.id, minHeap);
			}
		}
		
		for(Map.Entry<Integer, PriorityQueue<Double>> entry: map.entrySet()){
			int id = entry.getKey();
			PriorityQueue<Double> minHeap = entry.getValue();
			double sum = 0;			
			int size = Math.min(5, minHeap.size());
			
			for(int i = 0; i < size; i++) {
				sum += minHeap.poll();
			}		
			
			ans.put(id, sum / size);
		}
		
		return ans;
	}	
	
	
	
	public static void main(String[] args){
		P2_High_5_Average_Score t = new P2_High_5_Average_Score();
		List<Pair> list = new ArrayList<Pair>();
		list.add(new Pair(1, 90));
		list.add(new Pair(2, 91));
		list.add(new Pair(3, 92));
		
		list.add(new Pair(1, 80));
		list.add(new Pair(2, 81));
		list.add(new Pair(3, 82));
		
		list.add(new Pair(1, 70));
		list.add(new Pair(2, 71));
		list.add(new Pair(3, 72));
		
		list.add(new Pair(1, 60));
		list.add(new Pair(2, 61));
		list.add(new Pair(3, 62));
		
		list.add(new Pair(1, 50));
		list.add(new Pair(2, 51));
		list.add(new Pair(3, 52));
		
		Map<Integer, Double> ans = t.high_5_average_score(list);
		
		for(int key : ans.keySet()){
			System.out.print(ans.get(key) + ", ");
		}
	}
}

class Pair{
	int id;
	double score;
	
	public Pair(int id, double score){
		this.id = id;
		this.score = score;
	}
}
