import java.util.*;

public class Q444_Sequence_Reconstruction {
	public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        Map<Integer, Integer> degreeMap = new HashMap<>();
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int[] seq : seqs) {
            if(seq.length == 1) {
                if(!graph.containsKey(seq[0])) {
                    graph.put(seq[0], new HashSet<>());
                    degreeMap.put(seq[0], 0);
                }
            } else {
                for(int i = 0; i < seq.length - 1; i++) {
                    if(!graph.containsKey(seq[i])) {
                        graph.put(seq[i], new HashSet<>());
                        degreeMap.put(seq[i], 0);
                    }
                    
                    if(!graph.containsKey(seq[i + 1])) {
                        graph.put(seq[i + 1], new HashSet<>());
                        degreeMap.put(seq[i + 1], 0);
                    }
                    
                    if(!graph.get(seq[i]).contains(seq[i + 1])) {
                        graph.get(seq[i]).add(seq[i + 1]);
                        degreeMap.put(seq[i + 1], degreeMap.get(seq[i + 1]) + 1);
                    }
                }
            }
        }
        
        for(int key : graph.keySet()) {
            if(degreeMap.get(key) == 0) {
                queue.offer(key);
            }
        }
        
        int index = 0;
        
        while(!queue.isEmpty()) {
            if(queue.size() > 1) {
                return false;
            }
            
            int node = queue.poll();
            
            if(index == org.length || node != org[index++]) {
                return false;
            }
            
            for(int next : graph.get(node)) {
                int count = degreeMap.get(next);
                
                if(count == 1) {
                    degreeMap.remove(next);
                    queue.offer(next);
                } else {
                    degreeMap.put(next, count - 1);
                }
            }
        }
        
        return index == org.length && index == graph.size();
    }
}
