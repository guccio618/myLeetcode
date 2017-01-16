import java.util.*;
/********
 * 
Check whether the original sequence org can be uniquely reconstructed from the sequences in seqs. The org sequence is a permutation of the integers from 1 to n, with 1 ≤ n ≤ 104. Reconstruction means building a shortest common supersequence of the sequences in seqs (i.e., a shortest sequence so that all sequences in seqs are subsequences of it). Determine whether there is only one sequence that can be reconstructed from seqs and it is the org sequence.

Example 1:

Input:
org: [1,2,3], seqs: [[1,2],[1,3]]

Output:
false

Explanation:
[1,2,3] is not the only one sequence that can be reconstructed, because [1,3,2] is also a valid sequence that can be reconstructed.

Example 2:

Input:
org: [1,2,3], seqs: [[1,2]]

Output:
false

Explanation:
The reconstructed sequence can only be [1,2].

Example 3:

Input:
org: [1,2,3], seqs: [[1,2],[1,3],[2,3]]

Output:
true

Explanation:
The sequences [1,2], [1,3], and [2,3] can uniquely reconstruct the original sequence [1,2,3].

Example 4:

Input:
org: [4,1,5,2,6,3], seqs: [[5,2,6,3],[4,1,5,2]]

Output:
true

 * 
 * */


public class Le_444_Sequence_Reconstruction {
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
