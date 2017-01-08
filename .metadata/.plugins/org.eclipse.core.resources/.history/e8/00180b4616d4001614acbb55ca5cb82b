import java.util.Stack;


public class Q388_Longest_Absolute_File_Path {
	// by other
	public int lengthLongestPath(String input) {
        if(input == null || input.length() == 0){
            return 0;
        }
        
        String[] array = input.split("\n");
        
        if(array.length == 0){
            return 0;
        }
        
        int curLen = 0;
        int maxLen = 0;
        Stack<Integer> stack = new Stack<Integer>();
        
        for(String str : array){
            int level = getLevel(str);
            
            while(stack.size() > level){     // find the parent, using ">" ！！！
                curLen -= stack.pop();
            }
            
            int len = str.replaceAll("\t", "").length() + 1;   // add the "/"
            curLen += len;
            
            if(str.contains(".")){
                maxLen = Math.max(maxLen, curLen - 1);        // delete the first "/"
            }
            
            stack.push(len);
        }
        
        return maxLen;
    }
    
    public int getLevel(String str){
        String newStr = str.replaceAll("\t", "");
        return str.length() - newStr.length();
    }
}
