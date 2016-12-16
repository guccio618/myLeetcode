
public class Q171_Excel_Sheet_Column_Number {
	// by Jackie
	public int titleToNumber(String s) {
        if(s == null || s.length() == 0) return 0;
        int sum = 0;
        char[] array = s.toCharArray();
        for(char c : array){
            sum = sum * 26 + (c - 'A' + 1);
        }
        return sum;
    }
	
	public static void main(String[] args){
		Q171_Excel_Sheet_Column_Number t = new Q171_Excel_Sheet_Column_Number();
		System.out.println(t.titleToNumber("AAZ"));
	}
}
