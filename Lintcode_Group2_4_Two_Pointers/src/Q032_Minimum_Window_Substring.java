
public class Q032_Minimum_Window_Substring {
	/****************
	 * Star
	 ****************/
	// by ninechapter， nice
	
	public String minWindow(String source, String target) {
        int ans = Integer.MAX_VALUE;
        String minStr = "";    
        int[] targethash = new int[256];       
        int targetnum = initTargetHash(targethash, target);
        int sourcenum = 0;
        int slower = 0, faster = 0;
        
        for(faster = 0; faster < source.length(); faster++) {
            if(targethash[source.charAt(faster)] > 0){  // 表示target里有这个character
                sourcenum++;
            }
            targethash[source.charAt(faster)]--;
            
            while(sourcenum >= targetnum) {
                if(ans > faster - slower + 1) {
                    ans = Math.min(ans, faster - slower + 1);
                    minStr = source.substring(slower, faster + 1);
                }
                targethash[source.charAt(slower)]++;
                if(targethash[source.charAt(slower)] > 0){  // slower所指的character与faster是成对的，如果大于0表示target里有这个character
                    sourcenum--;                            // 用于区分source里的character是否出现在target里     
                }
                slower++;
            }
        }
        return minStr;
    }
    
    int initTargetHash(int []targethash, String Target) {
        int targetnum = 0 ;
        for (char ch : Target.toCharArray()) {
            targetnum++;
            targethash[ch]++;
        }
        return targetnum;
    }
}
