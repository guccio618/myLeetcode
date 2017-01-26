/*******
 * 
You are a product manager and currently leading a team to develop a new product. 
Unfortunately, the latest version of your product fails the quality check. 
Since each version is developed based on the previous version, all the versions after a bad version are also bad.
Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. 
Implement a function to find the first bad version. You should minimize the number of calls to the API.

 * 
 * */

public class Le_278_First_Bad_Version {
	// using binary search
	public int firstBadVersion(int n) {
        int start = 1, end = n;
        
        while (start < end-1) {
            int mid = (end - start) / 2 + start;
            
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (isBadVersion(start)) {
            return start;
        }
        
        return end;
    }
	
	
	
	
	
	
	
	
	
	
	/************************** main function ********************************/
	public boolean[] array = {false, false, false, true};
	
	public boolean isBadVersion(int version){
		return array[version-1];		
	} 
	
	public static void main(String[] args){
		Le_278_First_Bad_Version test = new Le_278_First_Bad_Version();
		System.out.println(test.firstBadVersion(4));
	}
}
