import java.util.*;


public class Q10_2_TopKVoter {
	private Map<Integer, Pair> candidateMap;
	private Queue<Pair> heap;
	
	public Q10_2_TopKVoter() {
		candidateMap = new HashMap<>();
		heap = new PriorityQueue<>(1, new Comparator<Pair>() {
			@Override
			public int compare(Pair p1, Pair p2) {
				return p2.count - p1.count;
			}
		});
	}
	
	public void addVote(Vote v) {
		if(!candidateMap.containsKey(v.candidate)) {
			Pair p = new Pair(v.candidate, 1);
			candidateMap.put(v.candidate, p);			
			heap.offer(p);
		} else {
			Pair p = candidateMap.get(v.candidate);
			heap.remove(p);
			p.count++;
			candidateMap.put(v.candidate, p);
			heap.offer(p);
		}		
	}
	
	public void printTopKVote(int k) {
		Queue<Pair> tempHeap = new PriorityQueue<>(heap);
		
		for(int i = 0; i < k; i++) {
			System.out.println(tempHeap.poll().candidate);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	/******************************* main function ************************************/
	
	public static void main(String[] args) {
		Q10_2_TopKVoter t = new Q10_2_TopKVoter();
		t.addVote(new Vote(1, 1));
		t.addVote(new Vote(1, 6));
		t.addVote(new Vote(2, 2));
		t.addVote(new Vote(2, 5));
		t.addVote(new Vote(3, 3));
		t.addVote(new Vote(3, 4));		
		t.addVote(new Vote(3, 7));
		t.addVote(new Vote(15, 8));
		t.printTopKVote(2);
	}
	
	
	
	
	class Pair {
		int candidate;
		int count;
		
		public Pair(int candidate, int count) {
			this.candidate = candidate;
			this.count = count;
		}
	}
	
	
}

class Vote {
	int candidate;
	int timeStamp;
	
	public Vote(int candidate, int timeStamp) {
		this.candidate = candidate;
		this.timeStamp = timeStamp;
	}
}
