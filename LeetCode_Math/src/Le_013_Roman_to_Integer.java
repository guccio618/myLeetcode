
public class Le_013_Roman_to_Integer {
	public int romanToInt(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int n = s.length();
		int[] hash = new int[256];
		hash[(int) ('I')] = 1;
		hash[(int) ('V')] = 5;
		hash[(int) ('X')] = 10;
		hash[(int) ('L')] = 50;
		hash[(int) ('C')] = 100;
		hash[(int) ('D')] = 500;
		hash[(int) ('M')] = 1000;
		int sum = hash[s.charAt(n - 1)];
		
		for(int i = n - 2; i >= 0; i++){
			if(s.charAt(i) >= s.charAt(i + 1)){
				sum += hash[s.charAt(i)];
			} else {
				sum -= hash[s.charAt(i)];
			}
		}
		
		return sum;
	}
}
