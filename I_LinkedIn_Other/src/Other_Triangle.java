import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Other_Triangle {
	public boolean canFormTriangle(int a, int b, int c) {
		if(a <= 0 || b <= 0 || c <= 0) {
			return false;
		}
		
		if(a + b > c || a + c > b || b + c > a) {
			return true;
		} else {
			return false;
		}
	}
	
	
	// test case:
	// nums is empty
	// the number of element in nums is less than 3
	// nums may contain duplicate

	public int findNumberOfTriangles(int[] nums) {
		if(nums == null || nums.length < 3) {
			return 0;
		}
		
		Arrays.sort(nums);
		int len = nums.length;
		int totalCount = ( len * (len - 1) * (len - 2) ) / (3 * 2 * 1);
		int nonTriangleCount = 0;
		
		for(int i = len - 1; i > 1; i--) {
			int left = 0, right = i - 1;
			
			while(left < right) {
				if(nums[left] + nums[right] > nums[i]) {
					right--;
				} else {
					nonTriangleCount += right - left;
					left++;
				}
			}
		}
		
		return totalCount - nonTriangleCount;
	}
	
	
	public int findNumberOfTriangles2(int[] nums) {
		if(nums == null || nums.length < 3) {
			return 0;
		}
		
        int n = nums.length;
        Arrays.sort(nums);
        int count = 0;

        for (int i = 0; i < n - 2; ++i) {
            for (int j = i+1; j < n-1; ++j) {
            	int k = i + 2;
            	
                while (k < n && nums[i] + nums[j] > nums[k]) {
                    k++;
                }

                count += k - j - 1;
            }
        }
        
        return count;
    }
	
	public List<int[]> findTriangles(int[] nums) {
		List<int[]> ans = new ArrayList<int[]>();
		
		if(nums == null || nums.length < 3) {
			return ans;
		}
		
		Arrays.sort(nums);
		int n = nums.length;
		
		for(int i = 0; i < n-2; i++) {
			for(int j = i+1; j < n-1; j++) {
				int sum = nums[i] + nums[j];
				int index = findPosition(nums, j+1, n-1, sum);
				
				for(int k = j + 1; k <= index; k++) {
					ans.add(new int[]{nums[i], nums[j], nums[k]});
				}
			}
		}
		
		return ans;
	}
	
	// find the last pos of element which is smaller than target
	public int findPosition(int[] nums, int start, int end, int target) {
		while(start + 1 < end) {
			int mid = start + (end - start) / 2;
			
			if(nums[mid] < target) {
				start = mid;
			} else {
				end = mid;
			}
		}
		
		if(nums[end] < target) {
			return end;
		} else if(nums[start] < target) {
			return start;
		} else {
			return start - 1;
		}
	}
	
	
	public static void main(String[] args) {
		Other_Triangle t = new Other_Triangle();
		int[] nums = {10, 21, 22, 100, 101, 200, 300};
		int[] nums2 = {23,36,26,11,35,66,78};
		int[] nums3 = {1,2,3,4,5};
		int[] nums4 = {50,51,52,53,54};
		
		int[] target = nums4;
		
		System.out.println(t.findNumberOfTriangles(target));
		System.out.println(t.findNumberOfTriangles2(target));
		
		List<int[]> list = t.findTriangles(target);
		System.out.println(list.size());
		for(int[] array : list) {
			System.out.println(array[0] + ", " + array[1] + ", " + array[2]);
		}
	}
}
