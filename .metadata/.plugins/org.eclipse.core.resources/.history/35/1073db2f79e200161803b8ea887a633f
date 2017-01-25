import java.util.*;
/*******
 * 
There are N children standing in a line. Each child is assigned a rating value.
You are giving candies to these children subjected to the following requirements:
	1. Each child must have at least one candy.
	2. Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

 * 
 * */

public class Q135_Candy {
	// solution 1: using priority queue, time is(nlogn), space is O(n)
	public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) {
            return 0;
        }
        
        int len = ratings.length;
        int count = len;
        int[] candyCount = new int[len];
        
        Queue<Pair> heap = new PriorityQueue<Pair>(len, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return p1.rating - p2.rating;
            }
        });
        
        for(int i = 0; i < len; i++) {
            heap.offer(new Pair(i, ratings[i]));
        }
        
        while(!heap.isEmpty()) {
            Pair p = heap.poll();
            
            if(heap.size() == len - 1) {
                continue;
            } else {
                if(p.index > 0 && ratings[p.index] > ratings[p.index - 1]) {
                    int diff = Math.max(0, candyCount[p.index - 1] - candyCount[p.index] + 1);
                    candyCount[p.index] += diff;
                    count += diff;
                }
                if(p.index + 1 < len && ratings[p.index] > ratings[p.index + 1]) {
                    int diff = Math.max(0, candyCount[p.index + 1] - candyCount[p.index] + 1);
                    candyCount[p.index] += diff;
                    count += diff;
                }
            }
        }
        
        return count;
    }
    
    class Pair {
        int index;
        int rating;
        
        public Pair(int index, int rating) {
            this.index = index;
            this.rating = rating;
        }
    }
	
	

	// solution 2: time is O(n), space is O(n)
    public int candy2(int[] ratings) {
		if(ratings == null || ratings.length == 0) {
            return 0;
        }
        
        int len = ratings.length;
        int[] candies = new int[len];
        int count = len;   // give each child one candy
        
        // Scan from left to right, to make sure right higher rated child gets 1 more candy than left lower rated child
        for(int i = 1; i < len; i++) {
            if(ratings[i] > ratings[i - 1]) {
                count += candies[i - 1] + 1 - candies[i];
                candies[i] = candies[i - 1] + 1;
            }
        }
        
     // Scan from right to left, to make sure left higher rated child gets 1 more candy than right lower rated child
        for(int i = len - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1]) {
                count += Math.max(candies[i], candies[i + 1] + 1) - candies[i];
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        
        return count;
    } 
}
