
public class Q389_Find_the_Difference {
	// by Jackie
	public char findDifferent(String s, String t){
		int[] hash1 = new int[256];
		int[] hash2 = new int[256];
		
		for(char c : s.toCharArray()){
			hash1[c]++;
		}
		
		for(char c : t.toCharArray()){
			hash2[c]++;
		}
		
		for(int i = 0; i < 256; i++){
			if(hash1[i] != hash2[i]){
				return (char) (i);
			}
		}
		
		return ' ';
	}
}
