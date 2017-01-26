import java.util.ArrayList;
import java.util.List;
/*******
 * 
Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
You should pack your words in a greedy approach; that is, pack as many words as you can in each line. 
Pad extra spaces ' ' when necessary so that each line has exactly L characters.
Extra spaces between words should be distributed as evenly as possible. 
If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
	words: ["This", "is", "an", "example", "of", "text", "justification."]
	L: 16.

	Return the formatted lines as:
	[
   		"This    is    an",
   		"example  of text",
   		"justification.  "
	]
	
Note: 
	Each word is guaranteed not to exceed L in length.
	
 * 
 * */

public class Le_068_Text_Justification {
	// test case:
    // 		words is empty
    // 		maxWidth is less than 1
    // 		words contains element whose length is larger than maxWidth
    // 		words contains element whose length is 0
    
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        
        if(words == null || words.length == 0 || maxWidth <= 0){
            ans.add("");
            return ans;
        }
        
        StringBuilder blankBuilder = new StringBuilder();
        int len = words.length;
        
        for(int i = 0; i < maxWidth; i++) {
            blankBuilder.append(" ");
        }
        
        String pads = blankBuilder.toString();
        int sum = 0;
        
        for(int i = 0, j = 0; i < len; i = j) {
            sum = words[i].length();
            
            for(j = i + 1; j < len && sum + words[j].length() + j - i <= maxWidth; j++) {
                sum += words[j].length();
            }
            
            StringBuilder builder = new StringBuilder();
            int addWordNum = j - i - 1;
            int blankForEachWord = (j == len || 0 == addWordNum) ? 1 : (maxWidth - sum) / addWordNum;
            int additionalBlank = (j == len || 0 == addWordNum) ? 0 : maxWidth - sum - addWordNum * blankForEachWord;
            
            for(int k = i; k < j - 1; k++) {
                builder.append(words[k]);
                builder.append(pads.substring(0, (k - i < additionalBlank) ? blankForEachWord + 1 : blankForEachWord));
            }
            
            builder.append(words[j - 1]);
            
            if(j == len || 0 == addWordNum) {   // deal with special case
                builder.append(pads.substring(0, maxWidth - sum - addWordNum));
            }
            
            ans.add(builder.toString());
        }
        
        return ans;
    }
	
	
    
    
    
    
    
    
    
    
    
    
    
    
	
	/************************* main function **************************/
    
	public List<String> fullJustify2(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<String>();
        if(words == null || words.length == 0 || maxWidth <= 0){
            return ans;
        }
        
        int n = words.length;
        int index = 0;
        
        while(index < n){
            int currentLen = 0;
            List<String> list = new ArrayList<String>();
            
            while(index < n && currentLen < maxWidth){
                if(currentLen + words[index].length() <= maxWidth){
                    list.add(words[index]);
                    currentLen += words[index].length();
                    index++; 
                    if(index == n){
                    	ans.add(justifyHelper(list, maxWidth, currentLen));
                    }
                } else {
                    ans.add(justifyHelper(list, maxWidth, currentLen));
                    break;
                }
            }
            
            
        }
        
        return ans;
    }
    
    public String justifyHelper(List<String> list, int maxWidth, int currentLen){
        StringBuffer builder = new StringBuffer();
        int leftSpace = maxWidth - currentLen;
        
        if(list.size() == 1){
            builder.append(list.get(0));
            for(int i = 0; i < leftSpace; i++){
                builder.append(" ");
            }
        } else {
            int slot = list.size() - 1;
            int time = leftSpace / slot;
            int count = leftSpace - time * slot;
            StringBuffer space1 = new StringBuffer();
            StringBuffer space2 = new StringBuffer();
            
            for(int i = 0; i < time; i++){
                space1.append(" ");
                space2.append(" ");
            }
            space2.append(" ");
            
            for(int i = 0; i < list.size() - 1; i++){
                if(count > 0){
                    builder.append(list.get(i)).append(space2);
                    count--;
                } else {
                    builder.append(list.get(i)).append(space1);
                }
            }
            builder.append(list.get(list.size() - 1));
        }
        
        return builder.toString();
    }
    
    
    
    public static void main(String[] args){
    	Le_068_Text_Justification t = new Le_068_Text_Justification();
    	String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
    	int maxWidth = 16;
    	List<String> ans = t.fullJustify(words, maxWidth);
    	
    	for(int i = 0; i < ans.size(); i++){
    		System.out.println(ans.get(i));
    	}
    }
}
