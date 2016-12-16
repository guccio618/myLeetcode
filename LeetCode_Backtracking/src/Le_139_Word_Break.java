import java.util.HashSet;
import java.util.Set;


public class Le_139_Word_Break {
	// by ninechapter
	public boolean wordBreak(String s, Set<String> wordDict) {
        if(s == null || s.length() == 0){
            return true;
        } 
        
        int n = s.length();
        boolean[] canSplit = new boolean[n + 1];
        canSplit[0] = true;
        int maxLen = getLen(wordDict);
        
        for(int i = 1; i <= n; i++){
            for(int lastWordLen = 1; lastWordLen <= maxLen && i - lastWordLen >= 0; lastWordLen++){
                if(canSplit[i - lastWordLen] == true){   // 重点 ！！！
                    String lastWord = s.substring(i - lastWordLen, i);
                    
                    if(wordDict.contains(lastWord)){
                        canSplit[i] = true;
                        break;
                    }
                }
            }
        }
        
        return canSplit[n];
    }
    
    public int getLen(Set<String> wordDict){
        int len = 0;
        for(String word : wordDict){
            len = Math.max(len, word.length());
        }
        
        return len;
    }
    
    

	public static void main(String[] args) {
		Le_139_Word_Break t = new Le_139_Word_Break();
		Set<String> wordDict = new HashSet<String>();
		wordDict.add("a");
		String s = "a";
		System.out.println(t.wordBreak(s, wordDict));

	}
}
