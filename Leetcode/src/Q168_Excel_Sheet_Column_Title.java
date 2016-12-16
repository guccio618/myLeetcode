
public class Q168_Excel_Sheet_Column_Title {
	// by Jackie
	public String convertToTitle(int n) {
        if(n <= 0) return null;
        StringBuffer res = new StringBuffer();
        while(n > 0){
            char c = (char) ((n-1)%26 + 'A');
            res.insert(0, c);
            n = (n-1)/26;
        }
        return res.toString();
    }
	
	public static void main(String[] args){
		Q168_Excel_Sheet_Column_Title t = new Q168_Excel_Sheet_Column_Title();
		System.out.println(t.convertToTitle(728));
	}
}
