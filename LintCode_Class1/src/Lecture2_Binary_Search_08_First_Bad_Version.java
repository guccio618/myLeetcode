
public class Lecture2_Binary_Search_08_First_Bad_Version {
	public int findFirstBadVersion(int n) {
        int start = 1, end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (SVNRepo.isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
            
        if (SVNRepo.isBadVersion(start)) {
            return start;
        }
        return end;
    }
}


class SVNRepo{
	public static boolean isBadVersion(int pos){
		return true;
	}
}
