
public class Le_243_Shortest_Word_Distance {
	public int shortestDistance(String[] words, String word1, String word2) {
		if(words == null || words.length == 0){
            return 0;
        }
        
        int len = words.length;
        int ans = Integer.MAX_VALUE;
        int pos1 = -1, pos2 = -1;

        for(int i = 0; i < len; i++){
            if(words[i].equals(word1)){
                if(pos2 > -1){
                    ans = Math.min(ans, i - pos2);    
                }
                pos1 = i;
            } else if(words[i].equals(word2)){
                if(pos1 > -1){
                    ans = Math.min(ans, i - pos1);
                }
                pos2 = i;
            }
        }        
        
        return ans;
    }
}
