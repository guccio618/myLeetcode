import java.util.*;
/******
 * 
Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

Note:
	The number of people is less than 1,100.

Example
	Input:
		[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
	Output:
		[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

 * 
 * */

public class Q406_Queue_Reconstruction_by_Height {
	public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }
        
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] nums1, int[] nums2) {
            	return (nums1[0] != nums2[0]) ? nums2[0] - nums1[0] : nums1[1] - nums2[1];
            }
        });
        
        List<int[]> ans = new ArrayList<>();
        
        for(int[] elem : people) {
            if(elem[1] >= ans.size()) {
                ans.add(elem);
            } else {
                ans.add(elem[1], elem);
            }
        }
        
        return ans.toArray(new int[people.length][]);
    }
}
