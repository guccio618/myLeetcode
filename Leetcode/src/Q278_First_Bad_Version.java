
public class Q278_First_Bad_Version {
	public boolean[] array = {false, false, false, true};
	
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
	
	public boolean isBadVersion(int version){
		return array[version-1];		
	} 
	
	public static void main(String[] args){
		Q278_First_Bad_Version test = new Q278_First_Bad_Version();
		System.out.println(test.firstBadVersion(4));
	}
}
