public class Q299_Bulls_and_Cows {
	/**********************************/
	// by Jackie
	public String getHint(String secret, String guess) {
        if(secret == null || secret.length() == 0 || guess == null || guess.length() == 0){
            return new String();
        }
        
        int n = secret.length();
        char[] array1 = secret.toCharArray();
        char[] array2 = guess.toCharArray();
        if(array1.length != array2.length){
            return new String();
        }
        
        int numA = 0, numB = 0;
        int[] count = new int[10];
        
        for(int i = 0; i < n; ++i){
            if(array1[i] == array2[i]){
                numA++;
            } else {
                count[array1[i] - '0']++;
            }
        }
        
        for(int i = 0; i < n; ++i){
            if(array1[i] != array2[i]){
                int index = array2[i] - '0';
                if(count[index] > 0){
                    count[index]--;
                    numB++;
                }
            } 
        }
        
        StringBuffer sb = new StringBuffer();
        sb.append(numA).append("A").append(numB).append("B");
        return sb.toString();
    }
	
	
	
	/**********************************/
	// by Jackie
	public String getHint2(String secret, String guess) {
		int bulls = 0, cows = 0;
        int[] words = new int[10];

        for(int i = 0, len = secret.length(); i < len; ++i)
            words[secret.charAt(i) - '0']++;
        
        for(int i = 0, len = secret.length(); i < len; ++i){
            char g = guess.charAt(i);
            char s = secret.charAt(i);
            if(g == s){
            	if(words[g - '0'] == 0)
            		cows--;
            	else
            		words[g - '0']--;
            	bulls++;
            }
            else if(words[g - '0'] != 0){
                words[g - '0']--;
                cows++;
            }
        }
        
        String s = new String();
        s = bulls + "A" + cows + "B";        
        return s.toString();
    }
	
	public static void main(String[] args){
		Q299_Bulls_and_Cows t = new Q299_Bulls_and_Cows();
		System.out.println(t.getHint("1121", "0311"));
	}
}
