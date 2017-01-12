
public class Q074_First_Bad_Version {
	// by other
	public boolean[] array = {false, false, false, true};
	
	public int findFirstBadVersion(int n) {
        int start = 1, end = n;
        while (start < end-1) {
            int mid = start + (end - start) / 2;
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
	
	public boolean isBadVersion(int version){
		return array[version-1];		
	}
}
