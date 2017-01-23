import java.util.*;
/********
 * 
A string such as "word" contains the following abbreviations:

["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
Given a target string and a set of strings in a dictionary, find an abbreviation of this target string with the smallest possible length such that it does not conflict with abbreviations of the strings in the dictionary.

Each number or letter in the abbreviation is considered length = 1. For example, the abbreviation "a32bc" has length = 4.

Note:
	In the case of multiple answers as shown in the second example below, you may return any one of them.
	Assume length of target string = m, and dictionary size = n. You may assume that m ≤ 21, n ≤ 1000, and log2(n) + m ≤ 20.

Examples:
	"apple", ["blade"] -> "a4" (because "5" or "4e" conflicts with "blade")
	"apple", ["plain", "amber", "blade"] -> "1p3" (other valid answers include "ap3", "a3e", "2p2", "3le", "3l1").
	
 * 
 * */

// similar: Le_320, Le_408

public class Q411_Minimum_Unique_Word_Abbreviation {
	// test case: 
	// 	(1): [abc] [""] 
	//  (2): [internationalize], ["xnternationalize", "ixternationalize", "inxernationalize", "intxrnationalize", "intexnationalize"]
	
	public String minAbbreviation(String target, String[] dictionary) {
		if(target == null || target.length() == 0) {
            return "";
        } else if(dictionary == null || dictionary.length == 0) {
        	return Integer.toString(target.length());
        }
        
        Map<String, Integer> dictAbbrMap = new HashMap<>();
        Map<String, Integer> targetAbbrMap = new HashMap<>();
        
        for(String word : dictionary) {
            getAbbr(dictAbbrMap, word, 0, "", 0, 0);
        }
        
        getAbbr(targetAbbrMap, target, 0, "", 0, 0);
        int minLen = Integer.MAX_VALUE;
        String ans = null;
        
        for(Map.Entry<String, Integer> entry : targetAbbrMap.entrySet()) {
            String abbr = entry.getKey();
            int len = entry.getValue();
            
            if(!dictAbbrMap.containsKey(abbr) && minLen > len) {
                minLen = len;
                ans = abbr;
            }
        }
        
        return ans;
    }
    
	// Each number or letter in the abbreviation is considered length = 1, so we should need to used a variable "solutionLen"
    public void getAbbr(Map<String, Integer> map, String word, int pos, String solution, int solutionLen, int count) {
        if(pos == word.length()) {
            solution += (count > 0) ? count : "";
            solutionLen += (count > 0) ? 1 : 0;
            map.put(solution, solutionLen);
            return;
        }
        
        getAbbr(map, word, pos + 1, solution, solutionLen, count + 1);
        getAbbr(map, word, pos + 1, solution + (count > 0 ? count : "") + word.charAt(pos), solutionLen + (count > 0 ? 1 : 0) + 1, 0);
    }
    
    
    
    
    // solution 2: using bit manipulation
    private int minLen;
    private int result;

    public String minAbbreviation2(String target, String[] dictionary) {
        // only keep words whose length == target in new dict, then compute their bit masks
        Set<Integer> maskSet = new HashSet<>();
        
        for(String s: dictionary){
            if(target.length() == s.length()){
                maskSet.add(getBitMask(s,target));
            }
        }

        // dfs with pruning
        minLen = target.length()+1;
        result = -1;

        dfs(target,maskSet,0,0,0);

        if(minLen > target.length()){
            return "";
        }

        // convert result to word
        int zeroCnt = 0;
        String res = "";
        
        for (int i = target.length()-1; i>=0; i--) {
            //遇到0要累加连续零个数,遇到1填原char
            int digit = (result & 1);
            if(digit == 0){
                ++zeroCnt;
            } else {
                if(zeroCnt > 0){
                    res = zeroCnt + res;
                    zeroCnt =0;
                }
                res = target.charAt(i) + res;
            }
            result >>= 1;
        }
        
        if(zeroCnt > 0) res = zeroCnt + res;
        return res;
    }

    /**
     *
     * @param target
     * @param maskSet masks of words in dict
     * @param start idx at target
     * @param curLen current abbr's length
     */
    private void dfs(String target,Set<Integer> maskSet,int start,int curLen,int curResult){
        // pruning, no need to continue, already not min length
        if(curLen >= minLen) return;

        if(start == target.length()){
            // check whether curResult mask conflicts with words in dict
            for(int mask:maskSet){
                /**
                 * 单词manipulation的缩写m2ip6n可以转化为100110000001
                 *  m a n i p u l a t i o n
                    m  2  i p      6      n
                    1 0 0 1 1 0 0 0 0 0 0 1
                 * 0代表随意不care,如果这个mask和dict中某个mask的所有1重合代表在意的位置完全相同,
                 * 说明这个mask和dict中那个词冲突
                 * 我们要找的是不冲突的mask
                 */
                if((curResult & mask) == curResult){
                    return; // conflict
                }
            }
            // no conflict happens, can use
            if(minLen > curLen){
                minLen = curLen;
                result = curResult;
            }
            return;
        }

        // case 1: replace chars from start in target with number
        for (int i = start; i < target.length(); i++) {
            //被replace掉的char位置由0代替所以是curResult<<(i+1-start),没replace掉的这里不管,我们只管到i,之后的由backtrack内决定
            //注意:不允许word => w11d这种用数字代替但含义不同
            if(curLen == 0 || (curResult &1) == 1){
                //后者即上一次是保留了字母
                dfs(target,maskSet,i+1,curLen+1,curResult<<(i+1-start));
            }
        }

        // case 2: no replace from start (curResult << 1)+1代表新的这位保留了char,所以是加一
        dfs(target,maskSet,start+1,curLen+1,(curResult << 1)+1);
    }

    // 比如apple 和 amper 字母相同设1,不同设0,所以得到10100
    private int getBitMask(String s1,String s2){
        int mask = 0;
        for (int i = 0; i < s1.length(); i++) {
            mask <<= 1;
            if(s1.charAt(i) == s2.charAt(i)){
                mask += 1;
            }
        }
        return mask;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    /******************************* main function ***************************************/
    
    public static void main(String[] args) {
    	Q411_Minimum_Unique_Word_Abbreviation t = new Q411_Minimum_Unique_Word_Abbreviation();
    	String[] dictionary = {"aaaaa","bbbbb","ccccc","ddddd","eeeee"};
    	String target = "abcde";
    	System.out.println(t.minAbbreviation(target, dictionary));
    	
    }
}
